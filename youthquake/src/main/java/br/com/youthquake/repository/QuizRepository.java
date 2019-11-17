package br.com.youthquake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.youthquake.model.Questions;
import br.com.youthquake.model.Target;

public interface QuizRepository extends JpaRepository<Questions, Long> {
		
	@Query("from Questions where idQuestion = ?1")
	Questions getQuestion(long idQuestion);
	
}
