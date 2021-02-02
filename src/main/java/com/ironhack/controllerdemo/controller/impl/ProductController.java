package com.ironhack.controllerdemo.controller.impl;

import com.ironhack.controllerdemo.controller.dto.PriceDTO;
import com.ironhack.controllerdemo.controller.interfaces.IProductController;
import com.ironhack.controllerdemo.enums.Category;
import com.ironhack.controllerdemo.enums.Department;
import com.ironhack.controllerdemo.model.Product;
import com.ironhack.controllerdemo.repository.ProductRepository;
import com.ironhack.controllerdemo.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements IProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductService productService;

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

    @PutMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody @Valid Product product) {
        productService.update(id, product);
    }

    @PatchMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePrice(@PathVariable long id, @RequestBody @Valid PriceDTO priceDTO) {
        productService.updatePrice(id, priceDTO.getPrice());
    }

}
