package com.parqueadero.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Cliente {

    // Atributos
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    // Constructor vacío
    public Cliente() {
    	this.nombre = "";
        this.cedula = "";
        this.telefono = "";
        this.correo = "";
        this.vehiculos = new ArrayList<>();
    }

    // Constructor con parámetros
    public Cliente(String nombre, String cedula, String telefono, String correo) {
		
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.correo = correo;
		this.vehiculos = new ArrayList<>();
	}

    // Getters y setters
    
    public String getNombre() {
    	return nombre; }
    public String getCedula() {
    	return cedula; }
    public String getTelefono() {
    	return telefono; }
    public String getCorreo() {
    	return correo; }
    public List<Vehiculo> getVehiculos() {
    	return vehiculos; }

    public void setNombre(String nombre) {
    	this.nombre = nombre; }
    public void setCedula(String cedula) {
    	this.cedula = cedula; }
    public void setTelefono(String telefono) {
    	this.telefono = telefono; }
    public void setCorreo(String correo) {
    	this.correo = correo; }
    public void setVehiculos(List<Vehiculo> vehiculos) {
    	this.vehiculos = vehiculos; }
    

//    Metodos
    
//  registrar Vehiculo
    public void registrarVehiculo(Vehiculo vehiculo) {
    	vehiculos.add(vehiculo);   }

//  buscar Vehiculo
    public Vehiculo buscarVehiculo(String placa) {
        
    	for (Vehiculo vehiculo : vehiculos) {
    		if (vehiculo.getPlaca().equals(placa)) {
    			return vehiculo;
    		}
    	}
    	
    	return null;
    }

//  actualizar Vehiculo
    public boolean actualizarVehiculo(Vehiculo vehiculoActualizado) {
    	boolean validacion = false;
    	for (Vehiculo v : vehiculos) {
    		if (v.getPlaca().equals(vehiculoActualizado)) {
    			
    			v.setPlaca(vehiculoActualizado.getPlaca());
    			v.setColor(vehiculoActualizado.getColor());
    			v.setModelo(vehiculoActualizado.getModelo());
    			v.setMembresia(vehiculoActualizado.getMembresia());
    			
    			break;
    		}
    			
    	}
    	
    	return validacion;
    }

    
    
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", correo=" + correo
				+ ", vehiculos=" + vehiculos + "]";
	}
}
