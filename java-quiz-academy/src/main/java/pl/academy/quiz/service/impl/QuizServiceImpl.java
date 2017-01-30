package pl.academy.quiz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.repository.QuizResultRepository;
import pl.academy.quiz.service.QuizService;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {
	private static final Logger LOG = LoggerFactory.getLogger(QuizServiceImpl.class);
	
	@Autowired
	private QuizResultRepository quizResultRepository;
	
	@Override
	public QuizResult saveQuizeResult(QuizResult quizResult) {
		return quizResultRepository.saveAndFlush(quizResult);
	}

	

}
