package com.innovedcol.ecofamily;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TEST//

        Scanner sc = new Scanner(System.in);
        int opcion = 4;

        do {
            System.out.println("\n========================================");
            System.out.println("\t--------- MENU TESTER --------- ");
            System.out.println("========================================");
            System.out.println("1. Prueba clase Empresa");
            System.out.println("2. Prueba clase Empleado");
            System.out.println("3. Prueba clase MovimientoDinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion para continuar: ");
            opcion = sc.nextInt();


            switch (opcion) {
                case 1:
                    testerEmpresa();
                    break;
                case 2:
                    testerEmpleado();
                    break;
                case 3:
                    testerMovimientoDinero();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error!! Opción incorrecta");
            }
        } while (opcion != 4);
    }

    private static void testerEmpresa() {
        //Clase Empresa:
        System.out.println("\n========================================");
        System.out.println("-- TEST DE LA CLASE EMPRESA --");
        // Nueva instancia de clase Empresa: Se crea un objeto llamado Emp
        Empresa Emp = new Empresa("Cafe", "Calle 98c #06-7", "3015900465", "1234");
        // Se imprimen los datos iniciales del objeto Emp
        System.out.println("----------------------------------------\n");
        System.out.println("*** Llamado al metodo toString() de la clase Empresa con los datos iniciales");
        System.out.println(Emp.toString());

        // Prueba de los getters
        System.out.println("----------------------------------------\n");
        System.out.println("*** Prueba de Getters");
        // Lectura del nombre
        System.out.println("Nombre de la empresa: " + Emp.getNombre());
        // Lectura de la direccion
        System.out.println("Direccion de la empresa: " + Emp.getDireccion());
        // Lectura del telefono
        System.out.println("Telefono de la empresa: " + Emp.getTelefono());
        // Lectura del NIT
        System.out.println("NIT de la empresa: " + Emp.getNit());

        //Prueba de los setters:
        System.out.println("----------------------------------------\n");
        System.out.println("*** Prueba de Setters");
        // Modificacion del nombre
        Emp.setNombre("Panadería");
        System.out.println("Se cambió el nombre...");
        // Modificacion de la direccion
        Emp.setDireccion("CAlle98_34-02");
        System.out.println("Se cambió la dirección...");
        // Modificacion del telefono
        Emp.setTelefono("30259066");
        System.out.println("Se cambió el telefono...");
        // Modificacion del NIT
        Emp.setNit("222999");
        System.out.println("Se cambió el NIT...");
        // Se imprimen los datos modificados del objeto Emp
        System.out.println("\n*** Llamado al metodo toString() de la clase Empresa con los datos modificados");
        System.out.println(Emp.toString());
    }

    private static void testerEmpleado() {
        //Clase Empleado:
        System.out.println("\n========================================");
        System.out.println("-- TEST DE LA CLASE EMPLEADO --");
        // Nueva instancia de clase Empleado: Se crea un objeto llamado emp
        Empleado emp = new Empleado("Mario", "XXXX@gmail.com", "EcoFamily", "Almacenista");

        // Se imprimen los datos iniciales del objeto emp
        System.out.println("----------------------------------------\n");
        System.out.println("*** Llamado al metodo toString() de la clase Empleado con los datos iniciales");
        System.out.println(emp.toString());

        // Prueba de los getters
        System.out.println("----------------------------------------\n");
        System.out.println("*** Prueba de Getters");
        // Lectura del nombre
        System.out.println("Nombre del empleado: " + emp.getNombre());
        // Lectura del correo
        System.out.println("Correo del empleado: " + emp.getCorreo());
        // Lectura de la empresa contratante
        System.out.println("Empresa contratante: " + emp.getEmpresaContratante());
        // Lectura del rol
        System.out.println("Rol del empleado: " + emp.getRol());

        //Prueba de los setters:
        System.out.println("----------------------------------------\n");
        System.out.println("*** Prueba de Setters");
        // Modificacion del nombre
        emp.setNombre("Hellder");
        System.out.println("Se cambió el nombre...");
        // Modificacion del correo
        emp.setCorreo("cccc@gmail.com");
        System.out.println("Se cambió el correo...");
        // Modificacion de la empresa contratante
        emp.setEmpresaContratante("EcoFamily2");
        System.out.println("Se cambió la empresa contratante...");
        // Modificacion del rol
        emp.setRol("Contador");
        System.out.println("Se cambió el rol...");
        // Se imprimen los datos modificados del objeto emp
        System.out.println("\n*** Llamado al metodo toString() de la clase Empleado con los datos modificados");
        System.out.println(emp.toString());
    }

    private static void testerMovimientoDinero() {

        //Clase MovimientoDinero:
        System.out.println("\n========================================");
        System.out.println("-- TEST DE LA CLASE MOVIMIENTODINERO --");
        // Nueva instancia de clase  MovimientoDinero: Se crea un objeto llamado mov
        MovimientoDinero mov = new MovimientoDinero(20000, "Consignacion inicial", "consignacion", "Hellder");

        // Se imprimen los datos iniciales del objeto mov
        System.out.println("----------------------------------------\n");
        System.out.println("*** Llamado al metodo toString() de la clase MovimientoDinero con los datos iniciales");
        System.out.println(mov.toString());

        // Prueba de los getters
        System.out.println("----------------------------------------\n");
        System.out.println("*** Prueba de Getters");
        // Lectura del monto
        System.out.println("Monto del movimiento: " + mov.getMonto());
        // Lectura del concepto
        System.out.println("Concepto del movimiento: " + mov.getConcepto());
        // Lectura del tipo de movimiento
        System.out.println("Tipo de movimiento: " + mov.getTipoMovimiento());
        // Lectura del usuario que realiza el movimiento
        System.out.println("Rol del empleado: " + mov.getUsuario());

        //Prueba de los setters:
        System.out.println("----------------------------------------\n");
        System.out.println("*** Prueba de Setters");
        // Modificacion del monto (valor negativo)
        mov.setMonto(-20000);
        System.out.println("Se cambió el monto (valor negativo)...");
        // Modificacion del concepto
        mov.setConcepto("Retiro de $20000");
        System.out.println("Se cambió el concepto...");
        // Modificacion del tipo de movimiento
        mov.setTipoMovimiento("retiro");
        System.out.println("Se cambió el tipo de movimiento...");
        // Modificacion del usuario que realiza el movimiento
        mov.setUsuario("Jeyson");
        System.out.println("Se cambió el usuario que realiza el movimiento...");
        // Se imprimen los datos modificados del objeto mov
        System.out.println("\n*** Llamado al metodo toString() de la clase MovimientoDinero con los datos modificados");
        System.out.println(mov.toString() + "\n");
        // Modificacion del monto (valor positivo)
        mov.setMonto(50000);
        System.out.println("Se cambió el monto (valor positivo)...");
        // Modificacion del concepto
        mov.setConcepto("Consignacion de $50000");
        System.out.println("Se cambió el concepto...");
        // Modificacion del tipo de movimiento
        mov.setTipoMovimiento("consignacion");
        System.out.println("Se cambió el tipo de movimiento...");
        // Se imprimen los datos modificados del objeto mov
        System.out.println("\n*** Llamado al metodo toString() de la clase MovimientoDinero con los datos modificados");
        System.out.println(mov.toString());

    }
}
