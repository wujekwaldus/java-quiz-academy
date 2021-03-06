package pl.academy.quiz.service.impl.converter;

import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.academy.quiz.dto.QuestionAreaDTO;
import pl.academy.quiz.dto.QuestionDTO;
import pl.academy.quiz.dto.QuestionOptionDTO;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.QuestionArea;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.service.ObjectConverter;

@Service
public class QuestionToQuestionDtoConverter implements ObjectConverter<Question, QuestionDTO> {

	@Autowired
	private ObjectConverter<QuestionOption, QuestionOptionDTO> optionsConverter;

	@Autowired
	private ObjectConverter<QuestionArea, QuestionAreaDTO> areaConverter;

	@Override
	public QuestionDTO convert(Question model) {
		return QuestionDTO.builder()//
				.id(model.getId())//
				.text(model.getText())//
				.area(areaConverter.convert(model.getArea()))//
				.type(model.getType())//
				.options(new LinkedHashSet<>(optionsConverter.convert(model.getOptions())))//
				.active(model.isActive())//
				.level(model.getLevel())//
				.build();//
	}

}
