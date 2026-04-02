package com.josamtechie.redis.repository;

import com.josamtechie.redis.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String>
{
    List<Product> findByName(String name);
}
