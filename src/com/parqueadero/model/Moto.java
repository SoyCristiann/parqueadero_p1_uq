package com.parqueadero.model;

import Interfaces.Tarifable;

public class Moto extends Vehiculo implements Tarifable{
	private double tarifaHora= 1200;
	private double tarifaMembresia= 50000;
	public Moto(TipoVehiculo tipoVehiculo, String placa, String color, String modelo, Cliente cliente) {
		super(tipoVehiculo, placa, color, modelo, cliente);
		
	}
	
	@Override
	public double getTarifaMembresia() {
		return tarifaMembresia;
	}

	@Override
	public double calcularTarifa(double horas, Vehiculo vehiculo) {
        int horasCobradas = Math.max(1, (int) Math.round(horas));
        return horasCobradas * tarifaHora;
	}
	

}

