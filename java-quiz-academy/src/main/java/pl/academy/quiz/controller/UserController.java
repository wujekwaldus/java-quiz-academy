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

import pl.academy.quiz.command.RegisterUserCommand;
import pl.academy.quiz.dto.QuizResultDTO;
import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.model.QuizUser;
import pl.academy.quiz.service.ObjectConverter;
import pl.academy.quiz.service.QuestionService;
import pl.academy.quiz.service.QuizUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private QuizUserService userService;

//	@Autowired
//	private QuestionService questionService;

	@Autowired
	private ObjectConverter<QuizResult, QuizResultDTO> resultConverter;

	@Autowired
	private ObjectConverter<RegisterUserCommand, QuizUser> userConverter;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newUser(@ModelAttribute("userForm") @Valid RegisterUserCommand form, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			form.setPassword(null);
			form.setPasswordRepeated(null);
			model.addAttribute("userForm", form);
		} else {
			model.addAttribute("newUserRegistered", true);
			userService.save(userConverter.convert(form));
		}
		return "registration";
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	@Secured("ROLE_USER")
	public String myProfileView(ModelMap model) {
		model.addAttribute("results", resultConverter.convert(userService.getMyTestResults()));
		//model.addAttribute("questions", questionService.getUserQuesions());
		return "myProfile";
	}

}
