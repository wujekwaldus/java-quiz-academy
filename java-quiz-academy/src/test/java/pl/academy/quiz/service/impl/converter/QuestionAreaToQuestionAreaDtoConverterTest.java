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

import pl.academy.quiz.dto.QuestionAreaDTO;
import pl.academy.quiz.model.QuestionArea;
import pl.academy.quiz.service.ModelToDtoConverter;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QuestionAreaToQuestionAreaDtoConverterTest.QuestionAreaToQuestionAreaDtoConverterTestConfiguration.class)
public class QuestionAreaToQuestionAreaDtoConverterTest {
	@Autowired
	private ModelToDtoConverter<QuestionArea, QuestionAreaDTO> areaToAreaDtoConverter;

	@Test
	public void shouldConvertAreaToAreaDto() {
		// given
		QuestionArea option = QuestionArea.builder().id(10L).name("area").build();
		// when
		QuestionAreaDTO result = areaToAreaDtoConverter.convert(option);
		// then
		Assert.assertEquals(Long.valueOf(10), result.getId());
		Assert.assertEquals("area", result.getName());
	}

	@Test
	public void shouldConvertCollectionOfAreasToCollectionOfAreaDto() {
		// given
		List<QuestionArea> options = Arrays.asList(QuestionArea.builder().id(10L).name("area1").build(),
				QuestionArea.builder().id(11L).name("area2").build());
		// when
		Collection<QuestionAreaDTO> result = areaToAreaDtoConverter.convert(options);
		// then
		Assert.assertEquals(2, result.size());
	}

	@Configuration
	public static class QuestionAreaToQuestionAreaDtoConverterTestConfiguration {
		@Bean
		public ModelToDtoConverter<QuestionArea, QuestionAreaDTO> areaToAreaDtoConverter() {
			return new QuestionAreaToQuestionAreaDtoConverter();
		}

	}
}
