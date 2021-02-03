package com.ironhack.controllerdemo.controller.interfaces;

import com.ironhack.controllerdemo.controller.dto.PriceDTO;
import com.ironhack.controllerdemo.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductController {

    public List<Product> findAll();
    public List<Product> getProductsByCategoryAndDepartment(Optional<String> category, String department);
    public Product store(Product product);
    public void update(long id, Product product);
    public void updatePrice(long id, PriceDTO priceDTO);
    public void delete(long id);

}
