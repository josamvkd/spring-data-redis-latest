package com.josamtechie.redis.controller;

import com.josamtechie.redis.entity.Product;
import com.josamtechie.redis.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/products")
@RequiredArgsConstructor
public class ProductController
{
    private final ProductService service;

    @PostMapping("/save")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(product));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id)
    {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name)
    {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product)
    {
        return ResponseEntity.ok(service.updateProductById(id, product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String id)
    {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
