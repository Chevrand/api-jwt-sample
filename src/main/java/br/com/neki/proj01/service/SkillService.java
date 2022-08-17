package br.com.neki.proj01.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.neki.proj01.exception.ItemNotFoundException;
import br.com.neki.proj01.model.SkillModel;
import br.com.neki.proj01.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	SkillRepository skillRepository;
	
	public String save(SkillModel model) {
		skillRepository.save(model);
		
		return String.format("Skill ID %d criada com sucesso!", model.getId());
	}
	
	public SkillModel getById(Integer id) throws ItemNotFoundException {
		Optional<SkillModel> model = skillRepository.findById(id);
		
		if(model.isEmpty()) {
			throw new ItemNotFoundException(String.format("Nenhuma skill com ID %d foi encontrada!", id));
		}
		
		return model.get();
	}
	
	public SkillModel getByName(String name) throws ItemNotFoundException {
		Optional<SkillModel> model = skillRepository.findByName(name);
		
		if(model.isEmpty()) {
			throw new ItemNotFoundException(String.format("Nenhuma skill com NOME '%s' foi encontrada!", name));
		}
		
		return model.get();
	}
	
	public List<SkillModel> getAll() {
		List<SkillModel> listModel = skillRepository.findAll();
		
		return listModel;
	}

}