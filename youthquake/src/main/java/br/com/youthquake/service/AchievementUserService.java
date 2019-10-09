package br.com.youthquake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.AchievementUserDTO;
import br.com.youthquake.model.AchievementSystem;
import br.com.youthquake.model.AchievementUser;
import br.com.youthquake.repository.AchievementSystemRepository;
import br.com.youthquake.repository.AchievementUserRepository;
import br.com.youthquake.repository.UserRepository;

@Service
public class AchievementUserService {
	@Autowired
	AchievementSystemRepository achievementSystemRepository;

	@Autowired
	AchievementUserRepository achievementUserRepository;

	@Autowired
	private UserRepository userRepository;

	public AchievementUser achievementUserInclude(long idUser, AchievementUserDTO dto) {

		AchievementSystem achievementSystem = achievementSystemRepository.findFirstByName(dto.getNameAchievementUser());
		AchievementUser achievementUser = achievementUserRepository.findFirtsByUser_idUserAndIdAchievement_idAchievement(idUser, achievementSystem.getIdAchievement());
		
		Long quantity = achievementUserRepository.getAchievementUserByIdAndUser(idUser,
				achievementSystem.getIdAchievement());

		if (achievementUser != null && quantity > 0) {
			achievementUser.setQuantity(dto.getQuantity() +achievementUser.getQuantity());
			achievementUser.setProgress((achievementUser.getQuantity() * 100) / achievementSystem.getNumberRequired());
			return achievementUserRepository.save(achievementUser);
		}
		
		achievementUser = new AchievementUser();
		achievementUser.setUser(userRepository.findFirstByIdUser(idUser));
		achievementUser.setIdAchievement(achievementSystem);
		achievementUser.setQuantity(dto.getQuantity());
		achievementUser.setProgress((dto.getQuantity() * 100) / achievementSystem.getNumberRequired());
		return achievementUserRepository.save(achievementUser);
	}
}