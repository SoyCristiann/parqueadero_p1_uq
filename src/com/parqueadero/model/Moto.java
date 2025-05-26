package com.parqueadero.model;

import javax.swing.JOptionPane;

import Interfaces.Tarifable;

public class Moto extends Vehiculo implements Tarifable{
	private double tarifaHora= 1200;
	private static double tarifaMembresia= 60000;
	
  public Moto(TipoVehiculo tipoVehiculo, String placa, String color, String modelo, Cliente cliente) {
		super(tipoVehiculo, placa, color, modelo, cliente);}
	
	public static double getTarifaMembresia() {return tarifaMembresia;}

	@Override
	public double calcularTarifa(double horas, TipoVehiculo tipoVehiculo, double tarifaHora) { 
	    int horasCobradas = Math.max(1, (int) Math.round(horas));
	    return horasCobradas * tarifaHora;
  }


}