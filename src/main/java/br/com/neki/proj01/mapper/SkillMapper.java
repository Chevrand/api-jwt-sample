package br.com.neki.proj01.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import br.com.neki.proj01.dto.SkillDtoRequest;
import br.com.neki.proj01.dto.SkillDtoResponse;
import br.com.neki.proj01.model.SkillModel;

@Component
public class SkillMapper {
	
	public SkillModel toModel(SkillDtoRequest dto) {
		SkillModel model = new SkillModel();
		
		model.setName(dto.getName());
		model.setVersion(dto.getVersion());
		model.setDescription(dto.getDescription());
		model.setImageUrl(dto.getImageUrl());
		
		return model;
	}
	
	public SkillDtoResponse toDto(SkillModel model) {
		SkillDtoResponse dto = new SkillDtoResponse();
		
		dto.setName(model.getName());
		
		return dto;
	}
	
	public List<SkillDtoResponse> toDto(List<SkillModel> modelList) {
		List<SkillDtoResponse> dtoList = new ArrayList<>();
		
		for(SkillModel model : modelList) {
			dtoList.add(toDto(model));
		}
		
		return dtoList;
	}

}