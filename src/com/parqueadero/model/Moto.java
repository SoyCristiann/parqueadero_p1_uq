package com.parqueadero.model;

import Interfaces.Tarifable;

public class Moto extends Vehiculo implements Tarifable{
    public Moto() {
        super();
    }

	@Override
	public double calcularTarifa(int horas) {
		// TODO Auto-generated method stub
		return 0;
	}
}

