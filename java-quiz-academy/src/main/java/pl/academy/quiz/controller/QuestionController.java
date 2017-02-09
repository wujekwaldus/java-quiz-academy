package pl.academy.quiz.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.academy.quiz.command.NewQuestionCommand;

@Controller
@RequestMapping("/question")
public class QuestionController {
	private Logger LOG = LoggerFactory.getLogger(QuestionController.class);

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newQuestion( @ModelAttribute @Valid NewQuestionCommand command, BindingResult result, ModelMap model) {
		LOG.info("command {}", command);
		if (result.hasErrors()) {
			return "myProfile";
		}

		return "redirect:/user/me";
	}
}
