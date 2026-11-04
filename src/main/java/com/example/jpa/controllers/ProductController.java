package com.example.jpa.controllers;

import com.example.jpa.Repositories.ProductRepository;
import com.example.jpa.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {
private final int pageSize=1;
    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
//    public List<ProductEntity> findByOrderByPrice(){
//        return productRepository.findByOrderByPrice();
//
//    }

    public Page<ProductEntity> findAllProducts(@RequestParam(defaultValue = "id")String SortBy,
                                               @RequestParam(defaultValue ="0")Integer pageNumber
    ) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);


        return productRepository.findAll(pageable);
    }
}
