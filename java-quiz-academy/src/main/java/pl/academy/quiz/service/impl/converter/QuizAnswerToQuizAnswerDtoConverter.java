package pl.academy.quiz.service.impl.converter;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.academy.quiz.dto.QuestionOptionDTO;
import pl.academy.quiz.dto.QuizAnswerDTO;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.model.QuizAnswer;
import pl.academy.quiz.service.ModelToDtoConverter;

@Service
public class QuizAnswerToQuizAnswerDtoConverter implements ModelToDtoConverter<QuizAnswer, QuizAnswerDTO> {

	@Autowired
	private ModelToDtoConverter<QuestionOption, QuestionOptionDTO> optionConverter;

	@Override
	public QuizAnswerDTO convert(QuizAnswer model) {
		return QuizAnswerDTO.builder()//
				.questionText(model.getQuestion().getText())//
				.correct(calculateCorrectness(model))//
				.selected(new ArrayList<>(optionConverter.convert(model.getSelectedOptions())))//
				.build();
	}

	private boolean calculateCorrectness(QuizAnswer model) {
		int availablePoints = model.getQuestion().getAvailablePoints();
		int scoredPoints = model.getSelectedOptions().stream().map(QuestionOption::getPoints)
				.collect(Collectors.summingInt(Integer::valueOf));
		return (availablePoints == scoredPoints) && (availablePoints == model.getSelectedOptions().size());
	}

}
