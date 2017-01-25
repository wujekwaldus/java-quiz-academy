package pl.academy.quiz.service;

import java.util.Map;

import pl.academy.quiz.model.QuizResult;

public interface QuizService {
	QuizResult resolveFromParametersMap(Map<String, String[]> parameters);
}
