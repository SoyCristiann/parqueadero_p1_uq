package com.parqueadero.service;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.parqueadero.model.Cliente;
import com.parqueadero.model.Membresia;
import com.parqueadero.model.Pago;
import com.parqueadero.model.Vehiculo;

import Interfaces.Tarifable;

public class PagoService{
	
	private static ArrayList<Pago> pagos;
	
	
	// Contructor vacío

	public PagoService() {
		this.pagos =  new ArrayList<>();
	}
	
	public ArrayList<Pago> getPagos(){
		return pagos;
	}
	
	//Método para registrar un pago, retorna True o False en función de realizar pruebas.
	public boolean registrarPago(Pago pago, Membresia membresia) {
		StringBuilder mensaje=new StringBuilder();
		if(pagos.isEmpty()) {
			pagos.add(pago);
			System.out.println(pagos);
			mensaje.append(pago + "Fecha inicio Membresia: " + membresia.getFechaInicio() + "\nFecha fin membresía: " + membresia.getFechaFinal());
			JOptionPane.showInternalMessageDialog(null, "El pago fue registrado de forma correcta.\n"+mensaje, "Confirmación de pago.", 1);
			return true;
		}else {
			for(Pago p: pagos) {
				if(p.getIdPago() == pago.getIdPago()) {
					JOptionPane.showInternalMessageDialog(null, "El pago ya está registrado en el sistema, por favor intente de nuevo.", "Pago duplicado.", 0);
					return false;
				}
			}
			pagos.add(pago);System.out.println(pagos);
			mensaje.append(pago + "Fecha inicio Membresia: " + membresia.getFechaInicio() + "\nFecha fin membresía: " + membresia.getFechaFinal());
			JOptionPane.showInternalMessageDialog(null, "El pago fue registrado de forma correcta.\n"+mensaje, "Confirmación de pago.", 1);
			return true;
		}
	}
	
	
	public boolean registrarPago(Pago pago, String placa) {
		StringBuilder mensaje=new StringBuilder();
		if(pagos.isEmpty()) {
			pagos.add(pago);
			System.out.println(pagos);
			mensaje.append(pago.mostrarPagoTemporal(placa) + "Fecha pago: " + LocalDate.now() + "\nPlaca: " + placa + "\nTotal pagado: " + pago.getMonto());
			JOptionPane.showInternalMessageDialog(null, "El pago fue registrado de forma correcta.\n"+mensaje, "Confirmación de pago.", 1);
			return true;
		}else {
			for(Pago p: pagos) {
				if(p.getIdPago() == pago.getIdPago()) {
					JOptionPane.showInternalMessageDialog(null, "El pago ya está registrado en el sistema, por favor intente de nuevo.", "Pago duplicado.", 0);
					return false;
				}
			}
			pagos.add(pago);System.out.println(pagos);
			mensaje.append(pago.mostrarPagoTemporal(placa) + "Fecha pago: " + LocalDate.now() + "\nPlaca: " + placa + "\nTotal pagado: " + pago.getMonto());
			JOptionPane.showInternalMessageDialog(null, "El pago fue registrado de forma correcta.\n"+mensaje, "Confirmación de pago.", 1);
			return true;
		}
	}
	
	//Para verificar el total de pagos, se debe ingresar la fecha de inicio y de fin a calcular.
	public double calcularTotalPagosPeriodo(LocalDate inicio, LocalDate fin) {
		double totalPagosPeriodo=0;
		if(fin.isBefore(inicio) || fin.isAfter(LocalDate.now())) {
			JOptionPane.showInternalMessageDialog(null, "Error en el rango de rechas seleccionado.", "Error de fecha.", 1);
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
	public ArrayList<Pago> obtenerHistorialPagoVehiculo(String placa) {
		StringBuilder mensaje=new StringBuilder();
		mensaje.append("Los pagos registrados para el vehículo con placa " + placa + " son: \n");
		ArrayList<Pago> listaPagos= new ArrayList<>();
		for(Pago p: pagos) {
			Vehiculo v= p.getVehiculo();
			if(v.getPlaca().equalsIgnoreCase(placa.trim())) {
				listaPagos.add(p);
				mensaje.append(p+"\n");
			}
		}
		JOptionPane.showMessageDialog(null, mensaje);
		return listaPagos;
	}
	
	//Cálcula el total de los ingresos teniendo en cuenta los pagos de la lista pagos.
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
		System.out.println("Tamaño de la lista pagos: " + pagos.size());
		for(Pago p: pagos) {
			System.out.println(p);
		}
	}
	

	

}
	

