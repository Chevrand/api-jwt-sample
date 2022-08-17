package br.com.neki.proj01.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.neki.proj01.dto.UserSkillDtoResponse;
import br.com.neki.proj01.dto.UserSkillDtoRequestPost;
import br.com.neki.proj01.dto.UserSkillDtoRequestPut;
import br.com.neki.proj01.exception.ItemNotFoundException;
import br.com.neki.proj01.model.UserSkillModel;
import br.com.neki.proj01.service.SkillService;
import br.com.neki.proj01.service.UserService;

@Component
public class UserSkillMapper {
	
	@Autowired
	UserService userService;
	@Autowired
	SkillService skillService;
	
	public UserSkillModel toModel(UserSkillDtoRequestPost dto) throws ItemNotFoundException {
		UserSkillModel model = new UserSkillModel();
		
		model.setUser(userService.getByLogin(dto.getUser()));
		model.setSkill(skillService.getByName(dto.getSkill()));
		model.setKnowledgLevel(dto.getKnowledgLevel());
		
		return model;
	}
	
	public UserSkillModel toModel(UserSkillDtoRequestPut dto) {
		UserSkillModel model = new UserSkillModel();
		
		model.setKnowledgLevel(dto.getKnowledgLevel());
		
		return model;
	}
	
	public UserSkillDtoResponse toDto(UserSkillModel model) {
		UserSkillDtoResponse dto = new UserSkillDtoResponse();
		
		dto.setId(model.getId());
		dto.setUserName(model.getUser().getLogin());
		dto.setSkillName(model.getSkill().getName());
		dto.setSkillVersion(model.getSkill().getVersion());
		dto.setSkillDescription(model.getSkill().getDescription());
		dto.setSkillImage(model.getSkill().getImageUrl());
		dto.setKnowledgLevel(model.getKnowledgLevel());
		
		return dto;
	}
	
	public List<UserSkillDtoResponse> toDto(List<UserSkillModel> modelList) {
		List<UserSkillDtoResponse> dtoList = new ArrayList<>();
		
		for(UserSkillModel model : modelList) {
			dtoList.add(toDto(model));
		}
		
		return dtoList;
	}

}