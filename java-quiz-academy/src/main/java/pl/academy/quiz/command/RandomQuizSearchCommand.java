package pl.academy.quiz.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.academy.quiz.model.Question.QuestionLevel;
import pl.academy.quiz.validation.annotation.QuestionAreaValue;
import pl.academy.quiz.validation.annotation.QuestionLevelValue;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RandomQuizSearchCommand {
	@QuestionAreaValue(message="Należy wybrać przynajmniej jeden obszar")
	private long[] area;
	@QuestionLevelValue
	private String level;
	
	
	public QuestionLevel getLevelAsEnum(){
		return QuestionLevel.valueOf(level);
	}
}
