package com.ironhack.controllerdemo.controller.interfaces;

import com.ironhack.controllerdemo.model.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface IProductController {

    public List<Product> findAll();
    public List<Product> getProductsByCategoryAndDepartment(Optional<String> category, String department);
    public Product store(Product product);

}
