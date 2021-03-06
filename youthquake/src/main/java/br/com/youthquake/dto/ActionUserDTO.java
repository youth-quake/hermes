package br.com.youthquake.dto;
import java.io.Serializable;

import br.com.youthquake.model.ActionSystem;
import br.com.youthquake.model.User;

public class ActionUserDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	private int idActionUser;
	private User user;
	private String nameActionUser;
	private ActionSystem idActionSystem;
	private int quantity;
	private int progress;
	
	
	public int getIdActionUser() {
		return idActionUser;
	}
	public void setIdActionUser(int idActionUser) {
		this.idActionUser = idActionUser;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNameActionUser() {
		return nameActionUser;
	}
	public void setNameActionUser(String nameActionUser) {
		this.nameActionUser = nameActionUser;
	}
	public ActionSystem getIdActionSystem() {
		return idActionSystem;
	}
	public void setIdActionSystem(ActionSystem idActionSystem) {
		this.idActionSystem = idActionSystem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	
}
