package com.ibm.mstraining.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.mstraining.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	//Optional<Product> findByProduc(String countryCode);
}
