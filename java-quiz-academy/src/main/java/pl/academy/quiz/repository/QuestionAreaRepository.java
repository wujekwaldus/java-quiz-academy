package pl.academy.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import pl.academy.quiz.model.QuestionArea;

public interface QuestionAreaRepository extends JpaRepository<QuestionArea, Long>, QueryDslPredicateExecutor<QuestionArea> {

}
