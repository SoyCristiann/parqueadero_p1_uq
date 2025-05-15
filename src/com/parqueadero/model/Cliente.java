package com.parqueadero.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    // Atributos
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    // Constructor vacío
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(String nombre, String cedula, String telefono, String correo, List<Vehiculo> vehiculos) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.vehiculos = vehiculos;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public List<Vehiculo> getVehiculos() { return vehiculos; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setVehiculos(List<Vehiculo> vehiculos) { this.vehiculos = vehiculos; }

//  registrar Vehiculo
    public void registrarVehiculo(Vehiculo vehiculo) {
    	
    }

//  buscar Vehiculo
    public Vehiculo buscarVehiculo(String placa) {
        
    	return null; // vehiculoABuscar;
    }

//  actualiza rVehiculo
    public void actualizarVehiculo(Vehiculo vehiculo) {
    	
    }

    @Override
    public String toString() {
        return null;
    }
}
