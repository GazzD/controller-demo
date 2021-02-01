package com.ironhack.controllerdemo.controller.impl;

import com.ironhack.controllerdemo.controller.interfaces.IProductController;
import com.ironhack.controllerdemo.model.Product;
import com.ironhack.controllerdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements IProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
