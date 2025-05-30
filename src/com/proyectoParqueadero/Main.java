package com.proyectoParqueadero;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JOptionPane;

import com.parqueadero.model.Automovil;
import com.parqueadero.model.Camion;
import com.parqueadero.model.Cliente;
import com.parqueadero.model.IngresoSalida;
import com.parqueadero.model.Membresia;
import com.parqueadero.model.Moto;
import com.parqueadero.model.Vehiculo;
import com.parqueadero.service.PagoService;
import com.parqueadero.utils.Menu;
import com.parqueadero.utils.SelectorFecha;

import Interfaces.Tarifable;

import com.parqueadero.model.Pago;
import com.parqueadero.model.TipoPago;
import com.parqueadero.model.TipoVehiculo;
import com.parqueadero.service.ParqueaderoService;

public class Main {
	
	public static void main(String[] args) {        
		PagoService adminPago = new PagoService();
		ParqueaderoService adminParqueadero = new ParqueaderoService("Parqueadero de la U", "Universidad del Quindío", "Estudiantes de ingenería", "3100000000", 200, 150, 20, adminPago);
        

      //Menú. Ojo, no borrar, solo hacer ediciones que no afecten el funcionamiento del menú. Para editar el menú y/o crear submenues, vaya a com.parqueadero.utils -> Menu	
        byte opcion;
        do {
        	
        	opcion=Menu.seleccionarMenuPrincipal();
        	System.out.println("Opcion seleccionada " + opcion);
        	switch (opcion) {
        	case 1:{//Registrar ingreso sin membresía
        		String placaN = JOptionPane.showInputDialog("Ingrese la placa del vehiculo: ");
        		if ( placaN == null||placaN.isBlank() ) {
        			JOptionPane.showMessageDialog(null, "Opción inválida");
        			continue;
        		}
        		TipoVehiculo tipoVehiculoN = (TipoVehiculo) JOptionPane.showInputDialog(null, "Seleccione el tipo de vehículo:",
        				"Tipo de vehículo.",JOptionPane.QUESTION_MESSAGE,null, TipoVehiculo.values(), TipoVehiculo.AUTOMOVIL);
        		if (tipoVehiculoN == null) {
        			JOptionPane.showMessageDialog(null, "Opción inválida");
        			continue;
        		}
        		
        		adminParqueadero.registrarIngreso(placaN, tipoVehiculoN);
        		break;
        	}
        	
        	case 2: {//Registrar salida sin membresía
        	    String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo:");
        	    if (placa == null || placa.isBlank()) {
        	        JOptionPane.showMessageDialog(null, "Placa inválida.");
        	        break;  // Cambié return por break para no salir del loop principal
        	    }
        	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        	    LocalDateTime horaSalidaN = null;
        	    boolean entradaValida = false;

        	    while (!entradaValida) {
        	        String horaSalidaStr = JOptionPane.showInputDialog(
        	            null,
        	            "Ingrese la fecha y hora de salida\nFormato: yyyy-MM-dd HH:mm",
        	            "Registro de salida",
        	            JOptionPane.QUESTION_MESSAGE
        	        );

        	        if (horaSalidaStr == null) {
        	            JOptionPane.showMessageDialog(null, "Cancelado por el usuario.");
        	            break;  
        	        }

        	        try {
        	            horaSalidaN = LocalDateTime.parse(horaSalidaStr.trim(), formatter);
        	            entradaValida = true;
        	        } catch (Exception e) {
        	            JOptionPane.showMessageDialog(null, "Formato inválido. Intente de nuevo.");
        	        }
        	        
        	    }

        	    if (entradaValida) {
        	        TipoVehiculo tipo = adminParqueadero.registrarSalida(placa.trim(), horaSalidaN);
        	        if (tipo != null) {
        	            JOptionPane.showMessageDialog(null, "Vehículo tipo " + tipo + " registrado como salida.");
        	        }
        	    }
        	    break;
        	}
        	
        	
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
						String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo: ");
						TipoVehiculo tipoVehiculo = (TipoVehiculo) JOptionPane.showInputDialog(null, "Seleccione el tipo de vehículo:", "Tipo de vehículo.",JOptionPane.QUESTION_MESSAGE,null, TipoVehiculo.values(), TipoVehiculo.AUTOMOVIL);
						String color = JOptionPane.showInputDialog(null, "Ingrese el color del vehículo: ");
						String modelo= JOptionPane.showInputDialog(null, "Ingrese el modelo del vehículo: ");
						adminParqueadero.editarVehiculo(placa, tipoVehiculo, color, modelo);
						break;
					}
					case 4:{//Eliminar vehículo
						String cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula del cliente: ");
						Cliente c = adminParqueadero.buscarCliente(cedula);
						String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo: ");
						Vehiculo v = c.buscarVehiculoPlaca(placa);
						adminParqueadero.eliminar(v);
						break;
					}
				}
        		break;
    		}
        	case 5:{// Módulo de membresías
        		opcion = Menu.seleccioanrMenuMembresias();
        		switch (opcion) {
				case 1: {//Ver membresías activas
					adminParqueadero.listarMembresias();
					break;
				}
				case 2: {//Crear nueva membresía
					String cedula= JOptionPane.showInputDialog("Ingrese la cédula del cliente: ");
					Cliente c=adminParqueadero.buscarCliente(cedula);
					if(c!=null) {
						String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
						Vehiculo v=c.buscarVehiculoPlaca(placa);
						if(v!=null) {
							LocalDate fechaInicio = SelectorFecha.seleccionarFecha();
							int cantidadDias=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de días deseados en la membresía: ")) ;
							//TipoPago tipoPago = (TipoPago) JOptionPane.showInputDialog(null, "Seleccione el tipo de pago:", "Tipo de pago.",JOptionPane.QUESTION_MESSAGE,null, TipoPago.values(), TipoPago.HORAS);
							Membresia membresia = adminParqueadero.crearMembresia(cedula, placa, fechaInicio, cantidadDias);
						}else {
							break;
						}						
					}else {
						break;
					}		
					break;	
				}
				case 3:{// Editar membresía
					String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
					Membresia m= adminParqueadero.getMembresia(placa);
					String cedula= JOptionPane.showInputDialog("Ingrese la cédula del cliente: ");
					LocalDate fechaInicio = SelectorFecha.seleccionarFecha();
					adminParqueadero.editarMembresia(cedula, placa, fechaInicio);
					break;					
				}
				case 4:{// Eliminar membresía
					Membresia m= adminParqueadero.getMembresia(JOptionPane.showInputDialog("Ingrese la placa del vehículo: "));				
					adminParqueadero.eliminar(m);
					break;
				}
				case 5:{//Regresar al menú principal
					Menu.seleccionarMenuPrincipal();
					break;
				}
				}
        		break;
        		
        	}
        	
