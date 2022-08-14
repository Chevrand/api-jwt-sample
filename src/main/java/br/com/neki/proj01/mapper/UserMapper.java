package br.com.neki.proj01.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.neki.proj01.dto.UserDto;
import br.com.neki.proj01.model.UserModel;

@Component
public class UserMapper {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserModel toModel(UserDto dto) {
		UserModel model = new UserModel();
		
		model.setName(dto.getName());
		model.setLogin(dto.getLogin());
		model.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		return model;
	}
	
	public UserDto toDto(UserModel model) {
		UserDto dto = new UserDto();
		
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setLogin(model.getLogin());
		dto.setPassword(model.getPassword());
		
		return dto;
	}
	
	public List<UserDto> toDto(List<UserModel> modelList) {
		List<UserDto> dtoList = new ArrayList<>();
		
		for(UserModel model : modelList) {
			dtoList.add(toDto(model));
		}
		
		return dtoList;
	}
	
}