package pl.academy.quiz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.academy.quiz.model.QuizUser;
import pl.academy.quiz.repository.QuizUserRepository;
import pl.academy.quiz.service.QuizUserService;

@Service
@Transactional
public class QuizUserServiceImpl implements QuizUserService {

	@Autowired
	private QuizUserRepository userRepository;

	@Override
	public QuizUser save(QuizUser newUser) {
		return userRepository.saveAndFlush(newUser);
	}

}
