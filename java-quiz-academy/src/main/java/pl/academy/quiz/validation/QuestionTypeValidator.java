package pl.academy.quiz.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;

import pl.academy.quiz.model.Question.QuestionType;
import pl.academy.quiz.validation.annotation.QuestionTypeValue;

@Service
public class QuestionTypeValidator implements ConstraintValidator<QuestionTypeValue, String> {

	@Override
	public void initialize(QuestionTypeValue constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null)
			return false;
		for (QuestionType type : QuestionType.values()) {
			if (type.name().equals(value)) {
				return true;
			}
		}
		return false;
	}

}
