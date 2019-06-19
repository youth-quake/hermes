package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.ActionSystem;

@Repository
public interface ActionSystemRepository extends JpaRepository<ActionSystem, Long> {

	ActionSystem findFirstByName(String name);

}
