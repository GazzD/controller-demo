package com.ironhack.controllerdemo.controller.impl;

import com.ironhack.controllerdemo.controller.interfaces.IProductController;
import com.ironhack.controllerdemo.enums.Category;
import com.ironhack.controllerdemo.enums.Department;
import com.ironhack.controllerdemo.model.Product;
import com.ironhack.controllerdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements IProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/products/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProductsByCategoryAndDepartment(@RequestParam Optional<String> category, @RequestParam(defaultValue="clothing") String department){

        if(category.isPresent()) {
            return productRepository.findByCategoryAndDepartment(Category.valueOf(category.get().toUpperCase()), Department.valueOf(department.toUpperCase()));
        } else {
            return productRepository.findByDepartment(Department.valueOf(department.toUpperCase()));
        }
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product store(@RequestBody @Valid Product product) {
        return productRepository.save(product);
    }
}
