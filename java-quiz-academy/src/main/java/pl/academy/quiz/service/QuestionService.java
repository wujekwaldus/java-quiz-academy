package pl.academy.quiz.service;

import java.util.List;

import pl.academy.quiz.model.Question;
import pl.academy.quiz.search.criteria.RandomQuizSearchCriteria;

public interface QuestionService {
	List<Question> getRandomQuestions(RandomQuizSearchCriteria quizSearchCriteria);
}
