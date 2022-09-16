package com.innovedcol.ecofamily.services;

import com.innovedcol.ecofamily.entities.Enterprise;
import com.innovedcol.ecofamily.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EnterpriseService {

    // Definimos un atributo de tipo repositorio
    private final EnterpriseRepository repository;

    public EnterpriseService(EnterpriseRepository repository) {
        this.repository = repository;
    }

    // Método que retorna un arraylist con el listado de las empresas
    public ArrayList<Enterprise> getEnterprisesList(){
        return (ArrayList<Enterprise>) repository.findAll();
    }

    // Método que retorna un objeto de tipo Enterprise según su ID
    public Optional<Enterprise> searchEnterprise(Long id){
        return repository.findById(id);
    }

    // Método que crea una empresa y la añade a la base de datos. Retorna un mensaje
    public String createEnterprise(Enterprise e){
        repository.save(e);
        return "--> La empresa " + e.getName() + " fue creada satisfactoriamente!";
    }

    // Método que actualiza la informacion de una empresa según su id. Retorna un mensaje
    public Enterprise updateEnterprise(Long id, Enterprise e){
        if(searchEnterprise(id).isPresent()){
            return repository.save(e);
        }else{
            return null;
        }
    }

    // Método que elimina una empresa de la base de datos. Retorna un mensaje
    public String deleteEnterprise(Long id){
        repository.deleteById(id);
        return "--> La empresa con ID " + id + " fue eliminada satisfactoriamente!";
    }
}
