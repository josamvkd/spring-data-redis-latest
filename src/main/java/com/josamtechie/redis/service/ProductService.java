package com.josamtechie.redis.service;

import com.josamtechie.redis.entity.Product;
import com.josamtechie.redis.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductRepository repository;

    public Product createProduct(Product product)
    {
        product.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(product);
    }

    public List<Product> findAll()
    {
        return (List<Product>) repository.findAll();
    }

    public Product findById(String id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
    }

    public List<Product> findByName(String name)
    {
        return repository.findByName(name);
    }

    public Product updateProductById(String id, Product product)
    {
        return repository.findById(id).map(existingProduct -> {
            existingProduct.setName(product.getName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
            return repository.save(existingProduct);
        }).orElseThrow(() -> new NoSuchElementException("Product not found: " + product.getId()));
    }

    public void deleteById(String id)
    {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Product not found: " + id);
        }
        repository.deleteById(id);
    }
}
