package com.parqueadero.service;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.parqueadero.model.Pago;
import com.parqueadero.model.Vehiculo;

public class PagoService {
	
	private ArrayList<Pago> pagos;
	
	
	// Contructor vacío

	public PagoService() {
		this.pagos =  new ArrayList<>();
	}
	
	public ArrayList<Pago> getPagos(){
		return pagos;
	}
	
	//Método para registrar un pago, retorna True o False en función de realizar pruebas.
	public boolean registrarPago(Pago pago) {
		if(pagos.isEmpty()) {
			pagos.add(pago);
			JOptionPane.showInternalMessageDialog(null, "El pago fue registrado de forma correcta.", "Confirmación de pago.", 1);
			return true;
		}else {
			for(Pago p: pagos) {
				if(p.getIdPago() == pago.getIdPago()) {
					JOptionPane.showInternalMessageDialog(null, "El pago ya está registrado en el sistema, por favor intente de nuevo.", "Pago duplicado.", 0);
					return false;
				}
			}
			pagos.add(pago);
			JOptionPane.showInternalMessageDialog(null, "El pago fue registrado de forma correcta.", "Confirmación de pago.", 1);
			return true;
		}
	}
	
	//Para verificar el total de pagos, se debe ingresar la fecha de inicio y de fin a calcular.
	public double calcularTotalPagosPeriodo(LocalDate inicio, LocalDate fin) {
		double totalPagosPeriodo=0;
		if(fin.isBefore(inicio)) {
			JOptionPane.showInternalMessageDialog(null, "La fecha de fin no puede ser menor a la fecha inicial.", "Fecha de fin erronea.", 1);
			return 0;
		}else {
			for(Pago p: pagos) {
				if(p.getFechaPago().isEqual(inicio) || p.getFechaPago().isAfter(inicio) && p.getFechaPago().isEqual(fin) || p.getFechaPago().isBefore(fin)) {
					totalPagosPeriodo += p.getMonto();
				}
			}
			return totalPagosPeriodo;
		}		
	}
	
	
	//Método para obtener el historial de pagos de un vehiculo dado.
	public ArrayList<Pago> obtenerHistorialPagoVehiculo(Vehiculo vehiculo) {
		ArrayList<Pago> listaPagos= new ArrayList<>();
		for(Pago p: pagos) {
			Vehiculo v= p.getVehiculo();
			if(v.getPlaca().equals(vehiculo.getPlaca())) {
				listaPagos.add(p);
			}
		}
		return listaPagos;
	}
	
	
	public double calcularTotalIngresos() {
		double total=0;
		if(!pagos.isEmpty()) {
			for(Pago p: pagos) {
				total+=p.getMonto();
			}
			return total;
		}
		JOptionPane.showInternalMessageDialog(null, "No existen pagos registrados en el sistema.","Total Ingresos.",0);
		return total;
	}
	
	//Método de prueba para ver la lista de pagos.
	public void mostrarPagos() {
		for(Pago p: pagos) {
			System.out.println(p);
		}
	}
}
	

