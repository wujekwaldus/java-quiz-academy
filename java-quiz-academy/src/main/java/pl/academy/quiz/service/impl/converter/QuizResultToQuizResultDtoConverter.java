package pl.academy.quiz.service.impl.converter;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.academy.quiz.dto.QuizAnswerDTO;
import pl.academy.quiz.dto.QuizResultDTO;
import pl.academy.quiz.model.QuizAnswer;
import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.service.ObjectConverter;

@Service
public class QuizResultToQuizResultDtoConverter implements ObjectConverter<QuizResult, QuizResultDTO> {

	@Autowired
	private ObjectConverter<QuizAnswer, QuizAnswerDTO> answerConverter;

	@Override
	public QuizResultDTO convert(QuizResult model) {
		return QuizResultDTO.builder()//
				.resolveDate(model.getResolveDate())//
				.answers(new ArrayList<>(answerConverter.convert(model.getAnswers())))//
				.build();
	}

}
