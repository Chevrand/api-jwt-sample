package br.com.neki.proj01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.proj01.exception.ItemNotFoundException;
import br.com.neki.proj01.model.ProductModel;
import br.com.neki.proj01.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public String save(ProductModel model) {
		productRepository.save(model);
		
		return String.format("Produto ID %d criado com sucesso!", model.getId());
	}
	
	public ProductModel getById(Long id) throws ItemNotFoundException {
		Optional<ProductModel> model = productRepository.findById(id);
		
		if(model.isEmpty()) {
			throw new ItemNotFoundException(String.format("Nenhum produto com ID %d foi cadastrado!", id));
		}
		
		return model.get();
	}
	
	public List<ProductModel> getAll() {
		return productRepository.findAll();
	}

}