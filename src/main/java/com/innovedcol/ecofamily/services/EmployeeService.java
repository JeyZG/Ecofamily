package com.innovedcol.ecofamily.services;

import com.innovedcol.ecofamily.entities.Employee;
import com.innovedcol.ecofamily.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    // Definimos un atributo de tipo repositorio
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Metodo que retorna un arraylist con el listado de los empleados
    public ArrayList<Employee> getEmployeesList(){
        return (ArrayList<Employee>) repository.findAll();
    }

    // Metodo que retorna un objeto de tipo Employee segun su ID
    public Optional<Employee> searchEmployee(Long id){
        return repository.findById(id);
    }

    // Metodo que crea un empleado y la añade a la base de datos. Retorna un mensaje
    public String createEmployee(Employee e){
        repository.save(e);
        return "--> El empleado [" + e.getId() +"] " + e.getEmail() + " fue creado satisfactoriamente!";
    }

    // Metodo que actualiza la informacion de un empleado segun su id. Retorna un mensaje
    public String updateEmployee(Long id, Employee e){
        //TODO: Completar esta parte del codigo
        return "--> El empleado [" + e.getId() +"] " + e.getEmail() + " fue actualizado satisfactoriamente!";
    }

    // Metodo que elimina un empleado de la base de datos. Retorna un mensaje
    public String deleteEmployee(Long id){
        repository.deleteById(id);
        return "--> El empleado con ID: " + id + " fue eliminado satisfactoriamente!";
    }

}
