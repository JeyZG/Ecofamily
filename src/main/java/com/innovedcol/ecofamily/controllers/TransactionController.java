package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Transaction;
import com.innovedcol.ecofamily.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TransactionController {

    // Declaramos un objeto de tipo TransactionService
    TransactionService transactionService;

    // Constructor
    public TransactionController() {
        // Inicializamos el servicio de transacciones
        this.transactionService = new TransactionService();
    }

    // Metodo para llamar al servicio que muestra el listado de transacciones
    @GetMapping("/transactions")
    public ArrayList<Transaction> TransactionList(){
        return this.transactionService.getTransactionsList();
    }

    // Metodo para llamar al servicio que crea una nueva transaccion
    @PostMapping("/transactions")
    public String createEmployee(@RequestBody Transaction t){
        return this.transactionService.createTransaction(t);
    }

    // Metodo para llamar al servicio que busca una transaccion segun su index
    @GetMapping("/transaction/{index}")
    public Transaction searchTransaction(@PathVariable("index") Integer index){
        return this.transactionService.searchTransaction(index);
    }

    // Metodo para llamar al servicio que actualiza la info de una transaccion
    @PatchMapping("/transaction/{index}")
    public String updateTransaction(@PathVariable("index") Integer index, @RequestBody Transaction t){
        return this.transactionService.updateTransaction(index,t);
    }

    // Metodo para llamar al servicio que eliminar una transaccion
    @DeleteMapping("/transaction/{index}")
    public String deleteTransaction(@PathVariable("index") Integer index){
        return this.transactionService.deleteTransaction(index);
    }
}
