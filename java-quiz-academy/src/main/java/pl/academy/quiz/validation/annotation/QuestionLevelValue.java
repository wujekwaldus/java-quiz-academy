package pl.academy.quiz.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.academy.quiz.validation.QuestionLevelValidator;

@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QuestionLevelValidator.class)
public @interface QuestionLevelValue {
	String message() default "Baz jaj :) nie baw się z zmianę danych w formularzu i ich submitowanie.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
