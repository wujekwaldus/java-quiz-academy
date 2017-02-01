package pl.academy.quiz.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import pl.academy.quiz.repository.QuizUserRepository;
import pl.academy.quiz.validation.annotation.UniqueEmail;

@Service
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private QuizUserRepository userRepository;

	@Override
	public void initialize(UniqueEmail arg0) {

	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext ctx) {
		if (StringUtils.isEmpty(email)) {
			ctx.disableDefaultConstraintViolation();
			ctx.buildConstraintViolationWithTemplate("Email nie moze byc pusty").addConstraintViolation();
			return false;
		}
		return userRepository.findByEmailFetchRoles(email) == null;
	}

}
