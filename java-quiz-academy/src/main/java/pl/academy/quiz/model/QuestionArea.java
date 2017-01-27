package pl.academy.quiz.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class QuestionArea implements Serializable {
	private static final long serialVersionUID = 5942077728911704957L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String name;
}
