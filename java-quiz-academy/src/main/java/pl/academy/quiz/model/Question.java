package pl.academy.quiz.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = { "area", "options" })
@ToString(exclude = { "area", "options" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(value = AuditingEntityListener.class)
public class Question implements Serializable {
	private static final long serialVersionUID = 1273901372239445061L;

	public static enum QuestionType {
		SINGLE_CHOICE, MULTIPLE_CHOICE, OPEN_TEXT;
	}

	public static enum QuestionLevel {
		JUNIOR("Junior"), MID("Developer"), ADVANCED("Senior");
		private final String text;

		private QuestionLevel(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	@Enumerated(EnumType.STRING)
	private QuestionType type;
	@Enumerated(EnumType.STRING)
	private QuestionLevel level;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AREA_ID")
	private QuestionArea area;
	private int availablePoints;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private Set<QuestionOption> options;

	@Column(nullable = true)
	private Boolean active;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = true)
	@CreatedBy
	private QuizUser user;

}
