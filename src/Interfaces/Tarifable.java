package Interfaces;

import com.parqueadero.model.TipoVehiculo;
import com.parqueadero.model.Vehiculo;

public interface Tarifable {

	double calcularTarifa(double horas, TipoVehiculo tipoVehiculo, double tarifaHoras); // Tarifa basada en horas y el tipo de vehiculo

}
