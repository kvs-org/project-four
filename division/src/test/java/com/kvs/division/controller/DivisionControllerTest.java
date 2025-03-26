package com.kvs.division.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.kvs.division.service.DivisionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DivisionController.class)
public class DivisionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DivisionService divisionService;

    @Test
    public void testDivisionWithValidInputs() throws Exception {
        // Mock the service response
        when(divisionService.divide(10, 2)).thenReturn(5.0);

        // Perform GET request and verify response
        mockMvc.perform(get("/division")
                .param("a", "10")
                .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    public void testDivisionByZero() throws Exception {
        // Mock the service to throw an exception for division by zero
        when(divisionService.divide(10, 0)).thenThrow(new ArithmeticException("Division by zero"));

        // Perform GET request and verify response
        mockMvc.perform(get("/division")
                .param("a", "10")
                .param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Division by zero"));
    }
}