        	case 6:{ //Espacios en el parqueadero
        		opcion=Menu.seleccioanrMenuCupos();
        		switch (opcion) {
					case 1: {
						JOptionPane.showMessageDialog(null, adminParqueadero.getEspaciosCarros());
						break;
					}
					case 2: {
						JOptionPane.showMessageDialog(null, adminParqueadero.getEspaciosMotos());
						break;
					}
					case 3: {
						JOptionPane.showMessageDialog(null, adminParqueadero.getEspaciosCamion());
						break;
					}
        		}
        		break;
        	}
        	case 7:{
        		opcion=Menu.seleccionarReportes();
        		switch (opcion) {
					case 1: {//Historial total de pagos.
						JOptionPane.showMessageDialog(null, "El total de pagos registrados es : $" + adminPago.calcularTotalIngresos());
						break;
					}
					case 2:{//Historial pagos por periodo.
						JOptionPane.showMessageDialog(null, "Seleccione la fecha inicial a consultar:");
						LocalDate fechaInicio= SelectorFecha.seleccionarFecha();
						JOptionPane.showMessageDialog(null, "Seleccione la fecha final:");
						LocalDate fechaFin= SelectorFecha.seleccionarFecha();
						double monto= adminPago.calcularTotalPagosPeriodo(fechaInicio, fechaFin);
						if(monto!=0) {
							JOptionPane.showMessageDialog(null, "El total de los ingresos para el periodo " + fechaInicio + " - " + fechaFin + " es:" + monto);
							break;
						}
						break;
						
					}
					case 3:{//Historial de pago por vehículo
						String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
						adminPago.obtenerHistorialPagoVehiculo(placa);
						break;
					}
				}
        		break;
        	}
        	case 8:{//Vehículos en el parqueadero.
        		adminParqueadero.mostrarVehiculosActuales();
        		break;
        		
        	}
        	
