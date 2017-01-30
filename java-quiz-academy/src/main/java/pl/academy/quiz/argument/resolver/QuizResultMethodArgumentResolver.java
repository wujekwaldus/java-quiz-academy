package pl.academy.quiz.argument.resolver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.model.QuizAnswer;
import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.repository.QuestionRepository;

public class QuizResultMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1, NativeWebRequest arg2, WebDataBinderFactory arg3)
			throws Exception {
		Map<String, String[]> parameters  = arg2.getParameterMap();
		QuizResult result = new QuizResult();
		parameters.keySet().stream().filter(this::isAnswer)
				.forEach(parameterName -> addAnswersToResult(result, parameterName, parameters.get(parameterName)));
		return result;
	}

	@Override
	public boolean supportsParameter(MethodParameter arg0) {
		return arg0.getParameterType().equals(QuizResult.class);
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
