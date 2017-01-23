package pl.academy.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.academy.quiz.model.QuestionArea;
import pl.academy.quiz.repository.QuestionAreaRepository;
import pl.academy.quiz.service.QuestionAreaService;

@Service
@Transactional
public class QuestionAreaServiceImpl implements QuestionAreaService {

	@Autowired
	private QuestionAreaRepository areaRepository;

	@Override
	public List<QuestionArea> getAllAreas() {
		return areaRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
	}

}
