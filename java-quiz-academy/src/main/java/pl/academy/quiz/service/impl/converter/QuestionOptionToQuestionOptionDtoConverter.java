package pl.academy.quiz.service.impl.converter;

import org.springframework.stereotype.Service;

import pl.academy.quiz.dto.QuestionOptionDTO;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.service.ModelToDtoConverter;

@Service
public class QuestionOptionToQuestionOptionDtoConverter implements ModelToDtoConverter<QuestionOption, QuestionOptionDTO> {

	@Override
	public QuestionOptionDTO convert(QuestionOption model) {
		return QuestionOptionDTO.builder().id(model.getId()).text(model.getText()).build();
	}

}
