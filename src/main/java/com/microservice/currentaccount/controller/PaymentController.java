package com.microservice.currentaccount.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microservice.currentaccount.domain.Payment;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/payment")
@ApiOperation(value = "PaymentRest")
public class PaymentController {

    @GetMapping()
    @ApiOperation(value = "Get all payments")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "All payments successfully retrieved"),
        @ApiResponse(code = 401, message = "Not authorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse (code = 404, message = "Payment not found")
    })
    public List<Payment> getAllPayments() {
        return null;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get payment by id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Payment successfully retrieved"),
        @ApiResponse(code = 401, message = "Not authorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse (code = 404, message = "Payment not found")
    })
    public Payment getPaymentById(@PathVariable Integer id) {
        return null;
    }

    @GetMapping("/client/{cuit}")
    @ApiOperation(value = "Get payments by customer cuit")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Payments successfully retrieved"),
        @ApiResponse(code = 401, message = "Not authorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse (code = 404, message = "Payment not found")
    })
    public List<Payment> getPaymentByClientCuit(@PathVariable String cuit) {
        return null;
    }

    @PostMapping()
    @ApiOperation(value = "Create a new payment")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Payment successfully created"),
        @ApiResponse(code = 401, message = "Not authorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
    })
    public Payment savePayment(@RequestBody Payment payment) {

        return payment;
    }

}
