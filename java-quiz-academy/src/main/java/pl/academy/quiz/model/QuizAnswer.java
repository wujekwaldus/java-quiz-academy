package pl.academy.quiz.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = { "selectedOptions" })
@ToString(exclude = { "result" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class QuizAnswer implements Serializable {
	private static final long serialVersionUID = -5470520409444497907L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESULT_ID")
	private QuizResult result;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID")
	private Question question;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ANSWER", joinColumns = { @JoinColumn(name = "QUIZ_ANSWER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "OPTION_ID") })
	private Set<QuestionOption> selectedOptions;

}
