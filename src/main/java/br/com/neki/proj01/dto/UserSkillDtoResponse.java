package br.com.neki.proj01.dto;

public class UserSkillDtoResponse {
	
	private Integer id;
	private String userName;
	private String skillName;
	private String skillVersion;
	private String skillDescription;
	private String skillImage;
	private Integer knowledgLevel;	
	
	public UserSkillDtoResponse() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillVersion() {
		return skillVersion;
	}

	public void setSkillVersion(String skillVersion) {
		this.skillVersion = skillVersion;
	}

	public String getSkillDescription() {
		return skillDescription;
	}

	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}

	public String getSkillImage() {
		return skillImage;
	}

	public void setSkillImage(String skillImage) {
		this.skillImage = skillImage;
	}

	public Integer getKnowledgLevel() {
		return knowledgLevel;
	}

	public void setKnowledgLevel(Integer knowledgLevel) {
		this.knowledgLevel = knowledgLevel;
	}	
	
}