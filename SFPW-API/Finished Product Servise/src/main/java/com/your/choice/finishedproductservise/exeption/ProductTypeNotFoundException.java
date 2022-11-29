package com.your.choice.finishedproductservise.exeption;

public class ProductTypeNotFoundException extends RuntimeException{
    public ProductTypeNotFoundException(String message) {
        super(message);
    }
}
