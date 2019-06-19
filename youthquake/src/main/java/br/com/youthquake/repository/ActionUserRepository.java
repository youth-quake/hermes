package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.ActionUser;

@Repository
public interface ActionUserRepository  extends JpaRepository<ActionUser, Long> {

}
