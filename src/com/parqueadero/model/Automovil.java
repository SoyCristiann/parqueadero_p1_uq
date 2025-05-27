package com.parqueadero.model;

import Interfaces.Tarifable;

public class Automovil extends Vehiculo{

    private double tarifaMembresia = 100000;

    private static double tarifaHoraAutomovil=4000;


    public Automovil(TipoVehiculo tipoVehiculo, String placa, String color, String modelo, Cliente cliente) {
        super(tipoVehiculo, placa, color, modelo, cliente);
    }

    public static double getTarifaHoraAutomovil() {
        return tarifaHoraAutomovil;
    }

    public static void setTarifaHoraAutomovil(double tarifaHoraAutomovil) {
        Automovil.tarifaHoraAutomovil = tarifaHoraAutomovil;
    }

    @Override
    public double getTarifaMembresia() {
        return tarifaMembresia;
    }

    @Override
    public double calcularTarifa(double horas) {
        int horasCobradas = Math.max(1, (int) Math.round(horas));
        return horasCobradas * tarifaHoraAutomovil;
    }
}
