package com.innovedcol.ecofamily.services;

import com.innovedcol.ecofamily.entities.Employee;
import com.innovedcol.ecofamily.repositories.EmployeeRepository;
import com.innovedcol.ecofamily.repositories.EnterpriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class EmployeeService {

    // Definimos atributos de los repositorios para hacer inyeccion de dependencias
    private final EmployeeRepository employeeRepository;
    private final EnterpriseRepository enterpriseRepository;

    // Constructor creado con la anotacion @AllArgsConstructor

    // Metodo que retorna una lista de empleados
    public List<Employee> employeesList() {
        return employeeRepository.findAll();
    }

    // Método que retorna un objeto de tipo Employee según su ID
    public Optional<Employee> searchEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    // Método que retorna los empleados por su nombre y su empresa (filtrado)
    public Optional<Employee> employeeByEnterprise(String nombre, Long idEmpresa){
        if(nombre != null){
            return employeeRepository.findByName(nombre);
        }
        if (idEmpresa != null){
            return employeeRepository.findByEnterprise(idEmpresa);
        }
        return Optional.empty();
    }

    // Método que crea un empleado y la añade a la base de datos. Retorna un objeto de tipo Employee
    //TODO: Verificar que pasa si no encuentra la empresa.
    public Employee createEmployee(Long enterprise_id, Employee e) {
        try {
            return enterpriseRepository.findById(enterprise_id).map(ent -> {
                e.setEnterprise(ent);
                return employeeRepository.save(e);
            }).get();
        } catch (Exception ex) {
            System.out.println("Error = " + ex);
            return null;
        }
    }

    // Método que actualiza la informacion de un empleado según su id. Retorna un mensaje
    public Employee updateEmployee(Long id, Employee e){
        if(searchEmployee(id).isPresent()){
            return employeeRepository.save(e);
        }else{
            return null;
        }
    }

    // Método que elimina un empleado de la base de datos. Retorna un mensaje
    public String deleteEmployee(Long id) {
        if(searchEmployee(id).isPresent()){
            employeeRepository.deleteById(id);
            return "--> El empleado se eliminó correctamente!";
        }else{
            return "--> El empleado indicado no existe!";
        }
    }
}
