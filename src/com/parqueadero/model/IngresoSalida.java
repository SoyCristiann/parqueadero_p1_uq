package com.parqueadero.model;

import java.time.LocalDateTime;

public class IngresoSalida {
	private String placa;
	private TipoVehiculo tipoVehiculo;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSalida;
	private double valorCalculado;
	
	
	// Constructor vacío y con parámetros
	
	public IngresoSalida() {
		
		this.placa = "";
		this.tipoVehiculo = TipoVehiculo.INDEFINIDO;
		this.horaEntrada = LocalDateTime.now();
		this.horaSalida = LocalDateTime.now();
		this.valorCalculado = 0.0;
	}
	
	public IngresoSalida(String placa, TipoVehiculo tipoVehiculo, LocalDateTime horaEntrada, LocalDateTime horaSalida, double valorCalculado) {
		
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

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo2) {
		this.tipoVehiculo = tipoVehiculo2;
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
	
	
	
	
}
