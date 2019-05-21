package br.com.youthquake.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public User getUserInfo(UserDTO u){
		return userRepository.GetInformationUserById(u.getId());
	}

	public User userInclude(UserDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setLogin(dto.getLogin());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());
		return userRepository.save(user);
	}

	public boolean verifyUser(UserDTO usuario) {
		User user = userRepository.findFirstByLoginAndPassword(usuario.getLogin(), usuario.getPassword());

		if (user != null)
			return true;
		return false;

	}
}
