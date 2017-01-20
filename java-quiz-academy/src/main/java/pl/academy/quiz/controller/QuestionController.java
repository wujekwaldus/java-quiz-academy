package pl.academy.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.academy.quiz.dto.QuestionDTO;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.service.ModelToDtoConverter;
import pl.academy.quiz.service.QuestionService;

@Controller
@RequestMapping("/quiz")
public class QuestionController {
	private static final String QUIZ_VIEW = "quiz";

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ModelToDtoConverter<Question, QuestionDTO> questionConverter;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRandomQuiz(ModelMap model) {
		model.addAttribute("questions", questionConverter.convert(questionService.getRandomQuestions()));
		return QUIZ_VIEW;
	}
}
