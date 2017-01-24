package pl.academy.quiz.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.academy.quiz.service.QuestionAreaService;
import pl.academy.quiz.validation.annotation.QuestionAreaValue;

@Service
public class QuestionAreaValidator implements ConstraintValidator<QuestionAreaValue, long[]> {

	@Autowired
	private QuestionAreaService areaService;

	@Override
	public void initialize(QuestionAreaValue arg0) {

	}

	@Override
	public boolean isValid(long[] value, ConstraintValidatorContext ctx) {
		if (value == null)
			return false;
		for (long areaId : value)
			if (!areaService.hasAreaWithId(areaId)) {
				ctx.disableDefaultConstraintViolation();
				ctx.buildConstraintViolationWithTemplate("Serio? Próbujesz podać ID którego nie ma w bazie, lol.").addConstraintViolation();
				return false;
			}

		return true;
	}

}
