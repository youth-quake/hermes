package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.Target;

@Repository
public interface TargetRepository extends JpaRepository<Target, Long>{

	
}
