package br.com.youthquake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.Movements;

@Repository
public interface MovementsRepository extends JpaRepository<Movements, Long>{
	@Query("from Movements where user.idUser = ?1")
	List<Movements> GetInformationMovementsByIdUser(long idUser);
}
