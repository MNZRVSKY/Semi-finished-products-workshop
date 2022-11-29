package com.your.choice.finishedproductservise.exeption;

public class ProductStatusNotFoundException extends RuntimeException{
    public ProductStatusNotFoundException(String message) {
        super(message);
    }
}
