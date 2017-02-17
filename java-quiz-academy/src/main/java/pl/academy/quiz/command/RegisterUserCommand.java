package pl.academy.quiz.command;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.academy.quiz.validation.annotation.SamePassword;
import pl.academy.quiz.validation.annotation.UniqueEmail;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SamePassword
public class RegisterUserCommand implements Serializable {
	private static final long serialVersionUID = -1095853804455958871L;

	@UniqueEmail
	private String email;
	@NotEmpty(message="Imie nie moze byc puste")
	private String name;
	private String password;
	private String passwordRepeated;

}
