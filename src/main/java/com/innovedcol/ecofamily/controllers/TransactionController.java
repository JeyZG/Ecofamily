package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Transaction;
import com.innovedcol.ecofamily.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TransactionController {

    // Declaramos un objeto de tipo TransactionService
    TransactionService service;

    // Constructor
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    // Método para llamar al servicio que muestra el listado de transacciones
    @GetMapping("/movements")
    public ArrayList<Transaction> TransactionList(){
        return this.service.getTransactionsList();
    }

    // Método para llamar al servicio que crea una nueva transacción
    @PostMapping("/movements/{usr_id}/{ent_id}")
    public Transaction createTransaction(@PathVariable("usr_id") Long usr_id, @PathVariable("ent_id") Long ent_id, @RequestBody Transaction t){
        return this.service.createTransaction(usr_id, ent_id,t);
    }

    // Método para llamar al servicio que busca una transacción según su id
    @GetMapping("/movements/{id}")
    public Optional<Transaction> searchTransaction(@PathVariable("id") Long id){
        return this.service.searchTransaction(id);
    }

    // Método para llamar al servicio que actualiza la info de una transacción
    @PutMapping("/movements/{id}")
    public String updateTransaction(@PathVariable("id") Long id, @RequestBody Transaction t){
        return this.service.updateTransaction(id,t);
    }

    // Método para llamar al servicio que eliminar una transacción
    @DeleteMapping("/movements/{id}")
    public String deleteTransaction(@PathVariable("id") Long id){
        return this.service.deleteTransaction(id);
    }
}
