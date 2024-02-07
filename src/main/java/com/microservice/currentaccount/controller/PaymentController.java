package com.microservice.currentaccount.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microservice.currentaccount.domain.Payment;
import com.microservice.currentaccount.service.PaymentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/payment")
@ApiOperation(value = "PaymentRest")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping()
    @ApiOperation(value = "Get all payments")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "All payments successfully retrieved"),
        @ApiResponse(code = 401, message = "Not authorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Payment not found")
    })
    public ResponseEntity<List<Payment>> getAllPayments() {

        try {
            List<Payment> payments = paymentService.getAllPayments();
            return ResponseEntity.status(200).body(payments);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get payment by id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Payment successfully retrieved"),
        @ApiResponse(code = 401, message = "Not authorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Payment not found")
    })
    public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id) {

        try {
            Payment payment = paymentService.getPaymentById(id).orElseThrow();
            return ResponseEntity.status(200).body(payment);
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/customer/{cuit}")
    @ApiOperation(value = "Get payments by customer cuit")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Payments successfully retrieved"),
        @ApiResponse(code = 401, message = "Not authorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Payment not found")
    })
    public ResponseEntity<List<Payment>> getPaymentsByCustomerCuit(@PathVariable String cuit) {

        try {
            List<Payment> payments = paymentService.getPaymentsByCustomerCuit(cuit);
            return ResponseEntity.status(200).body(payments);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Transactional
    @PostMapping()
    @ApiOperation(value = "Create a new payment")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Payment successfully created"),
        @ApiResponse(code = 401, message = "Not authorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
    })
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {

        try {
            Payment newPayment = paymentService.createPayment(payment);
            return ResponseEntity.status(200).body(newPayment);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
