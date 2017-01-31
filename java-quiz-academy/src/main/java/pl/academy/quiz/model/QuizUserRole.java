package pl.academy.quiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizUserRole implements GrantedAuthority {
	private static final long serialVersionUID = -5729953921439446846L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String authority;

	@Override
	public String getAuthority() {
		return authority;
	}

}
