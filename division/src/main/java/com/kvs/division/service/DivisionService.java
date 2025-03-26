package com.kvs.division.service;

import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) a / b; // Perform floating-point division
    }

}
