package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Employee;
import com.innovedcol.ecofamily.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class EmployeeController {

    // Declaramos un objeto de tipo EmployeeService
    private final EmployeeService service;

    // Constructor
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Método para llamar al servicio que muestra el listado de empleados
    @GetMapping("/users")
    public ResponseEntity<List<Employee>> employeeList() {
        List<Employee> empleados = service.employeesList();
        if (empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(empleados);
        }
    }
    // Método para llamar al servicio que busca un empleado según su id
    @GetMapping("/user/{id}")
    public ResponseEntity<Employee> searchEmployee(@PathVariable Long id){
        Optional<Employee> empleado = service.searchEmployee(id);
        if (empleado.isPresent()) {
            return ResponseEntity.ok(empleado.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para llamar al servicio que crea un nuevo empleado en una empresa establecida
    @PostMapping(value="/users/{ent_id}")
    public Employee createEmployee(@PathVariable("ent_id") Long ent_id, @RequestBody Employee e){
        return this.service.createEmployee(ent_id,e);
    }

    // Método para llamar al servicio que actualiza la info de un empleado segun su ID
    @PutMapping("/user/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee e){
        return this.service.updateEmployee(id,e);
    }

    // Método para llamar al servicio que eliminar un empleado segun su ID
    @DeleteMapping("/user/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        return this.service.deleteEmployee(id);
    }

}
