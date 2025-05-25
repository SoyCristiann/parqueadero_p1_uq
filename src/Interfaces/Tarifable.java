package Interfaces;

import com.parqueadero.model.Vehiculo;

public interface Tarifable {
	
	double calcularTarifa(double horas, Vehiculo vehiculo); // Tarifa basada en horas y el tipo de vehiculo
}
