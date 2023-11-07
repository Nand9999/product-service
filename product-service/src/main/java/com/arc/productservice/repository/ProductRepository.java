package com.arc.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arc.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product,String>{

}
