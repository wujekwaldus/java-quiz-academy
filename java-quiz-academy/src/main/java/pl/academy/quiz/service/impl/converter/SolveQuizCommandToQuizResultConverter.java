package pl.academy.quiz.service.impl.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.academy.quiz.command.SolveQuizCommand;
import pl.academy.quiz.command.SolveQuizCommand.UserAnswer;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.model.QuizAnswer;
import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.repository.QuestionRepository;
import pl.academy.quiz.service.ObjectConverter;

@Service
public class SolveQuizCommandToQuizResultConverter implements ObjectConverter<SolveQuizCommand, QuizResult> {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public QuizResult convert(SolveQuizCommand model) {
		QuizResult result = new QuizResult();
		model.getAnswers().forEach(answer -> addAnswersToResult(answer, result));
		return result;
	}

	private void addAnswersToResult(UserAnswer answer, QuizResult result) {
		Question question = questionRepository.findOneFetchOptions(answer.getQuesionId());
		Set<QuestionOption> userOptions = resolveUserOptions(answer.getAnswerIds(), question);

		result.getAnswers().add(//
				QuizAnswer.builder()//
						.result(result)//
						.question(question)//
						.selectedOptions(userOptions)//
						.build());//

	}

	private Set<QuestionOption> resolveUserOptions(List<Long> answerIds, Question question) {
		List<Long> optionIds = answerIds.stream().filter(e -> e != null).collect(Collectors.toList());
		Set<QuestionOption> userOptions = new HashSet<>(question.getOptions());
		userOptions.removeIf(option -> !optionIds.contains(option.getId()));
		return userOptions;
	}

}
