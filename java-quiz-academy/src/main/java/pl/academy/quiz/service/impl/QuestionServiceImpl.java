package pl.academy.quiz.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.academy.quiz.model.Question;
import pl.academy.quiz.repository.QuestionRepository;
import pl.academy.quiz.search.criteria.RandomQuizSearchCriteria;
import pl.academy.quiz.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceImpl.class);

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> getRandomQuestions(RandomQuizSearchCriteria quizSearchCriteria) {
		LOG.info("quizSearchCriteria: {}", quizSearchCriteria);
		return questionRepository.findAllWithOptionsAndArea();
	}

}
