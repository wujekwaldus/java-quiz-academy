package pl.academy.quiz.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import pl.academy.quiz.command.UserRegistrationCommand;
import pl.academy.quiz.validation.annotation.SamePassword;

@Service
public class SamePasswordValidator implements ConstraintValidator<SamePassword, UserRegistrationCommand> {

	@Override
	public void initialize(SamePassword arg0) {

	}

	@Override
	public boolean isValid(UserRegistrationCommand form, ConstraintValidatorContext ctx) {
		if (StringUtils.isEmpty(form.getPassword())) {
			ctx.buildConstraintViolationWithTemplate("Hasło nie może być puste").addPropertyNode("password").addConstraintViolation();
			return false;
		}
		ctx.buildConstraintViolationWithTemplate("Hasła nie są takie same").addPropertyNode("password").addConstraintViolation();
		return form.getPassword().equals(form.getPasswordRepeated());
	}

}
