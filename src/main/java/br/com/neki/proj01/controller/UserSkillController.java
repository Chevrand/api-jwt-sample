package br.com.neki.proj01.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.neki.proj01.dto.UserSkillDtoRequestPost;
import br.com.neki.proj01.dto.UserSkillDtoRequestPut;
import br.com.neki.proj01.dto.UserSkillDtoResponse;
import br.com.neki.proj01.exception.ItemNotFoundException;
import br.com.neki.proj01.mapper.UserSkillMapper;
import br.com.neki.proj01.service.UserSkillService;

@RestController
@RequestMapping("/user-skill")
public class UserSkillController {
	
	@Autowired
	UserSkillService userSkillService;
	@Autowired
	UserSkillMapper userSkillMapper;
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody UserSkillDtoRequestPost dto) throws ItemNotFoundException {
		return ResponseEntity.ok(userSkillService.save(userSkillMapper.toModel(dto)));
	}
	
	@GetMapping("/{userName}")
	public ResponseEntity<List<UserSkillDtoResponse>> getByUser(@PathVariable String userName) throws ItemNotFoundException {
		return ResponseEntity.ok(userSkillMapper.toDto(userSkillService.getByUser(userName)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody UserSkillDtoRequestPut dto) throws ItemNotFoundException {
		return ResponseEntity.ok(userSkillService.update(id, userSkillMapper.toModel(dto)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) throws ItemNotFoundException {
		return ResponseEntity.ok(userSkillService.delete(id));
	}

}