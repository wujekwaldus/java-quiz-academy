package pl.academy.quiz.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

public class JavaQuizSecurityWebInitializer extends  AbstractSecurityWebApplicationInitializer {
	  @Override
	    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
	        super.beforeSpringSecurityFilterChain(servletContext);
	 
	        FilterRegistration.Dynamic characterEncodingFilter;
	        characterEncodingFilter = servletContext.addFilter("encodingFilter",
	                new CharacterEncodingFilter());
	        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
	        characterEncodingFilter.setInitParameter("forceEncoding", "true");
	        characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
	    }
}
