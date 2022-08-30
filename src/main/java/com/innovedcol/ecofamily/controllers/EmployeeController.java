package com.innovedcol.ecofamily.controllers;

import com.innovedcol.ecofamily.entities.Employee;
import com.innovedcol.ecofamily.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmployeeController {

    // Declaramos un objeto de tipo EmployeeService
    EmployeeService employeeService;

    // Constructor
    public EmployeeController() {
        // Inicializamos el servicio de empleados
        this.employeeService = new EmployeeService();
    }

    // Metodo para llamar al servicio que muestra el listado de empleados
    @GetMapping("/users")
    public ArrayList<Employee> EmployeeList(){
        return this.employeeService.getEmployeesList();
    }

    // Metodo para llamar al servicio que crea un nuevo empleado
    @PostMapping("/users")
    public String createEmployee(@RequestBody Employee e){
        return this.employeeService.createEmployee(e);
    }

    // Metodo para llamar al servicio que busca un empleado segun su index
    @GetMapping("/user/{index}")
    public Employee searchEmployee(@PathVariable("index") Integer index){
        return this.employeeService.searchEmployee(index);
    }

    // Metodo para llamar al servicio que actualiza la info de un empleado
    @PatchMapping("/user/{index}")
    public String updateEmployee(@PathVariable("index") Integer index, @RequestBody Employee e){
        return this.employeeService.updateEmployee(index,e);
    }

    // Metodo para llamar al servicio que eliminar un empleado
    @DeleteMapping("/user/{index}")
    public String deleteEmployee(@PathVariable("index") Integer index){
        return this.employeeService.deleteEmployee(index);
    }
}
