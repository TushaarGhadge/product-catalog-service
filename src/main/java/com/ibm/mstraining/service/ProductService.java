package com.ibm.mstraining.service;

import java.util.List;

import com.ibm.mstraining.model.Product;


public interface ProductService {

    List<Product> getProducts();

    Product getProduct(long itemId);

    Product addProduct(Product product);

}
