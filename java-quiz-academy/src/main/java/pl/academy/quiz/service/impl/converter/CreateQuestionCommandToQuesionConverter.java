package pl.academy.quiz.service.impl.converter;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.academy.quiz.command.CreateQuestionCommand;
import pl.academy.quiz.command.CreateQuestionCommand.NewAnswer;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.Question.QuestionLevel;
import pl.academy.quiz.model.Question.QuestionType;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.repository.QuestionAreaRepository;
import pl.academy.quiz.service.ObjectConverter;

@Service
public class CreateQuestionCommandToQuesionConverter implements ObjectConverter<CreateQuestionCommand, Question> {

	@Autowired
	private QuestionAreaRepository areaRepository;

	@Override
	public Question convert(CreateQuestionCommand model) {
		Question question = Question.builder()//
				.active(Boolean.FALSE)//
				.area(areaRepository.findOne(model.getArea()[0]))//
				.text(model.getText())//
				.level(QuestionLevel.valueOf(model.getLevel()))//
				.availablePoints(calculatePoints(model))//
				.type(QuestionType.valueOf(model.getType()))//
				.build();//
		question.setOptions(createOptions(model, question));
		return question;
	}

	private Set<QuestionOption> createOptions(CreateQuestionCommand model, Question question) {
		return model.getAnswers().stream().map(a -> toQuestionOption(a, question)).collect(Collectors.toSet());
	}

	private QuestionOption toQuestionOption(NewAnswer newAnswer, Question question) {
		return QuestionOption.builder().question(question).text(newAnswer.getText()).points(newAnswer.isCorrect() ? 1 : 0).build();
	}

	private int calculatePoints(CreateQuestionCommand model) {
		return (int) model.getAnswers().stream().filter(NewAnswer::isCorrect).count();
	}

}
