package com.parqueadero.model;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
	private String nombre;
	private String direccion;
	private String representante;
	private String contacto;
	private int espaciosDisponiblesMotos;
	private int espaciosDisponiblesCarros;
	private int espaciosDisponiblesCamiones;
//	private ArrayList<Tarifa> tarifas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<IngresoSalida> ingresos;
	private ArrayList<Factura> facturas;
	
	// Constructor vacío y con parámetros
	
	public Parqueadero() {
		
		this.nombre = "";
		this.direccion = "";
		this.representante = "";
		this.contacto = "";
		this.espaciosDisponiblesMotos = 0;
		this.espaciosDisponiblesCarros = 0;
		this.espaciosDisponiblesCamiones = 0;
//		this.tarifas = new ArrayList<>(); ;
		this.clientes = new ArrayList<>();;
		this.vehiculos = new ArrayList<>();;
		this.ingresos = new ArrayList<>();;
		this.facturas = new ArrayList<>();;
		
	}
	public Parqueadero(String nombre, String direccion, String representante, String contacto,
			int espaciosDisponiblesMotos, int espaciosDisponiblesCarros, int espaciosDisponiblesCamiones,
			/*List<Tarifa> tarifas,*/ ArrayList<Cliente> clientes, ArrayList<Vehiculo> vehiculos, ArrayList<IngresoSalida> ingresos,
			ArrayList<Factura> facturas) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.representante = representante;
		this.contacto = contacto;
		this.espaciosDisponiblesMotos = espaciosDisponiblesMotos;
		this.espaciosDisponiblesCarros = espaciosDisponiblesCarros;
		this.espaciosDisponiblesCamiones = espaciosDisponiblesCamiones;
//		this.tarifas = tarifas;
		this.clientes = clientes;
		this.vehiculos = vehiculos;
		this.ingresos = ingresos;
		this.facturas = facturas;
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
	public int getEspaciosDisponiblesMotos() {
		return espaciosDisponiblesMotos;
	}
	public void setEspaciosDisponiblesMotos(int espaciosDisponiblesMotos) {
		this.espaciosDisponiblesMotos = espaciosDisponiblesMotos;
	}
	public int getEspaciosDisponiblesCarros() {
		return espaciosDisponiblesCarros;
	}
	public void setEspaciosDisponiblesCarros(int espaciosDisponiblesCarros) {
		this.espaciosDisponiblesCarros = espaciosDisponiblesCarros;
	}
	public int getEspaciosDisponiblesCamiones() {
		return espaciosDisponiblesCamiones;
	}
	public void setEspaciosDisponiblesCamiones(int espaciosDisponiblesCamiones) {
		this.espaciosDisponiblesCamiones = espaciosDisponiblesCamiones;
	}
/*	public ArrayList<Tarifa> getTarifas() {
		return tarifas;
	}
	public void setTarifas(ArrayList<Tarifa> tarifas) {
		this.tarifas = tarifas;
	} */
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
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
	
	
	// Métodos
	


}
