package pl.academy.quiz.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.academy.quiz.validation.annotation.NewAnswerValue;
import pl.academy.quiz.validation.annotation.QuestionAreaValue;
import pl.academy.quiz.validation.annotation.QuestionLevelValue;
import pl.academy.quiz.validation.annotation.QuestionTypeValue;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NewAnswerValue
public class NewQuestionCommand implements Serializable {
	private static final long serialVersionUID = -3381379799469886845L;
	@QuestionAreaValue(message = "Należy wybrać przynajmniej jeden obszar")
	private long[] area;
	@QuestionLevelValue
	private String level;
	@NotEmpty(message = "Należy podać treść pytania")
	private String text;
	@QuestionTypeValue
	private String type;

	private List<NewAnswer> answers;
	
	public List<NewAnswer> getAnswers() {
		if (answers == null) {
			answers = new ArrayList<>();
		}
		return answers;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class NewAnswer {
		private String text;
		private boolean correct;
	}
}
