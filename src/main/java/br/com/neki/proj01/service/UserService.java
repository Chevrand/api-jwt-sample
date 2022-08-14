package br.com.neki.proj01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.proj01.model.UserModel;
import br.com.neki.proj01.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String save(UserModel model) {
		userRepository.save(model);
		
		return String.format("Usuário ID %d criado com sucesso!", model.getId());
	}
	
}