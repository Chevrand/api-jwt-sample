package br.com.neki.proj01.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.neki.proj01.dto.SkillDtoRequest;
import br.com.neki.proj01.dto.SkillDtoResponse;
import br.com.neki.proj01.mapper.SkillMapper;
import br.com.neki.proj01.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	@Autowired
	SkillMapper skillMapper;
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody SkillDtoRequest dto) {
		return ResponseEntity.ok(skillService.save(skillMapper.toModel(dto)));
	}
	
	@GetMapping
	public ResponseEntity<List<SkillDtoResponse>> getAll() {
		return ResponseEntity.ok(skillMapper.toDto(skillService.getAll()));
	}

}