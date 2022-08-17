package br.com.neki.proj01.dto;

public class UserSkillDtoRequestPost {
	
	private String user;
	private String skill;
	private Integer knowledgLevel;
	
	public UserSkillDtoRequestPost() {}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Integer getKnowledgLevel() {
		return knowledgLevel;
	}

	public void setKnowledgLevel(Integer knowledgLevel) {
		this.knowledgLevel = knowledgLevel;
	}

}