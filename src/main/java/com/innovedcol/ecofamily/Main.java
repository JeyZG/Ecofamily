package com.innovedcol.ecofamily;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo!");

        //TEST//

        //Clase empleado:
        Empleado emp= new Empleado("Mario","XXXX@gmail.com","EcoFamily","Almacenista");
        System.out.println(emp.toString());

        emp.setNombre("Hellder");
        emp.setCorreo("cccc@gmail.com");
        emp.setRol("Contador");
        emp.setEmpresaContratante("EcoFamily2");
        System.out.println(emp.toString()); //Cambios de datos.

    }
}
