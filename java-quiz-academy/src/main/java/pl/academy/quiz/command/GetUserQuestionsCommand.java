package pl.academy.quiz.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.academy.quiz.model.QuizUser;

@Data
@AllArgsConstructor
@Builder
public class GetUserQuestionsCommand {
	private String lastSortBy;

	private QuizUser user;
	private String sortBy;
	private String sortDirection;
	private int pageSize;
	private int pageNumber;

	public GetUserQuestionsCommand() {
		this.sortBy = "id";
		this.sortDirection = "ASC";
		this.pageSize = 5;
		this.pageNumber = 0;
	}

}
