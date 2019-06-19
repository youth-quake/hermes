package br.com.youthquake.service;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.AchievementUserDTO;
import br.com.youthquake.model.AchievementUser;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.AchievementSystemRepository;
import br.com.youthquake.repository.AchievementUserRepository;

@Service
public class AchievementUserService {
	@Autowired
	AchievementSystemRepository achievementSystemRepository;

	@Autowired
	AchievementUserRepository achievementUserRepository;

	@Autowired
	HttpSession session;

	private static String SESSION_USER = "SessionUser";

	public AchievementUser achievementUserInclude(@Valid AchievementUserDTO dto) {
		AchievementUser achievementUser = new AchievementUser();

		User u = (User) this.session.getAttribute(SESSION_USER);

		achievementUser.setUser(u);
		achievementUser.setIdAchievement(achievementSystemRepository.findFirstByName(dto.getNameAchievementUser()));
		achievementUser.setQuantity(dto.getQuantity());
		return achievementUserRepository.save(achievementUser);
	}

}