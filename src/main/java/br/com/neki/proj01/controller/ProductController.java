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

import br.com.neki.proj01.dto.ProductDto;
import br.com.neki.proj01.exception.ItemNotFoundException;
import br.com.neki.proj01.mapper.ProductMapper;
import br.com.neki.proj01.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	ProductMapper productMapper;
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody ProductDto dto) {
		return ResponseEntity.ok(productService.save(productMapper.toModel(dto)));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAll() {
		return ResponseEntity.ok(productMapper.toDto(productService.getAll()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getById(@PathVariable Long id) throws ItemNotFoundException {
		return ResponseEntity.ok(productMapper.toDto(productService.getById(id)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ProductDto dto) throws ItemNotFoundException {
		return ResponseEntity.ok(productService.update(id, productMapper.toModel(dto)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws ItemNotFoundException {
		return ResponseEntity.ok(productService.delete(id));
	}

}