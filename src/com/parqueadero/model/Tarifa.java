package com.parqueadero.model;

public class Tarifa {
	
	private String tipoVehiculo;
	private double valorHora;
	private double valorMes;
	private double valorTrimestre;
	private double valorAnual;
	
	
	
	// Constructor vacío y con parámetros
	
	public Tarifa() {
		
		this.tipoVehiculo = "";
		this.valorHora = 0.0;
		this.valorMes = 0.0;
		this.valorTrimestre = 0.0 ;
		this.valorAnual = 0.0;
		
	}
	
	public Tarifa(String tipoVehiculo, double valorHora, double valorMes, double valorTrimestre, double valorAnual) {
		
		this.tipoVehiculo = tipoVehiculo;
		this.valorHora = valorHora;
		this.valorMes = valorMes;
		this.valorTrimestre = valorTrimestre;
		this.valorAnual = valorAnual;
	}
	
	
	
	// Métodos getters y setters

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValorMes() {
		return valorMes;
	}

	public void setValorMes(double valorMes) {
		this.valorMes = valorMes;
	}

	public double getValorTrimestre() {
		return valorTrimestre;
	}

	public void setValorTrimestre(double valorTrimestre) {
		this.valorTrimestre = valorTrimestre;
	}

	public double getValorAnual() {
		return valorAnual;
	}

	public void setValorAnual(double valorAnual) {
		this.valorAnual = valorAnual;
	}
	
	// Métodos
	
	
}
