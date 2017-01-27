package pl.academy.quiz.dto;

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
public class QuizAnswerDTO {
	private String questionText;
	private boolean correct;
	private List<QuestionOptionDTO> selected = new ArrayList<>();
}
