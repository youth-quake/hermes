package br.com.youthquake.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.youthquake.model.User;
import br.com.youthquake.repository.UserRepository;

@Component
public class ApplicationSecurity {

	@Autowired
	private UserRepository userRepository;
	
	public boolean verifyUser(User usuario){
		
		User user = userRepository.findFirstByLoginAndPassword(usuario.getLogin(), usuario.getPassword());
		
		//if((usuario.getLogin().equals(usuario.getPassword()))) return true;
		if(user != null) return true;
		return false;
		
	}
	
}
