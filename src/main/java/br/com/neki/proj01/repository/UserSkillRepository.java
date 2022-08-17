package br.com.neki.proj01.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.neki.proj01.model.UserSkillModel;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkillModel, Integer>{
	
	@Query(value="select "
			+ "	* "
			+ "from "
			+ "	user_skill "
			+ "where "
			+ "	user_id = :id", nativeQuery=true)
	public Optional<List<UserSkillModel>> findByUser(@Param("id") Integer userId);

}