        	case 9: { // Calcular la tarifa vehículos Temporales
        	    String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        	    if (placa == null || placa.isBlank()) {
        	        JOptionPane.showMessageDialog(null, "Placa inválida.");
        	        break;
        	    }

        	    double horas = adminParqueadero.calcularHoras(placa.trim());
        	    if (horas <= 0) {
        	        JOptionPane.showMessageDialog(null, "El vehículo aún no ha salido del parqueadero.");
        	        break;
        	    }

        	    TipoVehiculo tipo = null;
        	    for (IngresoSalida registro : adminParqueadero.getVehiculosTemporales()) {
        	        if (registro.getPlaca().equalsIgnoreCase(placa.trim())) {
        	            tipo = registro.getTipoVehiculo();
        	            break;
        	        }
        	    }

        	    if (tipo == null) {
        	        JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        	        break;
        	    }

        	    Vehiculo vehiculo = null;
        	    switch (tipo) {
        	        case MOTO:
        	            Moto moto = new Moto(tipo, placa, "", "", null);
        	            // Aquí suponemos que la tarifa ya está establecida en el objeto moto
        	            vehiculo = moto;
        	            break;
        	        case AUTOMOVIL:
        	            Automovil auto = new Automovil(tipo, placa, "", "", null);
        	            vehiculo = auto;
        	            break;
        	        case CAMION:
        	            Camion camion = new Camion(tipo, placa, "", "", null);
        	            vehiculo = camion;
        	            break;
        	        default:
        	            JOptionPane.showMessageDialog(null, "Tipo de vehículo no válido.");
        	            break;
        	    }

        	    double total = vehiculo.calcularTarifa(horas);

       	    JOptionPane.showMessageDialog(null,
        	        "Placa: " + placa + "\n" +
        	        "Tipo de vehículo: " + tipo + "\n" +
        	        "Horas cobradas: " + String.format("%.2f", horas) + "\n" +
        	        "Total a pagar: $" + total
        	    );
        	    Cliente cliente=new Cliente();
        	    Pago pago = new Pago(cliente,vehiculo, total, TipoPago.HORAS);
        	    adminPago.registrarPago(pago, placa);
        	        
        	    
        	    break;
        	}

        	case 10: { // Editar tarifas por hora
        	    String[] opciones = {"Moto", "Automóvil", "Camión"};
        	    int seleccion = JOptionPane.showOptionDialog(
        	        null,
        	        "Seleccione el tipo de vehículo para editar la tarifa por hora:",
        	        "Editar Tarifa",
        	        JOptionPane.DEFAULT_OPTION,
        	        JOptionPane.INFORMATION_MESSAGE,
        	        null,
        	        opciones,
        	        opciones[0]
        	    );

        	    if (seleccion == JOptionPane.CLOSED_OPTION) break;

        	    String input = JOptionPane.showInputDialog("Ingrese la nueva tarifa por hora:");
        	    if (input == null || input.isBlank()) break;

        	    try {
        	        double nuevaTarifa = Double.parseDouble(input);
        	        if (nuevaTarifa <= 0) {
        	            JOptionPane.showMessageDialog(null, "La tarifa debe ser un valor positivo.");
        	            break;
        	        }

        	        switch (seleccion) {
        	            case 0:
        	                Moto.setTarifaHoraMoto(nuevaTarifa);
        	                JOptionPane.showMessageDialog(null, "Tarifa por hora para Moto actualizada a $" + nuevaTarifa);
        	                break;
        	            case 1:
        	                Automovil.setTarifaHoraAutomovil(nuevaTarifa);
        	                JOptionPane.showMessageDialog(null, "Tarifa por hora para Automóvil actualizada a $" + nuevaTarifa);
        	                break;
        	            case 2:
        	                Camion.setTarifaHoraCamion(nuevaTarifa);
        	                JOptionPane.showMessageDialog(null, "Tarifa por hora para Camión actualizada a $" + nuevaTarifa);
        	                break;
        	        }

        	    } catch (NumberFormatException e) {
        	        JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
        	    }

        	    break;
        	}

        	
        	
			case 0: {
				JOptionPane.showMessageDialog(null, "Ha salido del sistema.");
				break;
			}
		}
		} while (opcion!=0);
        
        
                
    }


        

}