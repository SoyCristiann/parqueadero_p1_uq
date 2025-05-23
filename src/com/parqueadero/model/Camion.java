package com.parqueadero.model;

import Interfaces.Tarifable;

public class Camion extends Vehiculo implements Tarifable{
    public Camion() {
        super();
    }

	@Override
	public double calcularTarifa(int horas) {
		// TODO Auto-generated method stub
		return 0;
	}
}
