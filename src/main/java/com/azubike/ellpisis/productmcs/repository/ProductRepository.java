package com.azubike.ellpisis.productmcs.repository;

import com.azubike.ellpisis.productmcs.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product , String> {
}
