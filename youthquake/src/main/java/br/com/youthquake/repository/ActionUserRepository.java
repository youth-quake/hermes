package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.ActionUser;

@Repository
public interface ActionUserRepository  extends JpaRepository<ActionUser, Long> {

	ActionUser findFirtsByUser_idUserAndIdActionSystem_idAction(long idUser, int idAction);

	
	@Query("SELECT COUNT(AU) FROM ActionUser AU where user.idUser = ?1 and idActionSystem.idAction = ?2")
	Long getActionUserBiIdUserAndIdAction(long idUser, int idAction);

}
