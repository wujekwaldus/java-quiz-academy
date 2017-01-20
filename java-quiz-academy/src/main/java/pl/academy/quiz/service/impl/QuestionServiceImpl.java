package pl.academy.quiz.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import pl.academy.quiz.model.Question;
import static pl.academy.quiz.model.Question.QuestionArea.*;

import static pl.academy.quiz.model.Question.QuestionType.*;
import static pl.academy.quiz.model.Question.QuestionLevel.*;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	// TODO: replace with database - test case only
	private List<Question> mockedQuestions;

	@PostConstruct
	public void init() {
		mockedQuestions = new ArrayList<>();
		mockedQuestions.add(new Question(1L, "Question no: 1", SINGLE_CHOICE, JUNIOR, SPRING, 1, generateOptions(4)));
		mockedQuestions.add(new Question(2L, "Question no: 2", SINGLE_CHOICE, MID, HIBERNATE, 1, generateOptions(4)));
		mockedQuestions.add(new Question(3L, "Question no: 3", SINGLE_CHOICE, ADVANCED, CORE_JAVA, 1, generateOptions(4)));
		mockedQuestions.add(new Question(4L, "Question no: 4", MULTIPLE_CHOICE, JUNIOR, CORE_JAVA, 2, generateOptions(4)));
		mockedQuestions.add(new Question(5L, "Question no: 5", MULTIPLE_CHOICE, JUNIOR, DESIGN_PATTERNS, 2, generateOptions(4)));
		mockedQuestions.add(new Question(6L, "Question no: 6", MULTIPLE_CHOICE, JUNIOR, CORE_JAVA, 3, generateOptions(4)));
		mockedQuestions.add(new Question(7L, "Question no: 7", SINGLE_CHOICE, MID, CORE_JAVA, 1, generateOptions(3)));
		mockedQuestions.add(new Question(1L, "Question no: 1", SINGLE_CHOICE, ADVANCED, CORE_JAVA, 1, generateOptions(2)));
		mockedQuestions.add(new Question(8L, "Question no: 8", MULTIPLE_CHOICE, JUNIOR, CORE_JAVA, 2, generateOptions(4)));
		mockedQuestions.add(new Question(9L, "Question no: 9", SINGLE_CHOICE, JUNIOR, CORE_JAVA, 1, generateOptions(2)));
		mockedQuestions.add(new Question(10L, "Question no: 10", SINGLE_CHOICE, MID, MULTITHREADING, 1, generateOptions(2)));
		mockedQuestions.add(new Question(11L, "Question no: 11", MULTIPLE_CHOICE, JUNIOR, CORE_JAVA, 1, generateOptions(3)));
		mockedQuestions.add(new Question(12L, "Question no: 12", SINGLE_CHOICE, ADVANCED, CORE_JAVA, 1, generateOptions(3)));
		mockedQuestions.add(new Question(13L, "Question no: 13", MULTIPLE_CHOICE, ADVANCED, CORE_JAVA, 1, generateOptions(3)));
	}

	private Set<QuestionOption> generateOptions(int size) {
		Set<QuestionOption> options = new LinkedHashSet<>();
		for (int i = 0; i < size; i++) {
			options.add(QuestionOption.builder().text("Option " + i).build());
		}
		return options;
	}

	@Override
	public List<Question> getRandomQuestions() {
		return mockedQuestions;
	}

}
