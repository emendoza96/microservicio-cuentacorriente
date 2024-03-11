package com.microservice.currentaccount.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microservice.currentaccount.domain.Payment;
import com.microservice.currentaccount.error.ErrorDetail;
import com.microservice.currentaccount.error.ErrorResponse;
import com.microservice.currentaccount.service.PaymentService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/payment")
@Tag(name = "PaymentRest")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping()
    @Operation(summary = "Get all payments")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "All payments successfully retrieved"),
        @ApiResponse(responseCode = "401", description = "Not authorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        @ApiResponse(responseCode = "404", description = "Payment not found")
    })
    public ResponseEntity<?> getAllPayments() {

        try {
            List<Payment> payments = paymentService.getAllPayments();
            return ResponseEntity.ok().body(payments);
        } catch (Exception e) {
            ErrorDetail errorDetails = new ErrorDetail();
            errorDetails.setCode(HttpStatus.BAD_REQUEST.value());
            errorDetails.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorResponse(errorDetails));
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get payment by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payment successfully retrieved"),
        @ApiResponse(responseCode = "401", description = "Not authorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        @ApiResponse(responseCode = "404", description = "Payment not found")
    })
    public ResponseEntity<?> getPaymentById(@PathVariable Integer id) {

        try {
            Payment payment = paymentService.getPaymentById(id).orElseThrow();
            return ResponseEntity.status(200).body(payment);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            ErrorDetail errorDetails = new ErrorDetail();
            errorDetails.setCode(HttpStatus.BAD_REQUEST.value());
            errorDetails.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorResponse(errorDetails));
        }

    }

    @GetMapping("/customer/{cuit}")
    @Operation(summary = "Get payments by customer cuit")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payments successfully retrieved"),
        @ApiResponse(responseCode = "401", description = "Not authorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        @ApiResponse(responseCode = "404", description = "Payment not found")
    })
    public ResponseEntity<?> getPaymentsByCustomerCuit(@PathVariable String cuit) {

        try {
            List<Payment> payments = paymentService.getPaymentsByCustomerCuit(cuit);
            return ResponseEntity.ok().body(payments);
        } catch (Exception e) {
            ErrorDetail errorDetails = new ErrorDetail();
            errorDetails.setCode(HttpStatus.BAD_REQUEST.value());
            errorDetails.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorResponse(errorDetails));
        }
    }

    @Transactional
    @PostMapping()
    @Operation(summary = "Create a new payment")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payment successfully created"),
        @ApiResponse(responseCode = "401", description = "Not authorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
    })
    public ResponseEntity<?> savePayment(@Valid @RequestBody Payment payment) {

        try {
            Payment newPayment = paymentService.createPayment(payment);
            return ResponseEntity.ok().body(newPayment);
        } catch (Exception e) {
            ErrorDetail errorDetails = new ErrorDetail();
            errorDetails.setCode(HttpStatus.BAD_REQUEST.value());
            errorDetails.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorResponse(errorDetails));
        }
    }

}
