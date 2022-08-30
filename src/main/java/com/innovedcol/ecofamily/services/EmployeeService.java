package com.innovedcol.ecofamily.services;

import com.innovedcol.ecofamily.entities.Employee;

import java.util.ArrayList;

public class EmployeeService {

    EnterpriseService enterpriseService;

    // Creamos el arraylist que contendrá los empleados
    ArrayList<Employee> employeesList = new ArrayList<>();

    public EmployeeService() { // Constructor vacio
        this.enterpriseService = new EnterpriseService(); // Inicializamos el servicio de empresas
        this.datosIniciales(); // Se llenan los datos iniciales de los empleados
    }

    public void datosIniciales(){
        employeesList.add(new Employee("Catalina Taborda","catalina@ecofamily.com",enterpriseService.getEnterprises(0),"Admin"));
        employeesList.add(new Employee("Alejandra Moreano","alejandra@ecofamily.com",enterpriseService.getEnterprises(0),"Operario"));
        employeesList.add(new Employee("Carlos Mora","carlos@automantec.com",enterpriseService.getEnterprises(1),"Admin"));
        employeesList.add(new Employee("Alexander Carvajal","alexander@automantec.com",enterpriseService.getEnterprises(1),"Operario"));
        employeesList.add(new Employee("Matthew Zuñiga","matthew@jzgdevelopers.com",enterpriseService.getEnterprises(2),"Admin"));
        employeesList.add(new Employee("Juan Zuñiga","juan@jzgdevelopers.com",enterpriseService.getEnterprises(2),"Operario"));
    }

    // Metodo que retorna el arraylist de todos los empleados
    public ArrayList<Employee> getEmployeesList(){
        return employeesList;
    }

    // Metodo que retorna la informacion de un empleado del listado segun su index
    public Employee searchEmployee(int index){
        return employeesList.get(index);
    }

    // Metodo que crea un empleado y lo añade al listado. Retorna un mensaje
    public String createEmployee(Employee e){
        employeesList.add(e);
        return "--> Employee creado";
    }

    // Metodo que actualiza la informacion de un empleado segun su index. Retorna un mensaje
    public String updateEmployee(int index, Employee e){
        employeesList.set(index, e);
        return "--> Employee actualizado";
    }

    // Metodo que elimina un empleado del listado. Retorna un mensaje
    public String deleteEmployee(int index){
        employeesList.remove(index);
        return "--> Employee eliminado";
    }

}
