package pl.academy.quiz.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.model.QuizAnswer;
import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.repository.QuestionRepository;
import pl.academy.quiz.repository.QuizResultRepository;
import pl.academy.quiz.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	private static final Logger LOG = LoggerFactory.getLogger(QuizServiceImpl.class);
	
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuizResultRepository quizResultRepository;
	
	@Override
	@Transactional
	public QuizResult resolveFromParametersMap(Map<String, String[]> parameters) {
		QuizResult result = new QuizResult();
		//TODO: spring data-audit
		//TODO: spring-cache
		//TODO: unit tests
		result.setResolveDate(new Date());
		
		parameters.keySet().stream().filter(this::isAnswer)
				.forEach(parameterName -> addAnswersToResult(result, parameterName, parameters.get(parameterName)));
		return quizResultRepository.saveAndFlush(result);
	}

	private boolean isAnswer(String name) {
		return name.startsWith("answer_");
	}

	private void addAnswersToResult(QuizResult result, String parameterName, String[] values) {
		Question question = resolveQuestion(parameterName);
		Set<QuestionOption> userOptions = resolveUserOptions(values, question);

		result.getAnswers().add(//
				QuizAnswer.builder()//
						.result(result)//
						.question(question)//
						.selectedOptions(userOptions)//
						.build());//

	}

	private Set<QuestionOption> resolveUserOptions(String[] values, Question question) {
		List<Long> optionIds = Arrays.stream(values).map(Long::valueOf).collect(Collectors.toList());
		Set<QuestionOption> userOptions = new HashSet<>(question.getOptions());
		userOptions.removeIf(option -> !optionIds.contains(option.getId()));
		return userOptions;
	}

	private Question resolveQuestion(String parameterName) {
		Long questionId = Long.valueOf(parameterName.split("_")[1]);
		Question question = questionRepository.findOneFetchOptions(questionId);
		return question;
	}

}
