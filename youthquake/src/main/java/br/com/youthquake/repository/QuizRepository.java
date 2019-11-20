package br.com.youthquake.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.youthquake.model.Questions;

public interface QuizRepository extends JpaRepository<Questions, Long> {
		
	@Query("from Questions where idQuestion = ?1")
	Questions getQuestion(long idQuestion);
	
}
