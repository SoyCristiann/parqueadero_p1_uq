package com.parqueadero.model;

import java.util.ArrayList;

public abstract class Vehiculo {
    private TipoVehiculo tipoVehiculo;
    private String placa;
    private String color;
    private String modelo;
    private Cliente cliente;
    private Membresia membresia;

    public Vehiculo() {
        this.tipoVehiculo = TipoVehiculo.INDEFINIDO;
        this.placa = "";
        this.color = "";
        this.modelo = "";
        this.cliente = new Cliente();
        this.membresia = new Membresia();
    }

    public Vehiculo(TipoVehiculo tipoVehiculo, String placa, String color, String modelo, Cliente cliente) {
        this.tipoVehiculo = tipoVehiculo;
        this.placa = placa;
        this.color = color;
        this.modelo = modelo;
        this.cliente = cliente;
        this.membresia = new Membresia();
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Tipo de Vehículo: " + tipoVehiculo + ", Placa: " + placa + ", Color: " + color + ", Modelo: " + modelo + ", Cliente: " + cliente;
    }
}
