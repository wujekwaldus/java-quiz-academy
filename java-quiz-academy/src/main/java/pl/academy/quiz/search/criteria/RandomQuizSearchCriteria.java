package pl.academy.quiz.search.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RandomQuizSearchCriteria {
	private long[] area;
	private String level;
}
