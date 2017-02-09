package pl.academy.quiz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.academy.quiz.command.UserRegistrationCommand;
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
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(ModelMap model) {
		model.addAttribute("userForm", new UserRegistrationCommand());
		return "registration";
	}

	@RequestMapping(value = "/denide", method = RequestMethod.GET)
	public String accessDenide() {
		return "denide";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/?logout";
	}
}
