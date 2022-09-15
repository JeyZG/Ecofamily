package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Employee;
import com.innovedcol.ecofamily.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

    // Declaramos un objeto de tipo EmployeeService
    private final EmployeeService service;

    // Constructor
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Método para llamar al servicio que muestra el listado de empleados
    @GetMapping("/users")
    public ArrayList<Employee> EmployeeList(){
        return this.service.employeesList();
    }

    // Método para llamar al servicio que crea un nuevo empleado
    @PostMapping("/users/{prof_id}/{ent_id}")
    public Employee createEmployee(@PathVariable("prof_id") Long prof_id,@PathVariable("ent_id") Long ent_id,@RequestBody Employee e){
        return this.service.createEmployee(prof_id, ent_id,e);
    }

    // Método para llamar al servicio que busca un empleado según su index
    @GetMapping("/user/{id}")
    public Optional<Employee> searchEmployee(@PathVariable("id") Long id){
        return this.service.searchEmployee(id);
    }

    // Método para llamar al servicio que actualiza la info de un empleado
    @PutMapping("/user/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee e){
        return this.service.updateEmployee(id,e);
    }

    @PatchMapping("/user/{id}")
    public Employee updateFieldEmployee(@PathVariable("id") Long id, @RequestBody Map<Object, Object> employeeMap){
        return service.updateFieldEmployee(id, employeeMap);
    }

    // Método para llamar al servicio que eliminar un empleado
    @DeleteMapping("/user/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        return this.service.deleteEmployee(id);
    }
}
