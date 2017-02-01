package pl.academy.quiz.repository;

import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.academy.quiz.model.QuizUserRole;

public interface QuizUserRoleRepository extends JpaRepository<QuizUserRole, Long> {

	@Cacheable("userRoleByAuthority")
	Set<QuizUserRole> findByAuthority(String authority);
}
