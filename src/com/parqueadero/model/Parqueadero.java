package com.parqueadero.model;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
	private String nombre;
	private String direccion;
	private String representante;
	private String contacto;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<IngresoSalida> ingresos;
	private ArrayList<Factura> facturas;
	
	// Constructor vacío y con parámetros
	
	public Parqueadero() {
		
		this.nombre = "";
		this.direccion = "";
		this.representante = "";
		this.contacto = "";
		this.vehiculos = new ArrayList<>();
		this.ingresos = new ArrayList<>();
		this.facturas = new ArrayList<>();
		
	}
	public Parqueadero(String nombre, String direccion, String representante, String contacto) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.representante = representante;
		this.contacto = contacto;
		this.vehiculos = new ArrayList<>();
		this.ingresos = new ArrayList<>();
		this.facturas = new ArrayList<>();
	}
	
	// Métodos getters y setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRepresentante() {
		return representante;
	}
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public ArrayList<IngresoSalida> getIngresos() {
		return ingresos;
	}
	public void setIngresos(ArrayList<IngresoSalida> ingresos) {
		this.ingresos = ingresos;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	



}
