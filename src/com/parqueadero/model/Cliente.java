package com.parqueadero.model;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String cedula;
	private String telefono;
	private String correo;
	private ArrayList<Vehiculo>vehiculos;
	
	
	// Constructor vacío y con parámetros
	public Cliente() {
		
		this.nombre = "";
		this.cedula = "";
		this.telefono = "";
		this.correo = "";
		this.vehiculos = new ArrayList<>();
		
	}
	
	public Cliente(String nombre, String cedula, String telefono, String correo, ArrayList<Vehiculo> vehiculos) {
		
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.correo = correo;
		this.vehiculos = vehiculos;
	}
	
	// Métodos getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	
	
	// Métodos
	
}
