package pl.academy.quiz.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;

import pl.academy.quiz.model.Question.QuestionLevel;
import pl.academy.quiz.validation.annotation.QuestionLevelValue;

@Service
public class QuestionLevelValidator implements ConstraintValidator<QuestionLevelValue, String> {

	@Override
	public void initialize(QuestionLevelValue arg0) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		for (QuestionLevel level : QuestionLevel.values())
			if (level.name().equals(value))
				return true;
		return false;
	}

}
