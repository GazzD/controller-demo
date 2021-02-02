package com.ironhack.controllerdemo.controller.dto;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

public class PriceDTO {
    @Digits(integer = 6, fraction = 2, message = "Wrong price format")
    private BigDecimal price;

    public PriceDTO() {
    }

    public PriceDTO(@Digits(integer = 6, fraction = 2, message = "Wrong price format") BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
