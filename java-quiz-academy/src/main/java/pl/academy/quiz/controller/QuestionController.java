package pl.academy.quiz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.academy.quiz.command.NewQuestionCommand;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.service.ObjectConverter;
import pl.academy.quiz.service.QuestionAreaService;
import pl.academy.quiz.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionAreaService questionAreaService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ObjectConverter<NewQuestionCommand, Question> newQuesionCommandConverter;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@Secured("ROLE_USER")
	public String newQuestion(@ModelAttribute @Valid NewQuestionCommand command, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("areas", questionAreaService.getAllAreas());
			model.addAttribute("levels", Question.QuestionLevel.values());
			// model.addAttribute("newQuestionCommand", command);
			return "newQuestion";
		}
		questionService.saveQuestion(newQuesionCommandConverter.convert(command));
		return "redirect:/user/me?newQuestion=true";
	}
	
	
	@RequestMapping(value = "/newQuestion", method = RequestMethod.GET)
	@Secured("ROLE_USER")
	public String newQuestionView(ModelMap model) {
		model.addAttribute("areas", questionAreaService.getAllAreas());
		model.addAttribute("levels", Question.QuestionLevel.values());
		return "newQuestion";
	}
}
