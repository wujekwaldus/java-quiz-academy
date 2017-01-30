package pl.academy.quiz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.academy.quiz.dto.QuestionDTO;
import pl.academy.quiz.dto.QuizResultDTO;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.search.criteria.RandomQuizSearchCriteria;
import pl.academy.quiz.service.ModelToDtoConverter;
import pl.academy.quiz.service.QuestionService;
import pl.academy.quiz.service.QuizService;

@Controller
@RequestMapping("/quiz")
public class QuestionController {
	private static final String QUIZ_VIEW = "quiz";

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	@Autowired
	private ModelToDtoConverter<Question, QuestionDTO> questionConverter;

	@Autowired
	private ModelToDtoConverter<QuizResult, QuizResultDTO> quizConverter;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRandomQuiz(@ModelAttribute @Valid RandomQuizSearchCriteria quizSearchCriteria, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "forward:/?errors=true";
		}
		model.addAttribute("questions", questionConverter.convert(questionService.getRandomQuestions(quizSearchCriteria)));
		return QUIZ_VIEW;
	}

	@RequestMapping(value = "/finish", method = RequestMethod.POST)
	public String showResults(QuizResult quizResult, ModelMap model) {
		QuizResult result = quizService.saveQuizeResult(quizResult);
		model.addAttribute("result", quizConverter.convert(result));
		return "results";
	}
}
