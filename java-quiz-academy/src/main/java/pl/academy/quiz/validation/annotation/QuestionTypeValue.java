package pl.academy.quiz.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.academy.quiz.validation.QuestionTypeValidator;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QuestionTypeValidator.class)
public @interface QuestionTypeValue {

	String message() default "Niepoprawna wartość";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
