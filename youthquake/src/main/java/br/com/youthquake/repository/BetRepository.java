package br.com.youthquake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long>{

	@Query("from Bet where idFriends.user1.idUser = ?1")
	List<Bet> GetInformationBetByIdUser(long idUser);

}
