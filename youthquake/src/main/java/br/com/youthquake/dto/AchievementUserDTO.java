package br.com.youthquake.dto;

import java.io.Serializable;

public class AchievementUserDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;
	private int idAchievementUser;
	private String nameAchievementUser;
	private Long user;
	private Long idAchievement;
	private String quantity;
	private String progress;

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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

}
