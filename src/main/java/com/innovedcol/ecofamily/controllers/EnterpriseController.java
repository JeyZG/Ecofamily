package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Enterprise;
import com.innovedcol.ecofamily.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class EnterpriseController {

    // Declaramos un objeto de tipo EnterpriseService
    private EnterpriseService service;

    // Constructor
    @Autowired
    public EnterpriseController(EnterpriseService service) {
        this.service = service;
    }

    // Metodo para llamar al servicio que muestra el listado de empresas
    @GetMapping("/enterprises")
    public ArrayList<Enterprise> EnterprisesList(){
        return this.service.getEnterprisesList();
    }

    // Metodo para llamar al servicio que crea una nueva empresa
    @PostMapping("/enterprises")
    public String createEnterprise(@RequestBody Enterprise e){
        return this.service.createEnterprise(e);
    }

    // Metodo para llamar al servicio que busca una empresa segun su id
    @GetMapping("/enterprises/{id}")
    public Optional<Enterprise> searchEnterprise(@PathVariable("id") Long id){
        return this.service.searchEnterprise(id);
    }

    // Metodo para llamar al servicio que actualiza la info de una empresa
    @PutMapping("/enterprises/{id}")
    public String updateEnterprise(@PathVariable("id") Long id, @RequestBody Enterprise e){
        return this.service.updateEnterprise(id,e);
    }

    // Metodo para llamar al servicio que eliminar una empresa
    @DeleteMapping("/enterprises/{id}")
    public String deleteEnterprise(@PathVariable("id") Long id){
        return this.service.deleteEnterprise(id);
    }

}
