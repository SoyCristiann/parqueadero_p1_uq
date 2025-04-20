package com.parqueadero.service;

import com.parqueadero.model.Parqueadero;
import com.parqueadero.model.Vehiculo;
import com.parqueadero.model.Cliente;

import java.util.ArrayList;
import java.util.List;


public class Reporte {
	private Parqueadero parqueadero;
    private List<String> historialVehiculosPorCliente;
    private double totalIngresos;
    private List<Vehiculo> listaVehiculosActivos;
    private List<Cliente> clientesConMembresiasActivas;
	
    
 // Constructor vacío y con parámetros
    public Reporte() {
    	
    	this.parqueadero = new Parqueadero();
		this.historialVehiculosPorCliente = new ArrayList<>();
		this.totalIngresos = 0.0;
		this.listaVehiculosActivos = new ArrayList<>();
		this.clientesConMembresiasActivas = new ArrayList<>();

	}
    
    public Reporte(Parqueadero parqueadero, List<String> historialVehiculosPorCliente, double totalIngresos, List<Vehiculo> listaVehiculosActivos, List<Cliente> clientesConMembresiasActivas) {

		this.parqueadero = parqueadero;
		this.historialVehiculosPorCliente = historialVehiculosPorCliente;
		this.totalIngresos = totalIngresos;
		this.listaVehiculosActivos = listaVehiculosActivos;
		this.clientesConMembresiasActivas = clientesConMembresiasActivas;
	}
    
    
 // Métodos getters y setters

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public List<String> getHistorialVehiculosPorCliente() {
		return historialVehiculosPorCliente;
	}

	public void setHistorialVehiculosPorCliente(List<String> historialVehiculosPorCliente) {
		this.historialVehiculosPorCliente = historialVehiculosPorCliente;
	}

	public double getTotalIngresos() {
		return totalIngresos;
	}

	public void setTotalIngresos(double totalIngresos) {
		this.totalIngresos = totalIngresos;
	}

	public List<Vehiculo> getListaVehiculosActivos() {
		return listaVehiculosActivos;
	}

	public void setListaVehiculosActivos(List<Vehiculo> listaVehiculosActivos) {
		this.listaVehiculosActivos = listaVehiculosActivos;
	}

	public List<Cliente> getClientesConMembresiasActivas() {
		return clientesConMembresiasActivas;
	}

	public void setClientesConMembresiasActivas(List<Cliente> clientesConMembresiasActivas) {
		this.clientesConMembresiasActivas = clientesConMembresiasActivas;
	}
    
    
    // Métodos
    
}

