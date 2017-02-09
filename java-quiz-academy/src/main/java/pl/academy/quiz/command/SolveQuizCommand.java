package pl.academy.quiz.command;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolveQuizCommand {

	private List<UserAnswer> answers;

	public List<UserAnswer> getAnswers() {
		if (answers == null) {
			answers = new ArrayList<>();
		}
		return answers;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class UserAnswer {
		private long quesionId;
		private List<Long> answerIds;
	}
}
