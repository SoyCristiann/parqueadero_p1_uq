package com.parqueadero.model;

import Interfaces.Tarifable;

public class Camion extends Vehiculo implements Tarifable{
    public Camion() {
        super();
    }

	@Override
	public double calcularTarifa(double horas, Vehiculo vehiculo) {
		double tarifa = 20000;
        int horasCobradas = Math.max(1, (int) Math.round(horas));
        return horasCobradas * tarifa;
	}
}
