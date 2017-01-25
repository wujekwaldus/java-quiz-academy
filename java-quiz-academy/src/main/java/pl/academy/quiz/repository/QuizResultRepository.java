package pl.academy.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.academy.quiz.model.QuizResult;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {

}
