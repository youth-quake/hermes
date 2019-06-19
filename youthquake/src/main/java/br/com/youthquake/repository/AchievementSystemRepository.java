package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.AchievementSystem;
@Repository
public interface AchievementSystemRepository extends JpaRepository<AchievementSystem, Long> {

	AchievementSystem findFirstByName(String name);

}
