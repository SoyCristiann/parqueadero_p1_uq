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
	private String tipoPago;
	private double monto;
	
	
	public Membresia() {
		
		this.fechaInicio = LocalDate.now();
		this.fechaFinal = fechaInicio.plusDays(cantidadDiasMembresia);
		this.tipoPago = "";
		this.monto = 0.0;
	}
	
	public Membresia(LocalDate fechaInicio, Vehiculo  vehiculo, Cliente cliente, String tipoPago, double monto) {
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaInicio.plusDays(cantidadDiasMembresia); //Esto garantiza que la fecha final automaticamente será 30 días despues de la fecha de creación de la membresía.
		this.vehiculo= vehiculo;
		this.cliente= cliente;
		this.tipoPago = tipoPago;
		this.monto = monto;
	}
	
	
	// Métodos getters y setters
	public byte getCantidadDiasMembresia() {
		return cantidadDiasMembresia;
	}
	
	public void setCantidadDiasMembresia(byte cantidadDiasMembresia) {
		this.cantidadDiasMembresia= cantidadDiasMembresia;
	}
	
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
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
	
	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;}
	
	public boolean estaActiva() {
        return LocalDate.now().isBefore(fechaFinal);
    }
	
	public boolean confirmarMembresia(Membresia membresia) {
        int confirmacion = JOptionPane.showConfirmDialog(null, "Confirme la membresía:    " + membresia, "Confirmación", 0);
        return confirmacion == 0;
    }
	
	public double calcularTarifa() {
		return monto; 
	    }

	    @Override
	    public String toString() {
	        return "Membresía válida desde " + fechaInicio + " hasta " + fechaFinal +
	               ", Cliente: " + cliente.getCedula() +
	               ", Vehículo: " + vehiculo.getPlaca() +
	               ", Monto pagado: $" + monto;
	    }
	}