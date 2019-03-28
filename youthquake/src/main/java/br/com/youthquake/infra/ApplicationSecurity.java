package br.com.youthquake.infra;

import org.springframework.stereotype.Component;

import br.com.youthquake.model.User;

@Component
public class ApplicationSecurity {
	
	public boolean verifyUser(User usuario){
		if((usuario.getLogin().equals(usuario.getPassword()))) return true;
		return false;
	}
	
	public boolean allowsAcess(User user) {
		String loginUser[][]  = new String[3][2];
		
		loginUser[0][0] = "Giu";
		loginUser[0][1] = "123";
		
		loginUser[1][0] = "Thiago";
		loginUser[1][1] = "Senha";
		
		loginUser[2][0] = "Abc";
		loginUser[2][1] = "321";
		
		
		for(int linha = 0; linha < loginUser.length; linha++) {
				if(user.getLogin().equals(loginUser[linha][0]) && 
				   user.getPassword().equals(loginUser[linha][1])) {
				return true;					
			}
		}
			return false;			
	 }	
}
