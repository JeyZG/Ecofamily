package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Transaction;
import com.innovedcol.ecofamily.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TransactionController {

    // Declaramos un objeto de tipo TransactionService
    TransactionService service;

    // Constructor
    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    // Método para llamar al servicio que muestra el listado de transacciones
    @GetMapping("/movements")
    public ArrayList<Transaction> TransactionList(){
        return this.service.getTransactionsList();
    }

    // Método para llamar al servicio que crea una nueva transacción
    @PostMapping("/movements")
    public String createTransaction(@RequestBody Transaction t){
        return this.service.createTransaction(t);
    }

    // Método para llamar al servicio que busca una transacción según su index
    @GetMapping("/movements/{id}")
    public Optional<Transaction> searchTransaction(@PathVariable("id") Long id){
        return this.service.searchTransaction(id);
    }

    // Método para llamar al servicio que actualiza la info de una transacción
    @PatchMapping("/movements/{id}")
    public String updateTransaction(@PathVariable("id") Long id, @RequestBody Transaction t){
        return this.service.updateTransaction(id,t);
    }

    // Método para llamar al servicio que eliminar una transacción
    @DeleteMapping("/movements/{id}")
    public String deleteTransaction(@PathVariable("id") Long id){
        return this.service.deleteTransaction(id);
    }
}
