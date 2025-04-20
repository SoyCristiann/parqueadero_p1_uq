package com.parqueadero.model;

import java.time.LocalDateTime;

public class IngresoSalida {
	private String placa;
	private String tipoVehiculo;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSalida;
	private double valorCalculado;
	
	
	// Constructor vacío y con parámetros
	
	public IngresoSalida() {
		
		this.placa = "";
		this.tipoVehiculo = "";
		this.horaEntrada = LocalDateTime.now();
		this.horaSalida = LocalDateTime.now();
		this.valorCalculado = 0.0;
	}
	
	public IngresoSalida(String placa, String tipoVehiculo, LocalDateTime horaEntrada, LocalDateTime horaSalida, double valorCalculado) {
		
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.valorCalculado = valorCalculado;
	}

	
	// Métodos getters y setters
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}
	
	
	// Métodos
	
	
	
}
