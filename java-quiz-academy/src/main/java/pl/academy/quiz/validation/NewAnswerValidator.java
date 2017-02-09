package pl.academy.quiz.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import pl.academy.quiz.command.NewQuestionCommand;
import pl.academy.quiz.command.NewQuestionCommand.NewAnswer;
import pl.academy.quiz.model.Question.QuestionType;
import pl.academy.quiz.validation.annotation.NewAnswerValue;

@Service
public class NewAnswerValidator implements ConstraintValidator<NewAnswerValue, NewQuestionCommand> {

	@Override
	public void initialize(NewAnswerValue constraintAnnotation) {

	}

	@Override
	public boolean isValid(NewQuestionCommand command, ConstraintValidatorContext context) {
		List<NewAnswer> value = command.getAnswers();
		if (value == null || value.size() < 2)
			return false;
		long correctNo = value.stream().filter(NewAnswer::isCorrect).count();
		if (correctNo == 0) {
			context.disableDefaultConstraintViolation();
			context//
					.buildConstraintViolationWithTemplate("Musi być conajmniej jedna poprawna odpowiedź.")//
					.addPropertyNode("answers")//
					.addConstraintViolation();//
			return false;
		}
		long emptyText = value.stream().filter(a -> StringUtils.isEmpty(a.getText())).count();
		if (emptyText == 0) {
			context.disableDefaultConstraintViolation();
			context//
					.buildConstraintViolationWithTemplate("Tekst odpowiedzi nie może być pusty.")//
					.addPropertyNode("answers")//
					.addConstraintViolation();//
			return false;
		}
		if (QuestionType.SINGLE_CHOICE.name().equals(command.getType()) && correctNo != 1) {
			context.disableDefaultConstraintViolation();
			context//
					.buildConstraintViolationWithTemplate("W przypadku odpowiedzi jednokrotnego wyboru może być tylko jedna odpowiedź.")//
					.addPropertyNode("answers")//
					.addConstraintViolation();//
			return false;
		}
		return true;
	}

}
