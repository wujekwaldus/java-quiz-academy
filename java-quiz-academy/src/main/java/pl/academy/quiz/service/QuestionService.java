package pl.academy.quiz.service;

import java.util.List;

import pl.academy.quiz.model.Question;

public interface QuestionService {
	List<Question> getRandomQuestions();
}
