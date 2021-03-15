package com.ibm.mstraining.rest;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.ibm.mstraining.model.Product;
import com.ibm.mstraining.service.ProductService;

@RestController
public class ProductEndpoint {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/catalog-service")
//	@PreAuthorize("hasAuthority('SCOPE_microservice')")
	public ResponseEntity<List<Product>> getAllProducts()
	{		
		System.out.println("1111111111111111111111");
		List<Product> products = productService.getProducts();
		System.out.println("222222222222222222222222222");
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/catalog-service/product/{productId}")
	public Product getProduct(@PathVariable long productId)
	{		
		return productService.getProduct(productId);
	}
	
	@PostMapping(path="/catalog-service")
	public ResponseEntity<?> addConversionFactor(@RequestBody Product product)
	{
		Product savedValue=productService.addProduct(product);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedValue.getItemId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
