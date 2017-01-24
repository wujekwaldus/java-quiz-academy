package pl.academy.quiz.service;

import java.util.List;

import pl.academy.quiz.model.QuestionArea;

public interface QuestionAreaService {
	List<QuestionArea> getAllAreas();

	boolean hasAreaWithId(long areaId);
}
