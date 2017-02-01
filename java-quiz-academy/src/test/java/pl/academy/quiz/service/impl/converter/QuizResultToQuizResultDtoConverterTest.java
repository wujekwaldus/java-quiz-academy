package pl.academy.quiz.service.impl.converter;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

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

import pl.academy.quiz.dto.QuestionOptionDTO;
import pl.academy.quiz.dto.QuizAnswerDTO;
import pl.academy.quiz.dto.QuizResultDTO;
import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.model.QuizAnswer;
import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.service.ObjectConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QuizResultToQuizResultDtoConverterTest.QuizResultToQuizResultDtoConverterTestConfiguration.class)
public class QuizResultToQuizResultDtoConverterTest {

	@Autowired
	private ObjectConverter<QuizResult, QuizResultDTO> quizResultConverter;

	@Autowired
	private ObjectConverter<QuizAnswer, QuizAnswerDTO> answerConverter;

	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		List<QuizAnswerDTO> mockResult = Arrays.asList(//
				QuizAnswerDTO.builder().questionText("Mock question 1").correct(false)
						.selected(//
								Arrays.asList(//
										QuestionOptionDTO.builder().text("wrong answer 1").build(), //
										QuestionOptionDTO.builder().text("ok answer 1").build()//
								)//
						).build(), //
				QuizAnswerDTO.builder().questionText("Mock question 2").correct(true)
						.selected(//
								Arrays.asList(//
										QuestionOptionDTO.builder().text("ok answer 1").build(), //
										QuestionOptionDTO.builder().text("ok answer 2").build()//
								)//
						).build() //
		);//

		Mockito.when(answerConverter.convert(Mockito.anyCollection())).thenReturn(mockResult);

	}

	@Test
	public void shouldConvertQuizResultToQuizResultDto() {
		// given
		Calendar resolveDate = Calendar.getInstance();
		resolveDate.set(2017, Calendar.JANUARY, 01, 01, 01, 01);
		QuizResult result = QuizResult.builder()
				.answers(new LinkedHashSet<>(//
						Arrays.asList(//
								QuizAnswer.builder().question(//
										Question.builder().id(10L).text("Mock Question 1").availablePoints(1).build()//
								).selectedOptions(//
										new HashSet<>(Arrays.asList(//
												QuestionOption.builder().points(0).text("wrong answer 1").build(), //
												QuestionOption.builder().points(1).text("ok answer 1").build()//
										))//
								).build(), //
								QuizAnswer.builder().question(//
										Question.builder().id(11L).text("Mock Question 2").availablePoints(2).build()//
								).selectedOptions(//
										new HashSet<>(Arrays.asList(//
												QuestionOption.builder().points(1).text("ok answer 1").build(), //
												QuestionOption.builder().points(1).text("ok answer 2").build()//
										))//
								).build()//
						)//
				)).resolveDate(resolveDate.getTime()).build();
		// when
		QuizResultDTO resultDTO = quizResultConverter.convert(result);
		// then
		Assert.assertEquals(resultDTO.getResolveDate(), resolveDate.getTime());
		Assert.assertEquals(2, resultDTO.getAnswers().size());
		Assert.assertEquals(50, resultDTO.getScore());
	}

	@Configuration
	public static class QuizResultToQuizResultDtoConverterTestConfiguration {
		@Bean
		public ObjectConverter<QuizResult, QuizResultDTO> quizResultToQuizResultDtoConverter() {
			return new QuizResultToQuizResultDtoConverter();
		}

		@SuppressWarnings("unchecked")
		@Bean
		public ObjectConverter<QuizAnswer, QuizAnswerDTO> answerConverter() {
			return Mockito.mock(ObjectConverter.class);
		}

	}
}
