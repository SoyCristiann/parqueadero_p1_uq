package com.parqueadero.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Pago {
	private String idPago;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private double monto; 
	private LocalDate fechaPago;
	private String tipoPago;
	
	
	// Constructor vacío y con parámetros
	
	public Pago() {
		this.idPago=UUID.randomUUID().toString();
		this.cliente= new Cliente();
		this.vehiculo = new Vehiculo();
		this.monto = 0.0;
		this.fechaPago = LocalDate.now();
		this.tipoPago = "";
	}
	
	public Pago(Cliente cliente, Vehiculo vehiculo, double monto, String tipoPago) {
		this.idPago=UUID.randomUUID().toString();
		this.cliente=cliente;
		this.vehiculo = vehiculo;
		this.monto = monto;
		this.fechaPago = LocalDate.now();
		this.tipoPago = tipoPago;
	}
	
	
	// Métodos getters y setters
	public String getIdPago() {
		return idPago;
	}
	
	public void setIdPago() {
		this.idPago= idPago;
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

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fecha) {
		this.fechaPago = fecha;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	
	
	// Métodos 
	
	@Override
	public String toString() {
		return "Id del pago: " + idPago + "\nCliente: " + cliente.getCedula() + "\nVehiculo: " + vehiculo.getPlaca() + "\nValor pagado: " + monto + "\nFecha de pago: " + fechaPago + "\nTipo de pago: " + tipoPago + "\n";
	}
	
	
	 
}
