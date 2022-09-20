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

    // Constructor creado con la anotacion de la linea 11

    // Metodo que retorna una lista de empleados
    public List<Employee> employeesList() {
        return employeeRepository.findAll();
    }

    // Método que retorna un objeto de tipo Employee según su ID
    public Optional<Employee> searchEmployee(Long id) {
        return employeeRepository.findById(id);
    }


    // Método que crea un empleado y la añade a la base de datos. Retorna un objeto de tipo Employee
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
    /*
    public Employee updateEmployee(Long id, Map<Object, Object> employeeMap) {
        if (searchEmployee(id).isPresent()) {
            Employee empleado = employeeRepository.findById(id).get();
            employeeMap.forEach((key, value) -> {
                try{

                    Field campo = ReflectionUtils.findField(Employee.class, (String) key);
                    System.out.println(value.getClass());
                    campo.setAccessible(true);
                    switch (key.toString()){
                        case "id":
                            ReflectionUtils.setField(campo, empleado, (Long) value);
                            break;
                        case "transactions":
                            ReflectionUtils.setField(campo, empleado, (ArrayList<Transaction>)value);
                            break;
                        case "enterprise":
                            ReflectionUtils.setField(campo, empleado, (ArrayList<Enterprise>)value);
                            break;
                        case "role":
                            ReflectionUtils.setField(campo, empleado, (EnumRoleEmployee) value);
                            break;
                        case "name":
                        case "email":
                        case "phone":
                        case "image":
                            ReflectionUtils.setField(campo, empleado, value);
                        break;
                    }
                    ReflectionUtils.setField(campo, empleado, value);
                }catch (Exception e){
                    System.out.println(value.getClass() + " | Error | " + value.toString());
                }

            });
            return employeeRepository.save(empleado);
        } else {
            return null;
        }
    }
    */
    // Método que elimina un empleado de la base de datos. Retorna un mensaje
    public String deleteEmployee(Long id) {
        if(searchEmployee(id).isPresent()){
            employeeRepository.deleteById(id);
            return "--> El empleado se eliminó correctamente!";
        }else{
            return "--> El empleado indicado no existe!";
        }
    }

    /*
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

*/
}
