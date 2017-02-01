package pl.academy.quiz.service.impl.converter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.academy.quiz.dto.QuestionOptionDTO;
import pl.academy.quiz.model.QuestionOption;
import pl.academy.quiz.service.ObjectConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QuestionOptionToQuestionOptionDtoConverterTest.QuestionOptionToQuestionOptionDtoConverterTestConfiguration.class)
public class QuestionOptionToQuestionOptionDtoConverterTest {

	@Autowired
	private ObjectConverter<QuestionOption, QuestionOptionDTO> optionToOptionDtoConverter;

	@Test
	public void shouldConvertOptionToOptionDto() {
		// given
		QuestionOption option = QuestionOption.builder().id(10L).text("option").build();
		// when
		QuestionOptionDTO result = optionToOptionDtoConverter.convert(option);
		// then
		Assert.assertEquals(Long.valueOf(10), result.getId());
		Assert.assertEquals("option", result.getText());
	}

	@Test
	public void shouldConvertCollectionOfOptionsToCollectionOfOptionDto() {
		// given
		List<QuestionOption> options = Arrays.asList(QuestionOption.builder().id(10L).text("option1").build(),
				QuestionOption.builder().id(11L).text("option1").build());
		// when
		Collection<QuestionOptionDTO> result = optionToOptionDtoConverter.convert(options);
		// then
		Assert.assertEquals(2, result.size());
	}

	@Configuration
	public static class QuestionOptionToQuestionOptionDtoConverterTestConfiguration {
		@Bean
		public ObjectConverter<QuestionOption, QuestionOptionDTO> optionToOptionDtoConverter() {
			return new QuestionOptionToQuestionOptionDtoConverter();
		}

	}
}
