package com.example.jpa.controllers;

import com.example.jpa.Repositories.ProductRepository;
import com.example.jpa.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
//    public List<ProductEntity> findByOrderByPrice(){
//        return productRepository.findByOrderByPrice();
//
//    }

    public List<ProductEntity> findAllProducts(@RequestParam(defaultValue = "id")String SortBy) {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,SortBy));
    }
}
