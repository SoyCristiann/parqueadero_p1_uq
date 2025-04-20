package com.parqueadero.model;

import java.time.LocalDateTime;

public class Pago {
	private Vehiculo vehiculo;
	private double monto; 
	private LocalDateTime fecha;
	private String tipoPago;
	
	
	// Constructor vacío y con parámetros
	
	public Pago() {
		this.vehiculo = new Vehiculo();
		this.monto = 0.0;
		this.fecha = LocalDateTime.now();;
		this.tipoPago = "";
	}
	
	public Pago(Vehiculo vehiculo, double monto, LocalDateTime fecha, String tipoPago) {

		this.vehiculo = vehiculo;
		this.monto = monto;
		this.fecha = fecha;
		this.tipoPago = tipoPago;
	}
	
	
	// Métodos getters y setters

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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	
	
	// Métodos 
	
	
	
	 
}
