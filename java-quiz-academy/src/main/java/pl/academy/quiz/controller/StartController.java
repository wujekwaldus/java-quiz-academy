package pl.academy.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.academy.quiz.model.Question;
import pl.academy.quiz.service.QuestionAreaService;

@Controller
@RequestMapping("/")
public class StartController {
	public static final String DEFAULT_VIEW = "index";

	@Autowired
	private QuestionAreaService questionAreaService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDefaultView(ModelMap model) {
		model.addAttribute("areas", questionAreaService.getAllAreas());
		model.addAttribute("levels", Question.QuestionLevel.values());
		return DEFAULT_VIEW;
	}
}
