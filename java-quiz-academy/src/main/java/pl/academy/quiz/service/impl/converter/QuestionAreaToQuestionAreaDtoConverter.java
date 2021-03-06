package pl.academy.quiz.service.impl.converter;

import org.springframework.stereotype.Service;

import pl.academy.quiz.dto.QuestionAreaDTO;
import pl.academy.quiz.model.QuestionArea;
import pl.academy.quiz.service.ObjectConverter;

@Service
public class QuestionAreaToQuestionAreaDtoConverter implements ObjectConverter<QuestionArea, QuestionAreaDTO> {

	@Override
	public QuestionAreaDTO convert(QuestionArea model) {
		return QuestionAreaDTO.builder().id(model.getId()).name(model.getName()).build();
	}

}
