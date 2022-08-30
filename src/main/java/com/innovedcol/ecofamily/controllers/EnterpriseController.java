package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Enterprise;
import com.innovedcol.ecofamily.services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EnterpriseController {

    // Declaramos un objeto de tipo EnterpriseService
    EnterpriseService enterpriseService;

    // Constructor
    public EnterpriseController() {
        // Inicializamos el servicio de empresas
        this.enterpriseService = new EnterpriseService();
    }

    // Metodo para llamar al servicio que muestra el listado de empresas
    @GetMapping("/enterprises")
    public ArrayList<Enterprise> EnterprisesList(){
        return this.enterpriseService.getEnterprisesList();
    }

    // Metodo para llamar al servicio que crea una nueva empresa
    @PostMapping("/enterprises")
    public String createEnterprise(@RequestBody Enterprise e){
        return this.enterpriseService.createEnterprise(e);
    }

    // Metodo para llamar al servicio que busca una empresa segun su index
    @GetMapping("/enterprises/{index}")
    public Enterprise searchEnterprise(@PathVariable("index") Integer index){
        return this.enterpriseService.searchEnterprise(index);
    }

    // Metodo para llamar al servicio que actualiza la info de una empresa
    @PatchMapping("/enterprises/{index}")
    public String updateEnterprise(@PathVariable("index") Integer index, @RequestBody Enterprise e){
        return this.enterpriseService.updateEnterprise(index,e);
    }

    // Metodo para llamar al servicio que eliminar una empresa
    @DeleteMapping("/enterprises/{index}")
    public String deleteEnterprise(@PathVariable("index") Integer index){
        return this.enterpriseService.deleteEnterprise(index);
    }

}
