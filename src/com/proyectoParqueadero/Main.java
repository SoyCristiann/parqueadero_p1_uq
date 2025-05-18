package com.proyectoParqueadero;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.parqueadero.model.Cliente;
import com.parqueadero.model.Membresia;
import com.parqueadero.model.Vehiculo;
import com.parqueadero.service.PagoService;
import com.parqueadero.utils.SelectorFecha;
import com.parqueadero.model.Pago;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Estos datos son solo para hacer validaciones, por favor no borrar hasta el final. Si entorpece algo, por favor dejarlo comentado.
		 * */
		
		//LocalDate fecha=SelectorFecha.seleccionarFecha();
		PagoService adminPago = new PagoService();
		adminPago.calcularTotalIngresos();
		Membresia membresia= new Membresia(LocalDate.of(2025, 06, 01), LocalDate.of(2025, 06, 30), "Efectivo", 20000);
		Cliente cliente =new Cliente("Pedro Perez", "1010", "3100000000", "pedroperez@correo.com");
		Vehiculo vehiculo= new Vehiculo("Carro", "ABC123", "Negro", "2025", cliente, membresia);
		Vehiculo vehiculo2= new Vehiculo("Carro", "DEF123", "Negro", "2025", cliente, membresia);
		Pago pago = new Pago(cliente, vehiculo, 2000, "Efectivo");
		Pago pago2 = new Pago(cliente, vehiculo2, 4000, "Efectivo");		
		adminPago.registrarPago(pago);
		adminPago.registrarPago(pago2);
		System.out.println(adminPago.calcularTotalIngresos());		
		System.out.println(adminPago.calcularTotalPagosPeriodo(pago.getFechaPago(), pago2.getFechaPago()));
		System.out.println(adminPago.obtenerHistorialPagoVehiculo(vehiculo2));
		
	}

}
