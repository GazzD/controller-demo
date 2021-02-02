package com.ironhack.controllerdemo.service.impl;

import com.ironhack.controllerdemo.model.Product;
import com.ironhack.controllerdemo.repository.ProductRepository;
import com.ironhack.controllerdemo.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    public void update(long id, Product product) {
        if(productRepository.findById(id).isPresent()) {
            product.setId(id);
            productRepository.save(product);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found :C");
        }
    }

    public void updatePrice(long id, BigDecimal price) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            product.get().setPrice(price);
            productRepository.save(product.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found :C");
        }

    }
}
