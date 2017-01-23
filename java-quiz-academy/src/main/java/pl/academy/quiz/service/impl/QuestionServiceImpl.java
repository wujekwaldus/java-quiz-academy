package pl.academy.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import pl.academy.quiz.model.Question;
import pl.academy.quiz.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	// TODO: replace with database - test case only
	private List<Question> mockedQuestions;

	@PostConstruct
	public void init() {
		mockedQuestions = new ArrayList<>();
	}


	@Override
	public List<Question> getRandomQuestions() {
		return mockedQuestions;
	}

}
