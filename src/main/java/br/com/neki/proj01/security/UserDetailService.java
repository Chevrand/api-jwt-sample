package br.com.neki.proj01.security;

import java.util.ArrayList;
import java.util.Optional;

import br.com.neki.proj01.model.UserModel;
import br.com.neki.proj01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserModel> user = userRepository.findByLogin(username);
		
		if(user.isPresent()) {
			UserModel u = user.get();
			return new User(u.getLogin(), u.getPassword(), new ArrayList<>());
			
		}
		
		throw new UsernameNotFoundException("Usuario incorreto!");
	}

}