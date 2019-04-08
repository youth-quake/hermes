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
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User include(UserDTO dto){
		User user = new User();
		user.setLogin(dto.getLogin());
		user.setPassword(dto.getPassword());
		return userRepository.save(user);
	}
	
	/*
	public User find(long id){
		User user = new User();
		return user = userRepository.findOne(id);	
	}
	*/
}
