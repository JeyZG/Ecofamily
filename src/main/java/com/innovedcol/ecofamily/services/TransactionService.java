package com.innovedcol.ecofamily.services;

import com.innovedcol.ecofamily.entities.Transaction;
import com.innovedcol.ecofamily.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TransactionService {

    // Definimos un atributo de tipo repositorio
    private final TransactionRepository repository;

    // Constructor
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    // Método que retorna un arraylist con el listado de las transacciones
    public ArrayList<Transaction> getTransactionsList(){
        return (ArrayList<Transaction>) repository.findAll();
    }

    // Método que retorna un objeto de tipo Transaction según su ID
    public Optional<Transaction> searchTransaction(Long id){
        return repository.findById(id);
    }

    // Método que crea una transacción y la añade a la base de datos. Retorna un mensaje
    public String createTransaction(Transaction t){
        repository.save(t);
        return "--> La transacción con ID " + t.getId() + " fue creada satisfactoriamente!";
    }

    // Método que actualiza la información de una transacción según su id. Retorna un mensaje
    public String updateTransaction(Long id, Transaction t){
        //TODO: Completar esta parte del codigo
        return "--> La transacción con ID " + t.getId() + " fue actualizada satisfactoriamente!";
    }

    // Método que elimina una transacción de la base de datos. Retorna un mensaje
    public String deleteTransaction(Long id){
        repository.deleteById(id);
        return "--> La transacción con ID " + id + " fue eliminada satisfactoriamente!";
    }

}
