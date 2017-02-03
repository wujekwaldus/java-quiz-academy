package pl.academy.quiz.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import pl.academy.quiz.model.QuizUser;

public class QuizUserAuditorAware implements AuditorAware<QuizUser> {

	public QuizUser getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal() instanceof String) {
			return null;
		}
		return ((QuizUser) authentication.getPrincipal());
	}
}
