package pl.academy.quiz.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StartControllerTest.StartControllerTestConfiguration.class)
@WebAppConfiguration
public class StartControllerTest {
	
	 private MockMvc mockMvc;
	 
	 @Test
	 public void shouldGetStartPageWithModelAttributes(){
//		 StartController st = null;
//		 mockMvc.perform(get("/"))
//         .andExpect(status().isOk())
//         .andExpect(view().name("index"))
//         .andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
////         .andExpect(model().attribute("todos", hasItem(
////                 allOf(
////                         hasProperty("id", ),
////                         hasProperty("description", is("Lorem ipsum")),
////                         hasProperty("title", is("Foo"))
////                 )
////         )));

	 }
	
	@Configuration
	public static class StartControllerTestConfiguration {
//		@Bean
//		public StartController startController(){
//			return new StartController();
//		}
	}
}
