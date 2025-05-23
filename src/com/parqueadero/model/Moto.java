package com.parqueadero.model;

import Interfaces.Tarifable;

public class Moto extends Vehiculo implements Tarifable{
    public Moto() {
        super();
    }

	@Override
	public double calcularTarifa(double horas, Vehiculo vehiculo) {
		double tarifa = 5000;
        int horasCobradas = Math.max(1, (int) Math.round(horas));
        return horasCobradas * tarifa;
	}
}

