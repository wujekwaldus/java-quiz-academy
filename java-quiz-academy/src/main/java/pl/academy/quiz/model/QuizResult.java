package pl.academy.quiz.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = { "answers" })
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class QuizResult implements Serializable {
	private static final long serialVersionUID = 2875832096457319979L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	@Temporal(TemporalType.TIME)
	private Date resolveDate;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "result", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private Set<QuizAnswer> answers;

	public Set<QuizAnswer> getAnswers() {
		if (answers == null) {
			this.answers = new HashSet<>();
		}
		return answers;
	}
}
