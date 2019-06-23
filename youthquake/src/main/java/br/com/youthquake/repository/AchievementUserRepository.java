package br.com.youthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.AchievementUser;
@Repository
public interface AchievementUserRepository extends JpaRepository<AchievementUser, Long> {

	@Query("SELECT COUNT(AU) FROM AchievementUser AU where user.idUser = ?1 and idAchievement.idAchievement = ?2")
	Long getAchievementUserByIdAndUser(long idUser, int idAchievement);

	AchievementUser findFirtsByUser_idUserAndIdAchievement_idAchievement(long idUser, int idAchievement);
}
