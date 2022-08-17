package br.com.neki.proj01.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.neki.proj01.exception.ItemNotFoundException;
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
	
	public UserModel getById(Integer id) throws ItemNotFoundException {
		Optional<UserModel> model = userRepository.findById(id);
		
		if(model.isEmpty()) {
			throw new ItemNotFoundException(String.format("Nenhum usuário com ID %d foi encontrado!", id));
		}
		
		return model.get();
	}
	
	public UserModel getByLogin(String name) throws ItemNotFoundException {
		Optional<UserModel> model = userRepository.findByLogin(name);
		
		if(model.isEmpty()) {
			throw new ItemNotFoundException(String.format("Nenhum usuário com NOME '%s' foi encontrado!", name));
		}
		
		return model.get();
	}
	
}