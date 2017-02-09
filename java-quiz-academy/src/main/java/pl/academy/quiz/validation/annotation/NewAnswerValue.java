package pl.academy.quiz.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.academy.quiz.validation.NewAnswerValidator;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NewAnswerValidator.class)
public @interface NewAnswerValue {
	String message() default "Minimalna liczba odpowiedzi wynosi 2";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
