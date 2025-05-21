package com.proyectoParqueadero;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JOptionPane;

import com.parqueadero.model.Cliente;
import com.parqueadero.model.Membresia;
import com.parqueadero.model.Vehiculo;
import com.parqueadero.service.PagoService;
import com.parqueadero.utils.Menu;
import com.parqueadero.utils.SelectorFecha;

import com.parqueadero.model.Pago;
import com.parqueadero.service.ParqueaderoService;

public class Main {
	
	public static void main(String[] args) {
    	// Ejemplo de prueba
        Cliente clienteP = new Cliente("Juan", "1234567890", null, null);
        System.out.println("Cliente creado: " + clienteP.getNombre());
        
        ParqueaderoService servicio = new ParqueaderoService();
        
        
        
        /*
		 * Estos datos son de Cristian solo para hacer validaciones, por favor no borrar hasta el final. Si entorpece algo, por favor dejarlo comentado en bloque.
		 * */
		
        /*
		//LocalDate fecha=SelectorFecha.seleccionarFecha();
		PagoService adminPago = new PagoService();
		adminPago.calcularTotalIngresos();
		Membresia membresia= new Membresia(LocalDate.of(2025, 06, 01), LocalDate.of(2025, 06, 30), "Efectivo", 20000);
		Cliente cliente2 =new Cliente("Pedro Perez", "1010", "3100000000", "pedroperez@correo.com");
		Vehiculo vehiculo= new Vehiculo("Carro", "ABC123", "Negro", "2025", cliente2, membresia);
		Vehiculo vehiculo2= new Vehiculo("Carro", "DEF123", "Negro", "2025", cliente2, membresia);
		Pago pago = new Pago(cliente2, vehiculo, 2000, "Efectivo");
		Pago pago2 = new Pago(cliente2, vehiculo2, 4000, "Efectivo");		
		adminPago.registrarPago(pago);
		adminPago.registrarPago(pago2);
		System.out.println(adminPago.calcularTotalIngresos());		
		System.out.println(adminPago.calcularTotalPagosPeriodo(pago.getFechaPago(), pago2.getFechaPago()));
		System.out.println(adminPago.obtenerHistorialPagoVehiculo(vehiculo2));
		*/
		
		
//      espacio para llamar metodos para probar funcionamiento
        
        

      //Menú. Ojo, no borrar, solo hacer ediciones que no afecten el funcionamiento del menú. Para editar el menú y/o crear submenues, vaya a com.parqueadero.utils -> Menu	
        byte opcion;
        ParqueaderoService adminParqueadero = new ParqueaderoService();
        do {
        	
        	opcion=Menu.seleccionarMenuPrincipal();
        	switch (opcion) {
        	case 2:{
        		
        	}        	 
        	
        	case 3: {
        		opcion= Menu.seleccioanrMenuClientes();
        		switch (opcion) {
					case 1: {
						break;
					}
					case 2: {
						System.out.println("Opcion 1");
						String cedula=JOptionPane.showInputDialog(null, "Ingrese el número de cédula del cliente: ");
						String nombre=JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente: ");
						String telefono=JOptionPane.showInputDialog(null, "Ingrese el número de teléfono del cliente: ");
						String correo=JOptionPane.showInputDialog(null, "Ingrese el correo electrónico del cliente: ");
						Cliente cliente= new Cliente(nombre, cedula, telefono, correo);
						adminParqueadero.registrarCliente(cliente);
						break;
					}
					case 5: {
						Menu.seleccionarMenuPrincipal();
						System.out.println(opcion);
						break;
					}
				}
        		
        		
        		
        		
        		System.out.println(opcion);
			}
			
			case 0: {
				JOptionPane.showMessageDialog(null, "Ha salido del sistema.");
				break;
			}
		}
		} while (opcion!=0);
                
    }


        

}