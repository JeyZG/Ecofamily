package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Empresa;
import com.innovedcol.ecofamily.services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EnterpriseController {

    EnterpriseService enterpriseService;

    public EnterpriseController() {
        this.enterpriseService = new EnterpriseService(); // Inicializamos el servicio de empresas
    }

    // Metodo para llamar al servicio que muestra el listado de empresas
    @GetMapping("/enterprises")
    public ArrayList<Empresa> EnterprisesList(){
        return this.enterpriseService.getEnterprisesList();
    }

    // Metodo para llamar al servicio que crea una nueva empresa
    @PostMapping("/enterprises")
    public String createEnterprise(@RequestBody Empresa e){
        return this.enterpriseService.createEnterprise(e);
    }

    // Metodo para llamar al servicio que busca una empresa segun su index
    @GetMapping("/enterprises/{index}")
    public Empresa searchEnterprise(@PathVariable("index") Integer index){
        return this.enterpriseService.searchEnterprise(index);
    }

    // Metodo para llamar al servicio que actualiza la info de una empresa
    @PatchMapping("/enterprises/{index}")
    public String updateEnterprise(@PathVariable("index") Integer index, @RequestBody Empresa e){
        return this.enterpriseService.updateEnterprise(index,e);
    }

    // Metodo para llamar al servicio que eliminar una empresa
    @DeleteMapping("/enterprises/{index}")
    public String deleteEnterprise(@PathVariable("index") Integer index){
        return this.enterpriseService.deleteEnterprise(index);
    }

}
