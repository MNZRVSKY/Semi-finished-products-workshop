package com.your.choice.finishedproductservise.exeption;

public class ShiftTypeNotFoundException extends RuntimeException {
    public ShiftTypeNotFoundException(String message) {
        super(message);
    }
}
