package pl.academy.quiz.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.academy.quiz.model.Question.QuestionLevel;
import pl.academy.quiz.model.Question.QuestionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDTO {
	private Long id;
	private String text;
	private QuestionType type;
	private QuestionAreaDTO area;
	private Set<QuestionOptionDTO> options;
	
	private boolean active;
	private QuestionLevel level;
}
