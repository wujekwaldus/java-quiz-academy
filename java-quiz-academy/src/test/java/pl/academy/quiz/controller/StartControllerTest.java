package pl.academy.quiz.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.QuestionArea;
import pl.academy.quiz.service.QuestionAreaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StartControllerTest.StartControllerTestConfiguration.class)
@WebAppConfiguration
public class StartControllerTest {

	private MockMvc mockMvc;
	
	private List<QuestionArea> areas;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private QuestionAreaService mockQuestionAreaService;


	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		areas = Arrays.asList(//
				QuestionArea.builder().id(10L).name("Area1").build(), //
				QuestionArea.builder().id(11L).name("Area2").build(), //
				QuestionArea.builder().id(12L).name("Area3").build()//
		);
		Mockito.when(mockQuestionAreaService.getAllAreas()).thenReturn(areas);
	}

	@Test
	public void shouldGetStartPageWithModelAttributes() throws Exception {
		mockMvc.perform(get("/"))//
				.andExpect(status().isOk())//
				.andExpect(view().name("index"))//
				.andExpect(forwardedUrl("/WEB-INF/views/index.jsp"))//
				.andExpect(model().attribute("areas", areas))//
				.andExpect(model().attribute("levels", Question.QuestionLevel.values()));//

	}

	@Configuration
	@EnableWebMvc
	public static class StartControllerTestConfiguration extends WebMvcConfigurerAdapter {
		@Bean
		public StartController startController() {
			return new StartController();
		}

		@Bean
		public QuestionAreaService mockQuestionAreaService() {
			return Mockito.mock(QuestionAreaService.class);
		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		}

		@Bean
		public ViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}

	}
}
