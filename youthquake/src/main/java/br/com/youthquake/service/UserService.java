package br.com.youthquake.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
	
	public List<User> getUserInfo(long idUser){
		User u = (User)this.session.getAttribute(SESSION_USER);
		return userRepository.GetInformationUserById(idUser);
	}

	public User userInclude(UserDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setLogin(dto.getLogin());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());
		return userRepository.save(user);
	}
	
	public void deleteUserById(long idUser){
		userRepository.deleteById(idUser);
	}
	
	public User userUpdate(long id, UserDTO dto) {
		User userRepo = userRepository.getOne(id);
		userRepo.userUpdateInformations(dto);
		return userRepository.save(userRepo);
	}

	public User verifyUser(String login, String password) {
		User user = userRepository.findFirstByLoginAndPassword(login, password);
		session.setAttribute(SESSION_USER, user);
		return user;
	}

	public User updateInfoUser(long idUser, UserDTO dto) {
		User user = userRepository.getOne(idUser);
		user.updateUserInfos(dto);
		return userRepository.save(user);
	}

	public User pictureInclude(UserDTO dto, long idUser) {
		User user = userRepository.getOne(idUser);
		user.setPicture(dto.getPicture());
		return userRepository.save(user);
	}

	public User updatePicture(long idUser, UserDTO dto) {
		User user = userRepository.getOne(idUser);
		user.updatePictureUser(dto);
		return userRepository.save(user);
	}
}
