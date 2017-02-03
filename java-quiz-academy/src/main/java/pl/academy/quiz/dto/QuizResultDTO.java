package pl.academy.quiz.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.academy.quiz.util.DateUtil;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizResultDTO {
	private Date resolveDate;
	private List<QuizAnswerDTO> answers = new ArrayList<>();

	public int getScore() {
		long score = answers.stream().filter(QuizAnswerDTO::isCorrect).count();
		return (int) (((double) score / answers.size()) * 100);
	}

	public String getResolveDateFormatted() {
		return DateUtil.formatFullDate(resolveDate);
	}
}
