package br.com.neki.proj01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.neki.proj01.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{

}