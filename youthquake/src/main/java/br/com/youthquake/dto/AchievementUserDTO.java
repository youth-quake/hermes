package br.com.youthquake.dto;

import java.io.Serializable;

public class AchievementUserDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;
	private int idAchievementUser;
	private String nameAchievementUser;
	private Long user;
	private Long idAchievement;
	private int quantity;
	private int progress;

	public AchievementUserDTO() {
	}

	public String getNameAchievementUser() {
		return nameAchievementUser;
	}

	public void setNameAchievementUser(String nameAchievementUser) {
		this.nameAchievementUser = nameAchievementUser;
	}

	public int getIdAchievementUser() {
		return idAchievementUser;
	}

	public void setIdAchievementUser(int idAchievementUser) {
		this.idAchievementUser = idAchievementUser;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getIdAchievement() {
		return idAchievement;
	}

	public void setIdAchievement(Long idAchievement) {
		this.idAchievement = idAchievement;
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
