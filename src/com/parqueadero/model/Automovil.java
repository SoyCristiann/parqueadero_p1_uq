package com.parqueadero.model;

import Interfaces.Tarifable;

public class Automovil extends Vehiculo implements Tarifable{
    public Automovil() {
        super();
    }

	@Override
	public double calcularTarifa(int horas) {
		// TODO Auto-generated method stub
		return 0;
	}
}

