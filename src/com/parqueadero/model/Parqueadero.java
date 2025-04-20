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
	private List<Tarifa> tarifas;
	private List<Cliente> clientes;
	private List<Vehiculo> vehiculos;
	private List<IngresoSalida> ingresos;
	private List<Factura> facturas;
	
	// Constructor vacío y con parámetros
	
	public Parqueadero() {
		
		this.nombre = "";
		this.direccion = "";
		this.representante = "";
		this.contacto = "";
		this.espaciosDisponiblesMotos = 0;
		this.espaciosDisponiblesCarros = 0;
		this.espaciosDisponiblesCamiones = 0;
		this.tarifas = new ArrayList<>(); ;
		this.clientes = new ArrayList<>();;
		this.vehiculos = new ArrayList<>();;
		this.ingresos = new ArrayList<>();;
		this.facturas = new ArrayList<>();;
		
	}
	public Parqueadero(String nombre, String direccion, String representante, String contacto,
			int espaciosDisponiblesMotos, int espaciosDisponiblesCarros, int espaciosDisponiblesCamiones,
			List<Tarifa> tarifas, List<Cliente> clientes, List<Vehiculo> vehiculos, List<IngresoSalida> ingresos,
			List<Factura> facturas) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.representante = representante;
		this.contacto = contacto;
		this.espaciosDisponiblesMotos = espaciosDisponiblesMotos;
		this.espaciosDisponiblesCarros = espaciosDisponiblesCarros;
		this.espaciosDisponiblesCamiones = espaciosDisponiblesCamiones;
		this.tarifas = tarifas;
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
	public List<Tarifa> getTarifas() {
		return tarifas;
	}
	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public List<IngresoSalida> getIngresos() {
		return ingresos;
	}
	public void setIngresos(List<IngresoSalida> ingresos) {
		this.ingresos = ingresos;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
	// Métodos
	


}
