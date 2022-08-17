package br.com.neki.proj01.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.neki.proj01.exception.ItemNotFoundException;
import br.com.neki.proj01.model.UserSkillModel;
import br.com.neki.proj01.repository.UserSkillRepository;

@Service
public class UserSkillService {
	
	@Autowired
	UserSkillRepository userSkillRepository;
	@Autowired
	UserService userService;
	
	public String save(UserSkillModel model) {
		model.setCreationDate(LocalDate.now());
		userSkillRepository.save(model);
		
		return String.format("Associação de skill ID %d efetuada com sucesso!", model.getId());
	}
	
	public UserSkillModel getById(Integer id) throws ItemNotFoundException {
		Optional<UserSkillModel> model = userSkillRepository.findById(id);
		
		if(model.isEmpty()) {
			throw new ItemNotFoundException(String.format("Nenhuma associação de skill com ID %d foi encontrada!", id));
		}
		
		return model.get();
	}
	
	public List<UserSkillModel> getByUser(String userLogin) throws ItemNotFoundException {
		Integer userId = userService.getByLogin(userLogin).getId();
		Optional<List<UserSkillModel>> modelList = userSkillRepository.findByUser(userId);
		
		return modelList.get();
	}
	
	public String update(Integer id, UserSkillModel model) throws ItemNotFoundException {
		UserSkillModel updatedUserSkill = getById(id);
		
		if(model.getKnowledgLevel() != null) {
			updatedUserSkill.setKnowledgLevel(model.getKnowledgLevel());
			updatedUserSkill.setUpdateDate(LocalDate.now());
		}
		
		userSkillRepository.save(updatedUserSkill);
		
		return String.format("Associação de skill ID %d atualizada com sucesso!", id);
	}
	
	public String delete(Integer id) throws ItemNotFoundException {
		getById(id);
		userSkillRepository.deleteById(id);
		
		return String.format("Associação de Skill ID %d deletada com sucesso!", id);
	}

}