package com.innovedcol.ecofamily.entities;

public class MovimientoDinero {

    private double monto;
    private String concepto;
    private String  tipoMovimiento;
    private Empleado usuario;

    public MovimientoDinero(double monto, String concepto, String tipoMovimiento, Empleado usuario) {
        this.monto = monto;
        this.concepto = concepto;
        this.tipoMovimiento = tipoMovimiento;
        this.usuario = usuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "monto=" + monto +
                ", concepto='" + concepto + '\'' +
                ", tipoMovimiento='" + tipoMovimiento + '\'' +
                ", usuario='" + usuario.getNombre() + '\'' +
                '}';
    }
}