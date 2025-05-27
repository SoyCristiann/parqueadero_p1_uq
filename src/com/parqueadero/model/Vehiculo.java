package com.parqueadero.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.Tarifable;

public abstract class Vehiculo implements Tarifable {
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private String color;
	private String modelo;
	private Cliente cliente;
	//private Membresia membresia;
	
	
	// Constructor vacío y con parámetros
	public Vehiculo() {
		this.tipoVehiculo= TipoVehiculo.INDEFINIDO;
		this.placa = "";
		this.color = "";
		this.modelo = "";
		this.cliente =new Cliente();
		//this.membresia = new Membresia();
		
	}
	public Vehiculo(TipoVehiculo tipoVehiculo, String placa, String color, String modelo, Cliente cliente) {
		this.tipoVehiculo= tipoVehiculo;
		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
		this.cliente = cliente;
		//this.membresia = membresia;
	}
	
	
	// Métodos getters y setters
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
	
	public TipoVehiculo getTipoVehiculo() {
		return this.tipoVehiculo;
	}
	
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo= tipoVehiculo;
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
	
	
	/*public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	} */ // no es valido
	
	/*public Membresia getMembresia() {
		return membresia;
	}
	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}*/
	
	public boolean confirmarVehiculo(Vehiculo vehiculo) {
		int confirmacion = JOptionPane.showConfirmDialog(null, "Confirme que el siguiente vehículo es correcto: \n" + vehiculo, "Confirmación", 0);
		System.out.println("confirmacion vehículo"+confirmacion);
		if(confirmacion==0) {
			return true;
		}
		return false;
	}
	
	public abstract double getTarifaMembresia();
	
	@Override
	public double calcularTarifa(double horas) {return 0;}
	
	
	@Override
	public String toString() {
		return "Tipo de Vehículo: " + tipoVehiculo + ", Placa: " + placa + ", Color: " + color + ", Modelo: " + modelo
				+ ", " + cliente;
	}
	
	
	
	// Métodos
	
	
}
