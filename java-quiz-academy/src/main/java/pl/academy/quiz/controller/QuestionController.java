package pl.academy.quiz.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.academy.quiz.command.CreateQuestionCommand;
import pl.academy.quiz.dto.QuestionAreaDTO;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.Question.QuestionLevel;
import pl.academy.quiz.model.Question.QuestionType;
import pl.academy.quiz.model.QuestionArea;
import pl.academy.quiz.service.ObjectConverter;
import pl.academy.quiz.service.QuestionAreaService;
import pl.academy.quiz.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {

	private static final Logger LOG = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	private QuestionAreaService questionAreaService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ObjectConverter<CreateQuestionCommand, Question> newQuesionCommandConverter;

	@Autowired
	private ObjectConverter<QuestionArea, QuestionAreaDTO> questionAreaConverter;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@Secured("ROLE_USER")
	public String newQuestion(@ModelAttribute @Valid CreateQuestionCommand command, BindingResult result, ModelMap model) {
		LOG.info("CreateQuestionCommand {}", command);
		if (result.hasErrors()) {
			model.addAttribute("areas", questionAreaConverter.convert(questionAreaService.getAllAreas()));
			model.addAttribute("levels", Question.QuestionLevel.values());
			model.addAttribute("createQuestionCommand", command);
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
		model.addAttribute("createQuestionCommand",
				CreateQuestionCommand.builder()//
						.level(QuestionLevel.JUNIOR.name())//
						.type(QuestionType.SINGLE_CHOICE.name())//
						.area(new long[] { javaAreaId() })//
						.build());//
		return "newQuestion";
	}

	private Long javaAreaId() {
		return questionAreaService.getAllAreas().stream().filter(a -> a.getName().equalsIgnoreCase("Core Java")).findAny().get().getId();
	}
}
