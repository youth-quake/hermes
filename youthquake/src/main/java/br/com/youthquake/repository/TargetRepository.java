package br.com.youthquake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.Target;


@Repository
public interface TargetRepository extends JpaRepository<Target, Long>{

	@Query("from Target")
	List<Target> getTargets();

	@Query("from Target where user.idUser = ?1")
	List<Target> GetInformationTargetByIdUser(long idUser);
	
	@Query("from Target where user.idUser = ?1 and idTarget = ?2")
	Target getTargetByUserAndTarget(long idUser, long idTarget);
	
}
