package pl.academy.quiz.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaQuizApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	protected java.lang.Class<?>[] getRootConfigClasses() {
		return new Class[] { JavaQuizApplicationConfiguration.class };
	}
}
