package com.innovedcol.ecofamily.services;

import com.innovedcol.ecofamily.entities.Empleado;

import java.util.ArrayList;

public class EmployeeService {

    EnterpriseService enterpriseService;

    // Creamos el arraylist que contendrá los empleados
    ArrayList<Empleado> employeesList = new ArrayList<>();

    public EmployeeService() { // Constructor vacio
        this.enterpriseService = new EnterpriseService(); // Inicializamos el servicio de empresas
        this.datosIniciales(); // Se llenan los datos iniciales de los empleados
    }

    public void datosIniciales(){
        employeesList.add(new Empleado("Catalina Taborda","catalina@ecofamily.com",enterpriseService.getEnterprises(0),"Admin"));
        employeesList.add(new Empleado("Alejandra Moreano","alejandra@ecofamily.com",enterpriseService.getEnterprises(0),"Operario"));
        employeesList.add(new Empleado("Carlos Mora","carlos@automantec.com",enterpriseService.getEnterprises(1),"Admin"));
        employeesList.add(new Empleado("Alexander Carvajal","alexander@automantec.com",enterpriseService.getEnterprises(1),"Operario"));
        employeesList.add(new Empleado("Matthew Zuñiga","matthew@jzgdevelopers.com",enterpriseService.getEnterprises(2),"Admin"));
        employeesList.add(new Empleado("Juan Zuñiga","juan@jzgdevelopers.com",enterpriseService.getEnterprises(2),"Operario"));
    }

    // Metodo que retorna el arraylist de todos los empleados
    public ArrayList<Empleado> getEmployeesList(){
        return employeesList;
    }

    // Metodo que retorna la informacion de un empleado del listado segun su index
    public Empleado searchEmployee(int index){
        return employeesList.get(index);
    }

    // Metodo que crea un empleado y lo añade al listado. Retorna un mensaje
    public String createEmployee(Empleado e){
        employeesList.add(e);
        return "--> Empleado creado";
    }

    // Metodo que actualiza la informacion de un empleado segun su index. Retorna un mensaje
    public String updateEmployee(int index, Empleado e){
        employeesList.set(index, e);
        return "--> Empleado actualizado";
    }

    // Metodo que elimina un empleado del listado. Retorna un mensaje
    public String deleteEmployee(int index){
        employeesList.remove(index);
        return "--> Empleado eliminado";
    }

}
