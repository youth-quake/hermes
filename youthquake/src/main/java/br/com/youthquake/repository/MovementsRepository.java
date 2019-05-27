package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.Movements;

@Repository
public interface MovementsRepository extends JpaRepository<Movements, Long>{

}
