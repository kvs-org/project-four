package com.kvs.division.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

import com.kvs.division.service.DivisionService;


@RestController
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @GetMapping("/division")
    public ResponseEntity<Double> getMethodName(@RequestParam Integer a, @RequestParam Integer b) {
        double result = divisionService.divide(a, b);
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
