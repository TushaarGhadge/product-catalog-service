package com.ibm.mstraining.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.mstraining.exception.ProductNotFoundException;
import com.ibm.mstraining.model.Product;
import com.ibm.mstraining.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public List<Product> getProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProduct(long itemId) {
		Optional<Product> productOptional = repository.findById(itemId);
		if(!productOptional.isPresent())
			throw new ProductNotFoundException("Product not found");
		
		return productOptional.get();
	}

	@Override
	public Product addProduct(Product product) {
		Product save = repository.save(product);
		return save;
	}

    
    

}
