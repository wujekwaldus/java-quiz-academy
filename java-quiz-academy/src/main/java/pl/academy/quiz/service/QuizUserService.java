package pl.academy.quiz.service;

import java.util.List;

import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.model.QuizUser;

public interface QuizUserService {
	QuizUser save(QuizUser newUser);
	List<QuizResult> getMyTestResults();
}
