package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Employee;
import com.innovedcol.ecofamily.services.EmployeeService;
import org.springframework.http.ResponseEntity;
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
        return empleado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para llamar al servicio que crea un nuevo empleado en una empresa establecida
    @PostMapping("/users/{ent_id}")
    public Employee createEmployee(@PathVariable("ent_id") Long ent_id,@RequestBody Employee e){
        return this.service.createEmployee(ent_id,e);
    }

    // Método para llamar al servicio que actualiza la info de un empleado segun su ID
    @PatchMapping("/user/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee e){
    //public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Map<Object, Object> employeeMap){
        //return this.service.updateEmployee(id, employeeMap);
        return this.service.updateEmployee(id, e);
    }

    // Método para llamar al servicio que eliminar un empleado segun su ID
    @DeleteMapping("/user/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        return this.service.deleteEmployee(id);
    }

    /*
    // Método para llamar al servicio que crea un nuevo empleado
    @PostMapping("/users/{prof_id}/{ent_id}")
    public Employee createEmployee(@PathVariable("prof_id") Long prof_id,@PathVariable("ent_id") Long ent_id,@RequestBody Employee e){
        return this.service.createEmployee(prof_id, ent_id,e);
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
    */
}
