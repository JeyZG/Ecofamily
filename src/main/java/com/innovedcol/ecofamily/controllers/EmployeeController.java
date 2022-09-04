package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Employee;
import com.innovedcol.ecofamily.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

    // Declaramos un objeto de tipo EmployeeService
    private final EmployeeService service;

    // Constructor
    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Método para llamar al servicio que muestra el listado de empleados
    @GetMapping("/users")
    public ArrayList<Employee> EmployeeList(){
        return this.service.getEmployeesList();
    }

    // Método para llamar al servicio que crea un nuevo empleado
    @PostMapping("/users")
    public String createEmployee(@RequestBody Employee e){
        return this.service.createEmployee(e);
    }


    // Método para llamar al servicio que busca un empleado según su index
    @GetMapping("/user/{id}")
    public Optional<Employee> searchEmployee(@PathVariable("id") Long id){
        return this.service.searchEmployee(id);
    }

    // Método para llamar al servicio que actualiza la info de un empleado
    @PatchMapping("/user/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee e){
        return this.service.updateEmployee(id,e);
    }

    // Método para llamar al servicio que eliminar un empleado
    @DeleteMapping("/user/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        return this.service.deleteEmployee(id);
    }
}
