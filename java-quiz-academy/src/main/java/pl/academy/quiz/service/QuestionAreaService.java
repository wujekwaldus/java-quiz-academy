package pl.academy.quiz.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import pl.academy.quiz.model.QuestionArea;

public interface QuestionAreaService {
	
	@Cacheable(value="allArea")
	List<QuestionArea> getAllAreas();

	@Cacheable(value="singleArea")
	boolean hasAreaWithId(long areaId);
}
