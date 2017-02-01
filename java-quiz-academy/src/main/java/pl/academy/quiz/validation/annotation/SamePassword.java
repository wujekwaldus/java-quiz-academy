package pl.academy.quiz.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.academy.quiz.validation.SamePasswordValidator;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SamePasswordValidator.class)
public @interface SamePassword {
	String message() default "Wprowadzone hasła nie są identyczne";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
