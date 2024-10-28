package com.example.demo.controller;

import com.example.demo.dto.TransactionDTO;
import com.example.demo.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        try {
            transactionService.processTransaction(transactionDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Transaction processed successfully");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
