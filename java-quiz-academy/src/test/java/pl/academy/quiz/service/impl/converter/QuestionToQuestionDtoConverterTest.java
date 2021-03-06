package pl.academy.quiz.service.impl.converter;

import static pl.academy.quiz.model.Question.QuestionLevel.ADVANCED;
import static pl.academy.quiz.model.Question.QuestionLevel.JUNIOR;
import static pl.academy.quiz.model.Question.QuestionLevel.MID;
import static pl.academy.quiz.model.Question.QuestionType.SINGLE_CHOICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.academy.quiz.dto.QuestionAreaDTO;
import pl.academy.quiz.dto.QuestionDTO;
import pl.academy.quiz.dto.QuestionOptionDTO;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.Question.QuestionType;
import pl.academy.quiz.model.QuestionArea;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.service.ObjectConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QuestionToQuestionDtoConverterTest.QuestionToQuestionDtoConverterTestConfiguration.class)
public class QuestionToQuestionDtoConverterTest {

	@Autowired
	private ObjectConverter<Question, QuestionDTO> questionToQuestionDtoConverter;

	@Autowired
	private ObjectConverter<QuestionOption, QuestionOptionDTO> optionToOptionDtoConverter;

	@Autowired
	private ObjectConverter<QuestionArea, QuestionAreaDTO> areaToAreaDtoConverter;

	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		Mockito.when(optionToOptionDtoConverter.convert(Mockito.anyCollection()))
				.thenReturn(Arrays.asList(QuestionOptionDTO.builder().text("mock-option").build()));

		Mockito.when(areaToAreaDtoConverter.convert(Mockito.anyCollection()))
				.thenReturn(Arrays.asList(QuestionAreaDTO.builder().name("mock-area").build()));

		Mockito.when(areaToAreaDtoConverter.convert(Mockito.any(QuestionArea.class)))
				.thenReturn(QuestionAreaDTO.builder().name("mock-area").build());
	}

	@Test
	public void shouldConvertQuestionToQuestionDto() {
		// given
		Question question = Question.builder()//
				.id(10L)//
				.text("QUESTION")//
				.area(QuestionArea.builder().name("area").build())//
				.type(QuestionType.SINGLE_CHOICE)//
				.options(new HashSet<>(Arrays.asList(QuestionOption.builder().text("mock-option").build())))//
				.build();//
		// when
		QuestionDTO result = questionToQuestionDtoConverter.convert(question);
		// then
		Assert.assertEquals("QUESTION", result.getText());
		Assert.assertEquals(QuestionAreaDTO.builder().name("mock-area").build(), result.getArea());
		Assert.assertEquals(QuestionType.SINGLE_CHOICE, result.getType());
		Assert.assertEquals(Long.valueOf(10), result.getId());
		Assert.assertEquals(1, result.getOptions().size());

	}

	@Test
	public void shouldConvertCollectionOfQuestionsToCollectionOfQuestionDtos() {
		// given
		List<Question> questions = new ArrayList<>();
		questions.add(new Question(1L, "Question no: 1", SINGLE_CHOICE, JUNIOR, QuestionArea.builder().name("area").build(), 1,
				generateOptions(4), true, null));
		questions.add(new Question(2L, "Question no: 2", SINGLE_CHOICE, MID, QuestionArea.builder().name("area").build(), 1,
				generateOptions(4), true, null));
		questions.add(new Question(3L, "Question no: 3", SINGLE_CHOICE, ADVANCED, QuestionArea.builder().name("area").build(), 1,
				generateOptions(4), true, null));
		// when
		Collection<QuestionDTO> result = questionToQuestionDtoConverter.convert(questions);
		// then
		Assert.assertEquals(3, result.size());
	}

	private Set<QuestionOption> generateOptions(int size) {
		Set<QuestionOption> options = new LinkedHashSet<>();
		for (int i = 0; i < size; i++) {
			options.add(QuestionOption.builder().text("Option " + i).build());
		}
		return options;
	}

	@Configuration
	public static class QuestionToQuestionDtoConverterTestConfiguration {

		@Bean
		public ObjectConverter<Question, QuestionDTO> questionToQuestionDtoConverter() {
			return new QuestionToQuestionDtoConverter();
		}

		@SuppressWarnings("unchecked")
		@Bean
		public ObjectConverter<QuestionOption, QuestionOptionDTO> optionToOptionDtoConverter() {
			return Mockito.mock(ObjectConverter.class);
		}

		@SuppressWarnings("unchecked")
		@Bean
		public ObjectConverter<QuestionArea, QuestionAreaDTO> areaToAreaDtoConverter() {
			return Mockito.mock(ObjectConverter.class);
		}
	}
}
