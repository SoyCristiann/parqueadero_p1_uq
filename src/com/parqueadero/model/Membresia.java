package com.parqueadero.model;

import java.time.LocalDate;

import javax.swing.JOptionPane;

//Solo membresias mensuales

public class Membresia {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFinal; //Se calcula automaticamente.
	private byte cantidadDiasMembresia=30;//Por defecto solo será mensual, con este parametro se puede modificar la cantidad de días de la membresía.
	private Vehiculo vehiculo;
	private Cliente cliente;
	private double monto;
	
	// Constructor vacío y con parámetros
	
	public Membresia() {
		
		this.fechaInicio = LocalDate.now();
		this.fechaFinal = fechaInicio.plusDays(cantidadDiasMembresia);
		this.monto = 0.0;
	
	}
	
	public Membresia(LocalDate fechaInicio, Vehiculo  vehiculo, Cliente cliente, double monto) {
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaInicio.plusDays(cantidadDiasMembresia); //Esto garantiza que la fecha final automaticamente será 30 días despues de la fecha de creación de la membresía.
		this.vehiculo= vehiculo;
		this.cliente= cliente;
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
	
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	public boolean confirmarMembresia(Membresia membresia) {
		int confirmacion = JOptionPane.showConfirmDialog(null, "Confirme que la siguiente membresía es correcta: \n" + membresia, "Confirmación membresía", 0);
		System.out.println("confirmacion membresia"+confirmacion);
		if(confirmacion==0) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Datos de la membresía: \nFecha de inicio: " + fechaInicio + "\nFecha fin: " + fechaFinal + "\nCliente: " + cliente.getCedula() + "\nVehiculo placa: " + vehiculo.getPlaca() + "\nValor pagado: " + monto;
	}

	

}
