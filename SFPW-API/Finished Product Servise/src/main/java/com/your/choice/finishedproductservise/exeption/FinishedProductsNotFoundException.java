package com.your.choice.finishedproductservise.exeption;

public class FinishedProductsNotFoundException extends RuntimeException{
    public FinishedProductsNotFoundException(String message) {
        super(message);
    }
}
