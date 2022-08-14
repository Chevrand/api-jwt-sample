package br.com.neki.proj01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.neki.proj01.model.UserModel;

public interface UserRepository  extends JpaRepository<UserModel, Long>{
	
	@Query(value="FROM UserModel u WHERE u.login = ?1")
    Optional<UserModel> findByLogin(String login);

}