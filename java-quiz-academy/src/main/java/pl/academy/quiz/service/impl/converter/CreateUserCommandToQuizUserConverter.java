package pl.academy.quiz.service.impl.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.academy.quiz.command.RegisterUserCommand;
import pl.academy.quiz.model.QuizUser;
import pl.academy.quiz.repository.QuizUserRoleRepository;
import pl.academy.quiz.service.ObjectConverter;

@Service
public class CreateUserCommandToQuizUserConverter implements ObjectConverter<RegisterUserCommand, QuizUser> {

	@Autowired
	private QuizUserRoleRepository userRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public QuizUser convert(RegisterUserCommand model) {
		return QuizUser.builder()//
				.email(model.getEmail())//
				.password(passwordEncoder.encode(model.getPassword()))//
				.name(model.getName())//
				.roles(userRoleRepository.findByAuthority("ROLE_USER"))//
				.build();//
	}

}
