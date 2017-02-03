package pl.academy.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.model.QuizUser;
import pl.academy.quiz.repository.QuizResultRepository;
import pl.academy.quiz.repository.QuizUserRepository;
import pl.academy.quiz.service.QuizUserService;

@Service
@Transactional
public class QuizUserServiceImpl implements QuizUserService {

	@Autowired
	private QuizUserRepository userRepository;

	@Autowired
	private QuizResultRepository resultRepository;

	@Autowired
	private AuditorAware<QuizUser> auditorAware;

	@Override
	public QuizUser save(QuizUser newUser) {
		return userRepository.saveAndFlush(newUser);
	}

	@Override
	public List<QuizResult> getMyTestResults() {
		return resultRepository.findByUserFetchAnswersOrderByResolveDate(auditorAware.getCurrentAuditor());
	}

}
