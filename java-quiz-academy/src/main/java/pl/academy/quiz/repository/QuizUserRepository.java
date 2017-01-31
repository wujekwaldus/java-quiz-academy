package pl.academy.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.academy.quiz.model.QuizUser;

public interface QuizUserRepository extends JpaRepository<QuizUser, Long> {

	@Query("SELECT u from QuizUser u LEFT JOIN FETCH u.roles where u.email = :email")
	QuizUser findByEmailFetchRoles(@Param("email") String email);

}
