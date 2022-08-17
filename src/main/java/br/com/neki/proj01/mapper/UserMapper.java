package br.com.neki.proj01.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import br.com.neki.proj01.dto.UserDtoRequestPost;
import br.com.neki.proj01.model.UserModel;

@Component
public class UserMapper {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserModel toModel(UserDtoRequestPost dto) {
		UserModel model = new UserModel();
		
		model.setLogin(dto.getLogin());
		model.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		return model;
	}
	
}