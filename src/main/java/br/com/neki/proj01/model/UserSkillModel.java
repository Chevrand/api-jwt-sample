package br.com.neki.proj01.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user_skill")
public class UserSkillModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserModel user;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="skill_id")
	private SkillModel skill;
	
	@NotNull
	@Column(name="knowledge_level")
	private Integer knowledgLevel;
	
	@NotNull
	@Column(name="created_at")
	private LocalDate creationDate;
	
	@Column(name="updated_at")
	private LocalDate updateDate;

	public UserSkillModel() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public SkillModel getSkill() {
		return skill;
	}

	public void setSkill(SkillModel skill) {
		this.skill = skill;
	}

	public Integer getKnowledgLevel() {
		return knowledgLevel;
	}

	public void setKnowledgLevel(Integer knowledgLevel) {
		this.knowledgLevel = knowledgLevel;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

}