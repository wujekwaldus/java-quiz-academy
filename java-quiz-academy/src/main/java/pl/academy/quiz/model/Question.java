package pl.academy.quiz.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

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

	private Long id;
	private String text;
	private QuestionType type;
	private QuestionLevel level;
	private QuestionArea area;
	private int availablePoints;
	private Set<QuestionOption> options;

}
