package pl.academy.quiz.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.academy.quiz.model.Question;
import pl.academy.quiz.model.Question.QuestionLevel;
import pl.academy.quiz.model.QuizUser;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query(value = "SELECT distinct q FROM Question q LEFT JOIN FETCH q.options opt LEFT JOIN FETCH q.area ar WHERE "
			+ "ar.id = :areaId AND q.level = :level ORDER BY RAND()")
	List<Question> findByCriteria(@Param("areaId") long areaId, @Param("level") QuestionLevel level, Pageable pageable);

	@Query("SELECT q FROM Question q LEFT JOIN FETCH q.options opt LEFT JOIN FETCH q.area ar WHERE q.id = :id")
	@Cacheable(value = "questionWithOptions")
	Question findOneFetchOptions(@Param("id") Long questionId);

	@Query(value = "SELECT distinct q FROM Question q LEFT JOIN FETCH q.options opt LEFT JOIN FETCH q.area ar WHERE q.user = :user", //
			countQuery = "SELECT count(distinct q) FROM Question q LEFT JOIN q.options opt LEFT JOIN q.area ar WHERE q.user = :user") //
	Page<Question> findByUser(@Param("user") QuizUser user, Pageable pageable);

}
