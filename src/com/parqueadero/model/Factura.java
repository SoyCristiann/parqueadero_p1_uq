package com.parqueadero.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Factura {
	
	private Parqueadero parqueadero;
	private Vehiculo vehiculo;
	private double monto;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	
	
	// Constructor vacío y con parámetros
	
	public Factura() {
		
		this.parqueadero = new Parqueadero();
		//this.vehiculo = new Vehiculo();
		this.monto = 0.0;
		this.fechaEntrada = LocalDateTime.now();
		this.fechaSalida = LocalDateTime.now();
		
	}
	
	public Factura(Parqueadero parqueadero, Vehiculo vehiculo, double monto, LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
		
		this.parqueadero = parqueadero;
		this.vehiculo = vehiculo;
		this.monto = monto;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	
	
	// Métodos getters y setters
	
	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	// Métodos
	
	

	
	
	
}
