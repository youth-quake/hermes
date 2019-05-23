package br.com.youthquake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.youthquake.dto.UserDTO;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public List<User> getUserInfo(long id){
		return userRepository.GetInformationUserById(id);
	}

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

		if (user != null)
			return true;
		return false;
	}
}
