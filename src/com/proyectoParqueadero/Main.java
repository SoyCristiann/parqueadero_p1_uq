package com.proyectoParqueadero;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JOptionPane;

import com.parqueadero.model.Automovil;
import com.parqueadero.model.Camion;
import com.parqueadero.model.Cliente;
import com.parqueadero.model.Membresia;
import com.parqueadero.model.Moto;
import com.parqueadero.model.Vehiculo;
import com.parqueadero.service.PagoService;
import com.parqueadero.utils.Menu;
import com.parqueadero.utils.SelectorFecha;


import com.parqueadero.model.Pago;
import com.parqueadero.model.TipoPago;
import com.parqueadero.model.TipoVehiculo;
import com.parqueadero.service.ParqueaderoService;

public class Main {
	
	public static void main(String[] args) {
    	// Ejemplo de prueba
        Cliente clienteP = new Cliente("Juan", "1234567890", null, null);
        System.out.println("Cliente creado: " + clienteP.getNombre());
        
        ParqueaderoService adminParqueadero = new ParqueaderoService();
        PagoService adminPago = new PagoService();
        
        
        
        /*
		 * Estos datos son de Cristian solo para hacer validaciones, por favor no borrar hasta el final. Si entorpece algo, por favor dejarlo comentado en bloque.
		 * */
		
        
		//LocalDate fecha=SelectorFecha.seleccionarFecha();
		//PagoService adminPago = new PagoService();
		//adminPago.calcularTotalIngresos();
		
		/*Cliente cliente1 =new Cliente("Pedro Perez", "1010", "3100000001", "pedroperez@correo.com");
		adminParqueadero.registrarCliente(cliente1);
		Cliente cliente2 =new Cliente("Pedro Perez", "1011", "3100000002", "pedroperez@correo.com");
		adminParqueadero.registrarCliente(cliente2);*/
		Cliente cliente3 =new Cliente("Pedro Perez", "1012", "3100000003", "pedroperez@correo.com");
		adminParqueadero.registrarCliente(cliente3);
		/*Vehiculo vehiculo1= new Vehiculo(TipoVehiculo.AUTOMOVIL, "ABC123", "Negro", "2025", cliente1);
		cliente1.registrarVehiculo(vehiculo1);		
		Vehiculo vehiculo2= new Vehiculo(TipoVehiculo.CAMION, "DEF456", "Negro", "2025", cliente2);
		cliente2.registrarVehiculo(vehiculo2);
		Vehiculo vehiculo3= new Vehiculo(TipoVehiculo.MOTO, "DEF789", "Negro", "2025", cliente3);
		cliente3.registrarVehiculo(vehiculo3);
		Vehiculo vehiculo4= new Vehiculo(TipoVehiculo.MOTO, "DEF22C", "Negro", "2025", cliente3);
		cliente3.registrarVehiculo(vehiculo4);*/
		Automovil vehiculo5= new Automovil(TipoVehiculo.AUTOMOVIL, "DEF15A", "Negro", "2025", cliente3);
		cliente3.registrarVehiculo(vehiculo5);
		//Membresia membresia= new Membresia(LocalDate.of(2025, 06, 01), vehiculo2, cliente2, 2000);
		
		//adminParqueadero.crearMembresia(vehiculo5);
	
		
		
		/*Pago pago = new Pago(cliente2, vehiculo1, 2000, "Efectivo");
		Pago pago2 = new Pago(cliente2, vehiculo2, 4000, "Efectivo");		
		adminPago.registrarPago(pago);
		adminPago.registrarPago(pago2);
		System.out.println(adminPago.calcularTotalIngresos());		
		System.out.println(adminPago.calcularTotalPagosPeriodo(pago.getFechaPago(), pago2.getFechaPago()));
		System.out.println(adminPago.obtenerHistorialPagoVehiculo(vehiculo2));*/
		
		
		
//      espacio para llamar metodos para probar funcionamiento
        
        

      //Menú. Ojo, no borrar, solo hacer ediciones que no afecten el funcionamiento del menú. Para editar el menú y/o crear submenues, vaya a com.parqueadero.utils -> Menu	
        byte opcion;
        //ParqueaderoService adminParqueadero = new ParqueaderoService();
        do {
        	
        	opcion=Menu.seleccionarMenuPrincipal();
        	System.out.println("Opcion seleccionada " + opcion);
        	switch (opcion) {
        	case 1:{}
        	
        	case 2:{}        	 
        	
        	case 3: { // Módulo clientes
        		opcion= Menu.seleccioanrMenuClientes();
        		System.out.println("Opcion seleccionada " + opcion);
        		switch (opcion) {
					case 1: {//Buscar un cliente por cédula.
						String cedula=JOptionPane.showInputDialog(null, "Ingrese la cédula del cliente: ");
						System.out.println(cedula);
						adminParqueadero.buscarClienteForUsuario(cedula);
						break;
					}
					case 2: {//Registrar un nuevo cliente.
						String cedula=JOptionPane.showInputDialog(null, "Ingrese el número de cédula del cliente: ");
						String nombre=JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente: ");
						String telefono=JOptionPane.showInputDialog(null, "Ingrese el número de teléfono del cliente: ");
						String correo=JOptionPane.showInputDialog(null, "Ingrese el correo electrónico del cliente: ");
						Cliente cliente= new Cliente(nombre, cedula, telefono, correo);
						adminParqueadero.registrarCliente(cliente);
						break;
					}
					case 3:{//Editar cliente
						String cedula=JOptionPane.showInputDialog(null, "Ingrese el número de cédula del cliente: ");
						String nombre=JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente: ");
						String telefono=JOptionPane.showInputDialog(null, "Ingrese el número de teléfono del cliente: ");
						String correo=JOptionPane.showInputDialog(null, "Ingrese el correo electrónico del cliente: ");
						Cliente clienteActualizado= new Cliente(nombre, cedula, telefono, correo);
						adminParqueadero.actualizarCliente(clienteActualizado);
						break;
					}
					case 4:{//Eliminar cliente
						String cedula=JOptionPane.showInputDialog(null, "Ingrese el número de cédula del cliente que desea borrar del sistema: ");
						adminParqueadero.eliminarCliente(cedula);
						break;
					}
					
					case 5: {
						Menu.seleccionarMenuPrincipal();
						System.out.println(opcion);
						break;
					}
				}
        		break;
			}
        	
        	case 4:{// Módulo vehículos
        		opcion= Menu.seleccioanrMenuVehiculos();
        		switch (opcion) {
					case 1: { //Ver vehículos registrados
						opcion=Byte.parseByte(JOptionPane.showInputDialog("Seleccione cómo desea buscar: \n"
								+ "1. Ver todos los vehículos.\n"
								+ "2. Ver por placa\n"
								+ "3. Ver por cédula del cliente\n"
								+ "4. Ver por tipo de vehículo"));
						switch (opcion) {
							case 1: {
								adminParqueadero.listarVehiculos();
								break;
							}
							case 2:{//Ver por placa
								String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo: ");
								adminParqueadero.listarVehiculosPorPlaca(placa);
								break;
							}
							case 3:{//Ver por cédula del cliente
								String cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula del cliente: ");
								adminParqueadero.listarVehiculos(cedula);
								break;
							}
							case 4:{//Ver por Tipo de vehículo
								TipoVehiculo tipoVehiculo = (TipoVehiculo) JOptionPane.showInputDialog(null, "Seleccione el tipo de vehículo:", "Tipo de vehículo.",JOptionPane.QUESTION_MESSAGE,null, TipoVehiculo.values(), TipoVehiculo.AUTOMOVIL);
								System.out.println(tipoVehiculo);
								adminParqueadero.listarVehiculos(tipoVehiculo);
								break;
							}						
						}
						break;
					}
					case 2:{//Registrar nuevo vehículo
						String cedula=JOptionPane.showInputDialog(null, "Ingrese el número de cédula del cliente: ");
						if(adminParqueadero.buscarClienteForUsuario(cedula)) {
							Cliente cliente = adminParqueadero.buscarCliente(cedula);
							TipoVehiculo tipoVehiculo = (TipoVehiculo) JOptionPane.showInputDialog(null, "Seleccione el tipo de vehículo:", "Tipo de vehículo.",JOptionPane.QUESTION_MESSAGE,null, TipoVehiculo.values(), TipoVehiculo.AUTOMOVIL);
							if(tipoVehiculo!=TipoVehiculo.INDEFINIDO) {
								String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo: ");
								String color = JOptionPane.showInputDialog(null, "Ingrese el color del vehículo: ");
								String modelo= JOptionPane.showInputDialog(null, "Ingrese el modelo del vehículo: ");
								if(tipoVehiculo== TipoVehiculo.AUTOMOVIL) {
									Automovil vehiculo= new Automovil(tipoVehiculo, placa, color, modelo, cliente);
									cliente.registrarVehiculo(vehiculo);
								}if(tipoVehiculo== TipoVehiculo.CAMION) {
									Camion vehiculo= new Camion(tipoVehiculo, placa, color, modelo, cliente);
									cliente.registrarVehiculo(vehiculo);
								}if(tipoVehiculo== TipoVehiculo.MOTO) {
									Moto vehiculo= new Moto(tipoVehiculo, placa, color, modelo, cliente);
									cliente.registrarVehiculo(vehiculo);
								}
								break;
							}else {
								JOptionPane.showMessageDialog(null, "El tipo de vehículo no es válido.");
								break;
							}
						}
						
						
					}
					case 3:{//Editar vehículo
						
					}
					case 4:{//Eliminar vehículo
						
					}
				}
        		break;
    		}
        	case 5:{// Módulo de membresías
        		opcion = Menu.seleccioanrMenuMembresias();
        		switch (opcion) {
				case 1: {//Ver membresías activas
					adminParqueadero.listarMembresias();
					
				}
				case 2: {//Crear nueva membresía
					String cedula= JOptionPane.showInputDialog("Ingrese la cédula del cliente: ");
					Cliente c=adminParqueadero.buscarCliente(cedula);
					String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
					Vehiculo v=c.buscarVehiculoPlaca(placa);
					LocalDate fechaInicio = SelectorFecha.seleccionarFecha();
					TipoPago tipoPago = (TipoPago) JOptionPane.showInputDialog(null, "Seleccione el tipo de pago:", "Tipo de pago.",JOptionPane.QUESTION_MESSAGE,null, TipoPago.values(), TipoPago.HORAS);
					Membresia membresia = adminParqueadero.crearMembresia(cedula, placa, fechaInicio);
					if(membresia!=null) {						
						Pago pago= new Pago(c,v, membresia.getMonto(), tipoPago);
						adminPago.registrarPago(pago);
						JOptionPane.showMessageDialog(null, pago);
					}			
					break;	
				}
				case 3:{// Editar membresía
					
				}
				case 4:{// Eliminar membresía
					
				}
				case 5:{//Regresar al menú principal
					
				}
				}
        		
        	}
        	case 6:{}
        	case 7:{}
			
			case 0: {
				JOptionPane.showMessageDialog(null, "Ha salido del sistema.");
				break;
			}
		}
		} while (opcion!=0);
                
    }


        

}