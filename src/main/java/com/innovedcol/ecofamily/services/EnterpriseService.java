package com.innovedcol.ecofamily.services;

import com.innovedcol.ecofamily.entities.Enterprise;
import com.innovedcol.ecofamily.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EnterpriseService {

    // Definimos un atributo de tipo repositorio
    private final EnterpriseRepository repository;

    public EnterpriseService(EnterpriseRepository repository) {
        this.repository = repository;
    }

    // Metodo que retorna un arraylist con el listado de las empresas
    public ArrayList<Enterprise> getEnterprisesList(){
        return (ArrayList<Enterprise>) repository.findAll();
    }

    // Metodo que retorna un objeto de tipo Enterprise segun su ID
    public Optional<Enterprise> searchEnterprise(Long id){
        return repository.findById(id);
    }

    // Metodo que crea una empresa y la añade a la base de datos. Retorna un mensaje
    public String createEnterprise(Enterprise e){
        repository.save(e);
        return "--> La empresa " + e.getName() + " fue creada satisfactoriamente!";
    }

    // Metodo que actualiza la informacion de una empresa segun su id. Retorna un mensaje
    public String updateEnterprise(Long id, Enterprise e){
        return "--> La empresa" + e.getName() + " fue actualizada satisfactoriamente!";
    }

    // Metodo que elimina una empresa del listado. Retorna un mensaje
    public String deleteEnterprise(Long id){
        repository.deleteById(id);
        return "--> La empresa seleccionada fue eliminada satisfactoriamente!";
    }

}
