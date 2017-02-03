package pl.academy.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.academy.quiz.model.QuizResult;
import pl.academy.quiz.model.QuizUser;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {

	@Query("SELECT distinct r from QuizResult r "//
			+ "LEFT JOIN FETCH r.answers answers "//
			+ "LEFT JOIN FETCH answers.question "//
			+ "LEFT JOIN FETCH answers.selectedOptions "
			+ "WHERE r.user = :user ORDER BY r.resolveDate")//
	List<QuizResult> findByUserFetchAnswersOrderByResolveDate(@Param("user") QuizUser user);
}
