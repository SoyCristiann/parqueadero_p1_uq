package com.parqueadero.model;

import java.util.ArrayList;

public class Vehiculo {
	private String placa;
	private String color;
	private String modelo;
	private Cliente cliente;
	private Membresia membresia;
	
	
	// Constructor vacío y con parámetros
	public Vehiculo() {
		
		this.placa = "";
		this.color = "";
		this.modelo = "";
		this.cliente =new Cliente();
		this.membresia = new Membresia();
		
	}
	public Vehiculo(String placa, String color, String modelo, Cliente cliente, Membresia membresia) {
		
		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
		this.cliente = cliente;
		this.membresia = membresia;
	}
	
	
	// Métodos getters y setters
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
	/*public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	} */ // no puede ser valido
	
	public Membresia getMembresia() {
		return membresia;
	}
	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", color=" + color + ", modelo=" + modelo + ", cliente=" + cliente
				+ ", membresia=" + membresia + "]";
	}
	
	
	// Métodos
	
	
}
