package pl.academy.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.academy.quiz.model.QuestionArea;

public interface QuestionAreaRepository extends JpaRepository<QuestionArea, Long> {

}
