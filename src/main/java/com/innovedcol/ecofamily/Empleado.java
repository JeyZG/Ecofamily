package com.innovedcol.ecofamily;

public class Empleado {

    String nombre;
    String correo;
    String empresaContratante;
    String rol;

    public Empleado(String nombre, String correo, String empresaContratante, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaContratante = empresaContratante;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpresaContratante() {
        return empresaContratante;
    }

    public void setEmpresaContratante(String empresaContratante) {
        this.empresaContratante = empresaContratante;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", empresaContratante='" + empresaContratante + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
