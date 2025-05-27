package com.parqueadero.model;

import Interfaces.Tarifable;

public class Camion extends Vehiculo{

    private double tarifaMembresia = 5000;//Cómo se habilitó decidir la cantidad de días de la membresía, se debe definir el valor por día

    private static double tarifaHoraCamion=8000;


    public Camion(TipoVehiculo tipoVehiculo, String placa, String color, String modelo, Cliente cliente) {
        super(tipoVehiculo, placa, color, modelo, cliente);
    }

    // Getter 
    public static double getTarifaHoraCamion() {
        return tarifaHoraCamion;
    }
    
	 @Override
	    public double getTarifaMembresia() {
	        return tarifaMembresia;
	    }
	 
    // Setter 
    public static void setTarifaHoraCamion(double tarifaHoraCamion) {
        Camion.tarifaHoraCamion = tarifaHoraCamion;
    }

   

    @Override
    public double calcularTarifa(double horas) {
    	int horasCobradas = (int) Math.ceil(horas); //Redondea al entero superior.
    	//int horasCobradas = Math.max(1, (int) Math.round(horas));
        return horasCobradas * tarifaHoraCamion;
    }
}
