package br.com.neki.proj01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.proj01.dto.UserDto;
import br.com.neki.proj01.mapper.UserMapper;
import br.com.neki.proj01.security.JwtUtil;
import br.com.neki.proj01.security.UserAuthenticationRequest;
import br.com.neki.proj01.security.UserDetailService;
import br.com.neki.proj01.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserMapper userMapper;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserDetailService userDetailService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody UserDto dto) {
		return ResponseEntity.ok(userService.save(userMapper.toModel(dto)));
	}
	
	@PostMapping("/authenticate")
	public String createAuthentication(@RequestBody UserAuthenticationRequest user) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		} catch (Exception e) {
			throw new Exception("Senha incorreta", e);
		}
		UserDetails userDetail = userDetailService.loadUserByUsername(user.getUsername());
		String token = jwtUtil.generateToken(userDetail);
		return token;
	}
	
}