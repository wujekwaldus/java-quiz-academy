package pl.academy.quiz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.academy.quiz.command.GetQuizCommand;
import pl.academy.quiz.command.SolveQuizCommand;
import pl.academy.quiz.dto.QuestionDTO;
import pl.academy.quiz.dto.QuizResultDTO;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.service.ObjectConverter;
import pl.academy.quiz.service.QuestionService;
import pl.academy.quiz.service.QuizService;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	private static final String QUIZ_VIEW = "quiz";

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	@Autowired
	private ObjectConverter<Question, QuestionDTO> questionConverter;

	@Autowired
	private ObjectConverter<QuizResult, QuizResultDTO> quizConverter;

	@Autowired
	private ObjectConverter<SolveQuizCommand, QuizResult> quizCommandConverter;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRandomQuiz(@ModelAttribute @Valid GetQuizCommand quizSearchCriteria, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "forward:/?errors=true";
		}
		model.addAttribute("questions", questionConverter.convert(questionService.getRandomQuestions(quizSearchCriteria)));
		return QUIZ_VIEW;
	}

	@RequestMapping(value = "/finish", method = RequestMethod.POST)
	public String showResults(@ModelAttribute SolveQuizCommand command, ModelMap model) {
		QuizResult result = quizService.saveQuizeResult(quizCommandConverter.convert(command));
		model.addAttribute("result", quizConverter.convert(result));
		return "results";
	}
}
