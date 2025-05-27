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
	private TipoPago tipoPago;
	
	
	// Constructor vacío y con parámetros
	
	public Pago(Cliente c, String placa, double monto) {
		System.out.println("constructor correcto");
		this.idPago=UUID.randomUUID().toString(); //Genera un ID de pago único de forma aleatoria.
		this.monto = monto;
		this.fechaPago = LocalDate.now();
		this.tipoPago = TipoPago.HORAS;
		this.cliente=c;
	}
	
	public Pago(Cliente cliente, Vehiculo vehiculo, double monto, TipoPago tipoPago) {
		this.idPago=UUID.randomUUID().toString(); //Genera un ID de pago único de forma aleatoria.
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

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}
	
		// Métodos 
	
	public String mostrarPagoTemporal(String placa) {
		return "Id del pago: " + idPago + "\nCliente: Temporal" + "\nVehiculo: " + placa + "\nValor pagado: " + monto + "\nFecha de pago: " + fechaPago + "\nTipo de pago: " + TipoPago.HORAS + "\n";
	}

	
	@Override
	public String toString() {
		return "Id del pago: " + idPago + "\nCliente: " + cliente.getCedula() + "\nVehiculo: " + vehiculo.getPlaca() + "\nValor pagado: " + monto + "\nFecha de pago: " + fechaPago + "\nTipo de pago: " + tipoPago + "\n";
	}
	
	
	 
}
