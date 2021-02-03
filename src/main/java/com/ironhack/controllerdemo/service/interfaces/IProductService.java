package com.ironhack.controllerdemo.service.interfaces;

import com.ironhack.controllerdemo.model.Product;

import java.math.BigDecimal;

public interface IProductService {

    public void update(long id, Product product);
    public void updatePrice(long id, BigDecimal price);
    public void delete(long id);

}
