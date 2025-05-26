package com.parqueadero.model;

import javax.swing.JOptionPane;

import Interfaces.Tarifable;

public class Moto extends Vehiculo implements Tarifable{

	public Moto(TipoVehiculo tipoVehiculo, String placa, String color, String modelo, Cliente cliente) {
		super(tipoVehiculo, placa, color, modelo, cliente);
		
	}

	@Override
	public double calcularTarifa(double horas, TipoVehiculo tipoVehiculo, double tarifaHora) { 
	    int horasCobradas = Math.max(1, (int) Math.round(horas));
	    return horasCobradas * tarifaHora;
	}

}

