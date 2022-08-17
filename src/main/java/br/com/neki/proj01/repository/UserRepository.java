package br.com.neki.proj01.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.neki.proj01.model.UserModel;

@Repository
public interface UserRepository  extends JpaRepository<UserModel, Integer>{
	
	@Query(value="FROM UserModel u WHERE u.login = ?1")
    Optional<UserModel> findByLogin(String login);

}