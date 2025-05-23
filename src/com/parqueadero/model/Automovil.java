package com.parqueadero.model;

import Interfaces.Tarifable;

public class Automovil extends Vehiculo implements Tarifable{
    public Automovil() {
        super();
    }

	@Override
	public double calcularTarifa(double horas, Vehiculo vehiculo) {
		double tarifa = 10000;
        int horasCobradas = Math.max(1, (int) Math.round(horas));
        return horasCobradas * tarifa;
	}
	
	
	
	
}

