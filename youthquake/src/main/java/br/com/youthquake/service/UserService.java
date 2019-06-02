package br.com.youthquake.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.UserDTO;
import br.com.youthquake.model.AchievementUser;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	private static String SESSION_USER = "SessionUser";
	

	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	/* método que recarrega as informações do usuário que está na sessão no momento que 
	   ele se loga*/
	
	public List<User> getUserInfo(){
		User u = (User)this.session.getAttribute(SESSION_USER);
		return userRepository.GetInformationUserById(u.getIdUser());
	}
	
	//public List<AchievementUser> getAchievement(){
	//	User u = (User)this.session.getAttribute(SESSION_USER);
	//	return userRepository.GetAchievement(u);
	//}

	public User userInclude(UserDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setLogin(dto.getLogin());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());
		return userRepository.save(user);
	}
	
	public User userUpdate(long id, UserDTO dto) {
		User userRepo = userRepository.getOne(id);
		userRepo.userUpdateInformations(dto);
		return userRepository.save(userRepo);
	}

	public boolean verifyUser(String login, String password) {
		User user = userRepository.findFirstByLoginAndPassword(login, password);

		if (user != null) {
			session.setAttribute(SESSION_USER, user);
			System.out.println(session);
			return true;
		}
			
		
		return false;
	}
}
