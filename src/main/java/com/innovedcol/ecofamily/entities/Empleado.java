package com.innovedcol.ecofamily.entities;

public class Empleado {

    private String nombre;
    private String correo;
    private Empresa empresaContratante;
    private String rol;

    public Empleado(String nombre, String correo, Empresa empresaContratante, String rol) {
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

    public Empresa getEmpresaContratante() {
        return empresaContratante;
    }

    public void setEmpresaContratante(Empresa empresaContratante) {
        this.empresaContratante = empresaContratante;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", empresaContratante='" + empresaContratante.getNombre() + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
