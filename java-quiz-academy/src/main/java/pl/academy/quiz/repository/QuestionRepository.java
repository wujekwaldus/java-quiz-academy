package pl.academy.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import pl.academy.quiz.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>, QueryDslPredicateExecutor<Question> {

	@Query(value = "SELECT distinct q FROM Question q LEFT JOIN FETCH q.options opt LEFT JOIN FETCH q.area ar")
	List<Question> findAllWithOptionsAndArea();

}
