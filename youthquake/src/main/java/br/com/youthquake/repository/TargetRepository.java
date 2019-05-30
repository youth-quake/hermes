package br.com.youthquake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.Target;
import br.com.youthquake.model.User;


@Repository
public interface TargetRepository extends JpaRepository<Target, Long>{

	@Query("from Target where user = ?1")
	List<Target> getTargets(User user);
	
}
