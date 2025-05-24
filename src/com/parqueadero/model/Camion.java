package com.parqueadero.model;

import Interfaces.Tarifable;

public class Camion extends Vehiculo implements Tarifable{
	
	public Camion(TipoVehiculo tipoVehiculo, String placa, String color, String modelo, Cliente cliente) {
		super(tipoVehiculo, placa, color, modelo, cliente);
	}


	@Override
	public double calcularTarifa(double horas, Vehiculo vehiculo) {
		double tarifa = 20000;
        int horasCobradas = Math.max(1, (int) Math.round(horas));
        return horasCobradas * tarifa;
	}
}
