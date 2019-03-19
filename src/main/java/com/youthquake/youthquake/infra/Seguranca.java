package com.youthquake.youthquake.infra;

import org.springframework.stereotype.Component;

import com.youthquake.youthquake.model.UsuarioModel;

@Component
public class Seguranca {
	
	public boolean acessUser(UsuarioModel usuario){
		if(usuario.getLogin() == null || usuario.getSenha() == null){
			return false;
		}
		else if(!(usuario.getLogin().equals(usuario.getSenha()))){
			return false;
		}
		else{
			return true;
		}
	} 
}
