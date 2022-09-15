package com.innovedcol.ecofamily.services;

import com.innovedcol.ecofamily.entities.Employee;
import com.innovedcol.ecofamily.repositories.EmployeeRepository;
import com.innovedcol.ecofamily.repositories.EnterpriseRepository;
import com.innovedcol.ecofamily.repositories.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EmployeeService {

    // Definimos un atributo de tipo repositorio
    private final EmployeeRepository employeeRepository;
    private final ProfileRepository profileRepository;
    private final EnterpriseRepository enterpriseRepository;

    // Constructor
    public EmployeeService(EmployeeRepository employeeRepository, ProfileRepository profileRepository, EnterpriseRepository enterpriseRepository) {
        this.employeeRepository = employeeRepository;
        this.profileRepository = profileRepository;
        this.enterpriseRepository = enterpriseRepository;
    }

    // Metodo que retorna una lista de empleados
    public ArrayList<Employee> employeesList() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    // Método que retorna un objeto de tipo Employee según su ID
    public Optional<Employee> searchEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    // Método que crea un empleado y la añade a la base de datos. Retorna un objeto de tipo Employee
    public Employee createEmployee(Long profile_id, Long enterprise_id, Employee e) {
        try {
            profileRepository.findById(profile_id).map(prof -> {
                e.setProfile(prof);
                return prof;
            });
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
    public String updateEmployee(Long id, Employee e){
        if(searchEmployee(id).isPresent()){
            employeeRepository.save(e);
            return "--> Empleado actualizada con éxito!";
        }else{
            return "--> El empleado indicado no existe!";
        }
    }

    // Método que actualiza la informacion de un empleado según su id y los campos que se indiquen en el body. Retorna un objeto de tipo Employee
    public Employee updateFieldEmployee(Long id, Map<Object, Object> employeeMap) {
        try {
            if (searchEmployee(id).isPresent()) {
                Employee empleado = employeeRepository.findById(id).get();

                employeeMap.forEach((key, value) -> {
                    Field campo = ReflectionUtils.findField(Employee.class, (String) key);
                    if (((String) key).contains("update")) {
                        assert campo != null;
                        campo.setAccessible(true);
                        //ReflectionUtils.setField(campo, empleado, ((Date) value));
                        try {
                            ReflectionUtils.setField(campo, empleado, new SimpleDateFormat("yyyy-MM-dd").parse(((String) value)));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        assert campo != null;
                        campo.setAccessible(true);
                        ReflectionUtils.setField(campo, empleado, value);
                    }
                });

                return employeeRepository.save(empleado);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Método que elimina un empleado de la base de datos. Retorna un mensaje
    public String deleteEmployee(Long id) {
        if(searchEmployee(id).isPresent()){
            employeeRepository.deleteById(id);
            return "--> El empleado con ID " + id + " fue eliminado satisfactoriamente!";
        }else{
            return "--> El empleado indicado no existe!";
        }

    }



}
