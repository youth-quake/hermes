package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long>{

}
