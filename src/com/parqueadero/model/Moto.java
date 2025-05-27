package com.parqueadero.model;

import Interfaces.Tarifable;

public class Moto extends Vehiculo{

    private double tarifaMembresia = 60000;

    private static double tarifaHoraMoto = 1500;


    public Moto(TipoVehiculo tipoVehiculo, String placa, String color, String modelo, Cliente cliente) {
        super(tipoVehiculo, placa, color, modelo, cliente);
    }

    public static double getTarifaHoraMoto() {
        return tarifaHoraMoto;
    }

    public static void setTarifaHoraMoto(double tarifaHoraMoto) {
        Moto.tarifaHoraMoto = tarifaHoraMoto;
    }

    @Override
    public double getTarifaMembresia() {
        return tarifaMembresia;
    }

    @Override
    public double calcularTarifa(double horas) {
        int horasCobradas = Math.max(1, (int) Math.round(horas));
        return horasCobradas * tarifaHoraMoto;
    }
}
