package com.parqueadero.model;

import java.time.LocalDate;

public class Membresia {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private String tipoPago;
	private double monto;
	
	// Constructor vacío y con parámetros
	
	public Membresia() {
		
		this.fechaInicio = LocalDate.now();
		this.fechaFinal = LocalDate.now();
		this.tipoPago = "";
		this.monto = 0.0;
	
	}
	public Membresia(LocalDate fechaInicio, LocalDate fechaFinal, String tipoPago, double monto) {
		
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.tipoPago = tipoPago;
		this.monto = monto;
	}
	
	
	// Métodos getters y setters
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	// métodos
	
	

}
