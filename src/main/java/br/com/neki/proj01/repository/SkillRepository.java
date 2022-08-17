package br.com.neki.proj01.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.neki.proj01.model.SkillModel;

@Repository
public interface SkillRepository extends JpaRepository<SkillModel, Integer>{
	
	public Optional<SkillModel> findByName(String name);

}