package com.innovedcol.ecofamily.services;


import com.innovedcol.ecofamily.entities.Transaction;
import com.innovedcol.ecofamily.repositories.EmployeeRepository;
import com.innovedcol.ecofamily.repositories.EnterpriseRepository;
import com.innovedcol.ecofamily.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionService {

    // Definimos un atributo de tipo repositorio
    private final TransactionRepository transactionRepository;
    private final EmployeeRepository employeeRepository;
    private final EnterpriseRepository enterpriseRepository;

    // Constructor
    public TransactionService(TransactionRepository transactionRepository, EmployeeRepository employeeRepository, EnterpriseRepository enterpriseRepository) {
        this.transactionRepository = transactionRepository;
        this.employeeRepository = employeeRepository;
        this.enterpriseRepository = enterpriseRepository;
    }

    // Método que retorna un arraylist con el listado de las transacciones
    public ArrayList<Transaction> getTransactionsList(){
        return (ArrayList<Transaction>) transactionRepository.findAll();
    }

    // Método que retorna un objeto de tipo Transaction según su ID
    public Optional<Transaction> searchTransaction(Long id){
        return transactionRepository.findById(id);
    }

    //TODO: Modificar como sé hizo con la creacion de un nuevo empleado, por las relaciones
    // Método que crea una transacción y la añade a la base de datos. Retorna un mensaje
    public Transaction createTransaction(Long user_id, Long enterprise_id, Transaction t){
        /*transactionRepository.save(t);
        return "--> La transacción con ID " + t.getId() + " fue creada satisfactoriamente!";
        */
        try {
            employeeRepository.findById(user_id).map(usr -> {
                t.setUser(usr);
                return usr;
            });
            return enterpriseRepository.findById(enterprise_id).map(ent -> {
                t.setEnterprise(ent);
                return transactionRepository.save(t);
            }).get();
        } catch (Exception ex) {
            System.out.println("Error = " + ex);
            return null;
        }
    }

    // Método que actualiza la información de una transacción según su id. Retorna un mensaje
    public String updateTransaction(Long id, Transaction t){
        //TODO: Completar esta parte del codigo
        return "--> La transacción con ID " + t.getId() + " fue actualizada satisfactoriamente!";
    }

    // Método que elimina una transacción de la base de datos. Retorna un mensaje
    public String deleteTransaction(Long id){
        transactionRepository.deleteById(id);
        return "--> La transacción con ID " + id + " fue eliminada satisfactoriamente!";
    }

}
