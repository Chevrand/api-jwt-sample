package br.com.neki.proj01.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.neki.proj01.dto.ProductDto;
import br.com.neki.proj01.model.ProductModel;

@Component
public class ProductMapper {
	
	public ProductModel toModel(ProductDto dto) {
		ProductModel model = new ProductModel();
		
		model.setName(dto.getName());
		model.setQuantity(dto.getQuantity());
		
		return model;
	}
	
	public ProductDto toDto(ProductModel model) {
		ProductDto dto = new ProductDto();
		
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setQuantity(model.getQuantity());
		
		return dto;
	}
	
	public List<ProductDto> toDto(List<ProductModel> modelList) {
		List<ProductDto> dtoList = new ArrayList<>();
		
		for(ProductModel model : modelList) {
			dtoList.add(toDto(model));
		}
		
		return dtoList;
	}

}