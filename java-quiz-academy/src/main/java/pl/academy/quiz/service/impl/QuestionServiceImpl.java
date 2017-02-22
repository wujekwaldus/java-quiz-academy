package pl.academy.quiz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.academy.quiz.command.GetQuizCommand;
import pl.academy.quiz.command.GetUserQuestionsCommand;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.repository.QuestionRepository;
import pl.academy.quiz.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceImpl.class);

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> getRandomQuestions(GetQuizCommand searchCriteria) {
		LOG.info("quizSearchCriteria: {}", searchCriteria);
		Pageable topThree = new PageRequest(0, 3);

		List<Question> result = new ArrayList<>();
		Arrays.stream(searchCriteria.getArea())//
				.forEach(id -> result.addAll(questionRepository.findByCriteria(id, searchCriteria.getLevelAsEnum(), topThree)));

		return result;
	}

	@Override
	public Question saveQuestion(Question question) {
		return questionRepository.saveAndFlush(question);
	}

	@Override
	public Page<Question> getUserQuesions(GetUserQuestionsCommand getUserQuestionCommand) {
		Pageable pageable = new PageRequest(getUserQuestionCommand.getPageNumber(), getUserQuestionCommand.getPageSize(),
				new Sort(Direction.fromString(getUserQuestionCommand.getSortDirection()), getUserQuestionCommand.getSortBy()));
		return questionRepository.findByUser(getUserQuestionCommand.getUser(), pageable);
	}

}
