package com.proyectoParqueadero;

import java.time.LocalDate;
import javax.swing.JOptionPane;

import com.parqueadero.model.*;
import com.parqueadero.service.PagoService;
import com.parqueadero.service.ParqueaderoService;
import com.parqueadero.utils.Menu;

public class Main {

    public static void main(String[] args) {
        Cliente clienteP = new Cliente("Juan", "1234567890", null, null);
        System.out.println("Cliente creado: " + clienteP.getNombre());

        ParqueaderoService adminParqueadero = new ParqueaderoService();
        PagoService adminPago = new PagoService();

        Cliente cliente3 = new Cliente("Pedro Perez", "1012", "3100000003", "pedroperez@correo.com");
        adminParqueadero.registrarCliente(cliente3);
        Automovil vehiculo5 = new Automovil(TipoVehiculo.AUTOMOVIL, "DEF15A", "Negro", "2025", cliente3);
        cliente3.registrarVehiculo(vehiculo5);
        
        Cliente cliente1 =new Cliente("Pedro Perez", "1010", "3100000001", "pedroperez@correo.com");
		adminParqueadero.registrarCliente(cliente1);
		Cliente cliente2 =new Cliente("Pedro Perez", "1011", "3100000002", "pedroperez@correo.com");
		adminParqueadero.registrarCliente(cliente2);
		Cliente cliente3 =new Cliente("Pedro Perez", "1012", "3100000003", "pedroperez@correo.com");
		adminParqueadero.registrarCliente(cliente3);
		Vehiculo vehiculo1= new Vehiculo(TipoVehiculo.AUTOMOVIL, "ABC123", "Negro", "2025", cliente1);
		cliente1.registrarVehiculo(vehiculo1);		
		Vehiculo vehiculo2= new Vehiculo(TipoVehiculo.CAMION, "DEF456", "Negro", "2025", cliente2);
		cliente2.registrarVehiculo(vehiculo2);
		Vehiculo vehiculo3= new Vehiculo(TipoVehiculo.MOTO, "DEF789", "Negro", "2025", cliente3);
		cliente3.registrarVehiculo(vehiculo3);
		Vehiculo vehiculo4= new Vehiculo(TipoVehiculo.MOTO, "DEF22C", "Negro", "2025", cliente3);
		cliente3.registrarVehiculo(vehiculo4);
		Automovil vehiculo5= new Automovil(TipoVehiculo.AUTOMOVIL, "DEF15A", "Negro", "2025", cliente3);
		cliente3.registrarVehiculo(vehiculo5);
		Membresia membresia= new Membresia(LocalDate.of(2025, 06, 01), vehiculo2, cliente2, 2000);
		
		adminParqueadero.crearMembresia(vehiculo5);
	
		
		
		Pago pago = new Pago(cliente2, vehiculo1, 2000, "Efectivo");
		Pago pago2 = new Pago(cliente2, vehiculo2, 4000, "Efectivo");		
		adminPago.registrarPago(pago);
		adminPago.registrarPago(pago2);
		System.out.println(adminPago.calcularTotalIngresos());		
		System.out.println(adminPago.calcularTotalPagosPeriodo(pago.getFechaPago(), pago2.getFechaPago()));
		System.out.println(adminPago.obtenerHistorialPagoVehiculo(vehiculo2));

        byte opcion = -1;

        do {
            try {
                opcion = Menu.seleccionarMenuPrincipal();
                if (opcion == -1) continue;

                System.out.println("Opción seleccionada: " + opcion);

                switch (opcion) {
                    case 1:
                        // TODO: Implementar opción 1
                        break;

                    case 2:
                        // TODO: Implementar opción 2
                        break;

                    case 3: { // Clientes
                        byte subopcion = Menu.seleccioanrMenuClientes();
                        if (subopcion == -1) break;

                        switch (subopcion) {
                            case 1: { // Buscar cliente
                                String cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula del cliente:");
                                if (cedula == null || cedula.trim().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                                } else {
                                    adminParqueadero.buscarClienteForUsuario(cedula.trim());
                                }
                                break;
                            }
                            case 2: { // Registrar cliente
                                String cedula = JOptionPane.showInputDialog("Número de cédula:");
                                if (cedula == null) break;
                                String nombre = JOptionPane.showInputDialog("Nombre:");
                                if (nombre == null) break;
                                String telefono = JOptionPane.showInputDialog("Teléfono:");
                                if (telefono == null) break;
                                String correo = JOptionPane.showInputDialog("Correo:");
                                if (correo == null) break;

                                Cliente cliente = new Cliente(nombre, cedula, telefono, correo);
                                adminParqueadero.registrarCliente(cliente);
                                break;
                            }
                            case 3: { // Editar cliente
                                String cedula = JOptionPane.showInputDialog("Número de cédula:");
                                if (cedula == null) break;
                                String nombre = JOptionPane.showInputDialog("Nuevo nombre:");
                                if (nombre == null) break;
                                String telefono = JOptionPane.showInputDialog("Nuevo teléfono:");
                                if (telefono == null) break;
                                String correo = JOptionPane.showInputDialog("Nuevo correo:");
                                if (correo == null) break;

                                Cliente clienteActualizado = new Cliente(nombre, cedula, telefono, correo);
                                adminParqueadero.actualizarCliente(clienteActualizado);
                                break;
                            }
                            case 4: { // Eliminar cliente
                                String cedula = JOptionPane.showInputDialog("Cédula cliente a eliminar:");
                                if (cedula == null || cedula.trim().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                                } else {
                                    adminParqueadero.eliminarCliente(cedula.trim());
                                }
                                break;
                            }
                            case 5:
                                break; // Volver al menú principal
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.");
                        }
                        break;
                    }

                    case 4: { // Vehículos
                        byte subopcion = Menu.seleccioanrMenuVehiculos();
                        if (subopcion == -1) break;

                        switch (subopcion) {
                            case 1: { // Ver vehículos
                                String filtroStr = JOptionPane.showInputDialog(
                                    "1. Ver todos\n2. Por placa\n3. Por cédula\n4. Por tipo"
                                );
                                if (filtroStr == null) break;

                                try {
                                    byte filtro = Byte.parseByte(filtroStr);
                                    switch (filtro) {
                                        case 1:
                                            adminParqueadero.listarVehiculos();
                                            break;
                                        case 2: {
                                            String placa = JOptionPane.showInputDialog("Ingrese placa:");
                                            if (placa != null) adminParqueadero.listarVehiculosPorPlaca(placa.trim());
                                            break;
                                        }
                                        case 3: {
                                            String cedula = JOptionPane.showInputDialog("Ingrese cédula:");
                                            if (cedula != null) adminParqueadero.listarVehiculos(cedula.trim());
                                            break;
                                        }
                                        case 4: {
                                            TipoVehiculo tipo = (TipoVehiculo) JOptionPane.showInputDialog(
                                                null,
                                                "Seleccione tipo vehículo",
                                                "Tipo vehículo",
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                TipoVehiculo.values(),
                                                TipoVehiculo.AUTOMOVIL);
                                            if (tipo != null) adminParqueadero.listarVehiculos(tipo);
                                            break;
                                        }
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opción inválida.");
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                                }
                                break;
                            }
                            case 2: { // Registrar vehículo
                                String cedula = JOptionPane.showInputDialog("Ingrese cédula cliente:");
                                if (cedula == null) break;

                                if (!adminParqueadero.buscarClienteForUsuario(cedula.trim())) {
                                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                                    break;
                                }

                                Cliente cliente = adminParqueadero.buscarCliente(cedula.trim());
                                TipoVehiculo tipoVehiculo = (TipoVehiculo) JOptionPane.showInputDialog(
                                        null,
                                        "Seleccione tipo de vehículo",
                                        "Tipo vehículo",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        TipoVehiculo.values(),
                                        TipoVehiculo.AUTOMOVIL);
                                if (tipoVehiculo == null || tipoVehiculo == TipoVehiculo.INDEFINIDO) {
                                    JOptionPane.showMessageDialog(null, "Tipo inválido o cancelado.");
                                    break;
                                }

                                String placa = JOptionPane.showInputDialog("Ingrese placa:");
                                if (placa == null) break;
                                String color = JOptionPane.showInputDialog("Ingrese color:");
                                if (color == null) break;
                                String modelo = JOptionPane.showInputDialog("Ingrese modelo:");
                                if (modelo == null) break;

                                switch (tipoVehiculo) {
                                    case AUTOMOVIL:
                                        cliente.registrarVehiculo(new Automovil(tipoVehiculo, placa, color, modelo, cliente));
                                        break;
                                    case CAMION:
                                        cliente.registrarVehiculo(new Camion(tipoVehiculo, placa, color, modelo, cliente));
                                        break;
                                    case MOTO:
                                        cliente.registrarVehiculo(new Moto(tipoVehiculo, placa, color, modelo, cliente));
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Tipo no reconocido.");
                                }
                                break;
                            }
                            case 3: { // Editar vehículo
                                String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo:");
                                if (placa == null) break;

                                TipoVehiculo tipoVehiculo = (TipoVehiculo) JOptionPane.showInputDialog(
                                    null,
                                    "Seleccione el tipo de vehículo:",
                                    "Tipo de vehículo",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    TipoVehiculo.values(),
                                    TipoVehiculo.AUTOMOVIL);
                                if (tipoVehiculo == null) break;

                                String color = JOptionPane.showInputDialog(null, "Ingrese el color del vehículo:");
                                if (color == null) break;

                                String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo del vehículo:");
                                if (modelo == null) break;

                                adminParqueadero.editarVehiculo(placa.trim(), tipoVehiculo, color.trim(), modelo.trim());
                                break;
                            }
                            case 4: { // Eliminar vehículo
                                String cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula del cliente:");
                                if (cedula == null) break;

                                Cliente c = adminParqueadero.buscarCliente(cedula.trim());
                                if (c == null) {
                                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                                    break;
                                }

                                String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo:");
                                if (placa == null) break;

                                Vehiculo v = c.buscarVehiculoPlaca(placa.trim());
                                if (v == null) {
                                    JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
                                    break;
                                }

                                adminParqueadero.eliminar(v);
                                break;
                            }
                            case 5:
                                break; // Volver
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                        break;
                    }

                    case 5: { // Membresías
                        byte subopcion = Menu.seleccionarMenuMembresias(); 
                        if (subopcion == -1) break;

                        switch (subopcion) {
                            case 1:
                                // TODO: Ver membresías activas
                                break;
                            case 2:
                                // TODO: Crear membresía
                                break;
                            case 3:
                                // TODO: Editar membresía
                                break;
                            case 4:
                                // TODO: Eliminar membresía
                                break;
                            case 5:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                        break;
                    }

                    case 6:
                        // TODO: Opción 6
                        break;

                    case 7:
                        // TODO: Opción 7
                        break;

                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema. ¡Hasta luego!");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo.");
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
            }

        } while (opcion != 0);
    }
}
