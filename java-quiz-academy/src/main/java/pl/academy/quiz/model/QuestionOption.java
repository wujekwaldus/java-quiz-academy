package pl.academy.quiz.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = { "question" })
@ToString(exclude = { "question" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class QuestionOption {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String text;
	private int points;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID")
	private Question question;

}
