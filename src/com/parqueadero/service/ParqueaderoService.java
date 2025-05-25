package com.parqueadero.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.parqueadero.model.Automovil;
import com.parqueadero.model.Camion;
import com.parqueadero.model.Cliente;
import com.parqueadero.model.Factura;
import com.parqueadero.model.IngresoSalida;
import com.parqueadero.model.Membresia;
import com.parqueadero.model.Moto;
import com.parqueadero.model.Parqueadero;
import com.parqueadero.model.TipoVehiculo;
import com.parqueadero.model.Vehiculo;
import com.parqueadero.utils.SelectorFecha;

import Interfaces.GestionClientes;

public class ParqueaderoService implements GestionClientes {

    // Atributos según el UML
    private ArrayList<String> espaciosDisponibles;
    private ArrayList<Cliente> clientes;
    private ArrayList<IngresoSalida> registrosActivos;
    private ArrayList<IngresoSalida> historial;
    private ArrayList<Membresia> membresias;


    // Constructor vacío
    public ParqueaderoService() {
        this.espaciosDisponibles =new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.registrosActivos = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.membresias= new ArrayList<>();
    }

    // Getters
    public ArrayList<String> getEspaciosDisponibles() { return espaciosDisponibles; }
    public ArrayList<Cliente> getClientes() { return clientes; }
    public ArrayList<IngresoSalida> getRegistrosActivos() {return registrosActivos;}
    public ArrayList<IngresoSalida> getHistorial() {return historial;}

    // Setters
     public void setEspaciosDisponibles (ArrayList<String> espaciosDisponibles) {this.espaciosDisponibles = espaciosDisponibles;}
    public void setClientes(ArrayList<Cliente> clientes) {this.clientes = clientes;}

    // metodos
    
//    registrar Cliente
    @Override
    public boolean registrarCliente(Cliente cliente) {
    	for (Cliente c : clientes) {
    	    if (c.getCedula().equals(cliente.getCedula())) {
    	        JOptionPane.showMessageDialog(null, "Ya hay un cliente con esa cédula registrado.");
    	        return false;
    	    }
    	}
    	clientes.add(cliente);
    	JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
    	return true;
    }
    
//	eliminar Cliente
    @Override
    public boolean eliminarCliente(String cedula) {
    	Cliente c = buscarCliente(cedula);
    	if (c != null) {
    		clientes.remove(c);
    		JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
    		return true;
    	}
    	JOptionPane.showMessageDialog(null, "");
    	return false;
    }

//  buscar Cliente para el sistema 
    @Override
    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
            	return cliente;
            }
        }
        JOptionPane.showMessageDialog(null,"No se encontró un cliente con esa cédula.","Cliente no encontrado",JOptionPane.WARNING_MESSAGE);
        return null; // no encontró un cliente con esa cedula
    }
    
    
//    buscar cliente para el usuario (Este solo mostrara: nombre, cedula, telefono y correo)
    public boolean buscarClienteForUsuario(String cedula) {
    	for (Cliente cliente : clientes) {
    		if (cliente.getCedula().equals(cedula.trim())) {
    			JOptionPane.showMessageDialog(null,
    				    "Nombre: " + cliente.getNombre() +
    				    "\nCédula: " + cliente.getCedula() +
    				    "\nTeléfono: " + cliente.getTelefono() +
    				    "\nCorreo: " + cliente.getCorreo(),
    				    "Información del Cliente",
    				    JOptionPane.INFORMATION_MESSAGE);
    			return true;
    		}
    	}
    	JOptionPane.showMessageDialog(null,"No se encontró un cliente con esa cédula.","Cliente no encontrado",JOptionPane.WARNING_MESSAGE);
    	return false;
    }

    
//  actualizar Cliente 
    public boolean actualizarCliente(Cliente clienteActualizado) {
    	Cliente c = buscarCliente(clienteActualizado.getCedula());
    	if (c != null) {			
    			c.setNombre(clienteActualizado.getNombre());
    			c.setTelefono(clienteActualizado.getTelefono());
    			c.setCorreo(clienteActualizado.getCorreo());
    			// para modificar la cedula es un metodo aparte
//    			creo que el metodo de editar la lista de vehiculos va en otra parte
    			JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.");
    			return true;
    	}
    	
    	JOptionPane.showMessageDialog(null, "No se encontró un cliente con esa cédula.");
    	return false;	
    }
     

    
//  registrar Ingreso
    public boolean registrarIngreso(String placa, String tipoVehiculo, LocalDateTime horaEntradaN) {
        // Verificar si ya está registrado
        for (IngresoSalida ingresoExistente : registrosActivos) {
            if (ingresoExistente.getPlaca().equalsIgnoreCase(placa) &&
                ingresoExistente.getHoraSalida() == null) {
            	JOptionPane.showMessageDialog(null, "El vehículo ya está registrado y no ha salido.");
                return false; // Salir sin registrar
            }
        }

        // Si no está, registrar nuevo ingreso
        IngresoSalida ingreso = new IngresoSalida();
        ingreso.setPlaca(placa);
        ingreso.setTipoVehiculo(tipoVehiculo);
        ingreso.setHoraEntrada(horaEntradaN);
        ingreso.setHoraSalida(null); 
        registrosActivos.add(ingreso);
        JOptionPane.showMessageDialog(null, "Registro de entrada exitoso.");
        return true;
    }


//  registrar Salida
    public boolean registrarSalida(String placa, LocalDateTime horaSalidaN) {
        for (IngresoSalida r : registrosActivos) {
            if (r.getPlaca().equalsIgnoreCase(placa)) {
                if (r.getHoraSalida() == null) {
                    r.setHoraSalida(horaSalidaN);
                    JOptionPane.showMessageDialog(null, "Registro de salida exitoso.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "El vehículo ya salió del parqueadero.");
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El vehículo no está registrado.");
        return false;
    }

//	registra el monto
    public double registrarCalculoMonto(String placa ,String tipoVehiculo) {
        for (IngresoSalida r : registrosActivos ) {
        	if(r.getPlaca().equalsIgnoreCase(placa) && r.getHoraSalida() != null) {
        		double minutos = java.time.Duration.between(r.getHoraEntrada(), r.getHoraSalida()).toMinutes();
                double monto = calcularMonto(r.getTipoVehiculo(), minutos);
                r.setValorCalculado(monto);
                historial.add(r);
                registrosActivos.remove(r);
        	}
        }

    	return 0;
//    	Metodo incompleto
    	
    }
//   hace la operacion 
    public double calcularMonto(String tipoVehiculo, double duracion) {
		double montoAPagar = 0;
		
		return montoAPagar;
	}
//    Metodo incompleto
    

    public Factura generarFactura(Vehiculo vehiculo) {
        return null;
    }

    public List<IngresoSalida> consultarHistorialCliente(String cedula) {
        return null; // historialCliente
    }

    public double calcularGanancias(LocalDate fechaInicio, LocalDate fechaFin) {
        return 0;
    }

    
//  listar Vehiculos Actuales  
    public void listarVehiculos() { 
        StringBuilder vehiculos = new StringBuilder();
        // Iterar sobre los clientes y sus vehículos
        for (Cliente c : clientes) { 
            for (Vehiculo v : c.getVehiculos()) { 
                vehiculos.append(v).append("\n");  // Se van agregando los vehículos por línea con un salto.
            }	        
        }
      //Se valida si veículos tiene información que mostrar
        if (vehiculos.length() > 0) {
            JOptionPane.showMessageDialog(null, vehiculos.toString(), "Lista de Vehículos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.", "Lista Vacía", JOptionPane.WARNING_MESSAGE);
        }
    }
        
    public boolean listarVehiculosPorPlaca(String placa) {
    	for(Cliente c : clientes) {
    		for(Vehiculo v : c.getVehiculos()) {
    			if(v.getPlaca().equalsIgnoreCase(placa)) {
    				JOptionPane.showMessageDialog(null, v);
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public void listarVehiculos(String cedula) {
    	StringBuilder vehiculos = new StringBuilder();
        for(Cliente c: clientes) {
        	if(c.getCedula().equalsIgnoreCase(cedula.trim())) {
        		for(Vehiculo v: c.getVehiculos()) {
        			vehiculos.append(v).append("\n");
        		}
        	}
        }
        if (vehiculos.length() > 0) {
            JOptionPane.showMessageDialog(null, vehiculos.toString(), "Lista de Vehículos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.", "Lista Vacía", JOptionPane.WARNING_MESSAGE);
        }
    }

	

	
	
    
    
    public void listarVehiculos(TipoVehiculo tipoVehiculo) {
    	StringBuilder vehiculos = new StringBuilder();
        for(Cliente c: clientes) {
    		for(Vehiculo v: c.getVehiculos()) {
    			if(v.getTipoVehiculo().equals(tipoVehiculo)) {
    				vehiculos.append(v).append("\n");
    			}   			
    		}       	
        }
        if (vehiculos.length() > 0) {
            JOptionPane.showMessageDialog(null, vehiculos.toString(), "Lista de Vehículos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.", "Lista Vacía", JOptionPane.WARNING_MESSAGE);
        }
    }// Metodo incompleto|
    
//    Gestion de datos de parquadero:
    
    public void editarDatosParqueadero(String nombreN, String direccionN, String representanteN, String contactoN,
    	int espaciosDisponiblesMotosN, int espaciosDisponiblesCarrosN, int espaciosDisponiblesCamionesN) {
    	
    	Parqueadero p = new Parqueadero();
    	
    	p.setNombre(nombreN);
    	p.setDireccion(direccionN);
    	p.setRepresentante(representanteN);
    	p.setContacto(contactoN);
    	p.setContacto(contactoN);
    	p.setEspaciosDisponiblesCamiones(espaciosDisponiblesCamionesN);
    	p.setEspaciosDisponiblesCarros(espaciosDisponiblesCarrosN);
    	p.setEspaciosDisponiblesMotos(espaciosDisponiblesMotosN);
    	
    }
    
    
    //Membresias
    
    
    public boolean crearMembresia() {
    	Membresia membresia=null;
		String cedula= JOptionPane.showInputDialog("Ingrese la cédula del cliente: ");
		for(Cliente c: clientes) {
			if(c.getCedula().equalsIgnoreCase(cedula.trim())) {
				String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
				for(Vehiculo v:c.getVehiculos()) {
					if(v.getPlaca().equalsIgnoreCase(placa.trim())) {
						LocalDate fechaInicio = SelectorFecha.seleccionarFecha();
						if(SelectorFecha.validarFechaVigente(fechaInicio)) {
							if(v instanceof Automovil) {
								 membresia= new Membresia(fechaInicio, v, c, Automovil.getTarifaMembresia());
								 System.out.println(membresia);
							}if(v instanceof Moto) {
								membresia= new Membresia(fechaInicio, v, c, Moto.getTarifaMembresia());
							}if(v instanceof Camion) {
								membresia= new Membresia(fechaInicio, v, c, Camion.getTarifaMembresia());
							}
							if(membresia!=null) {
								if(membresia.confirmarMembresia(membresia)) {
									membresias.add(membresia);
									JOptionPane.showMessageDialog(null, "La membresía fue guardada de forma correcta.");
									return true;
								}else {
									JOptionPane.showMessageDialog(null, "La membresía no pudo ser creada.");
									return false;
								}
							}else {
								JOptionPane.showMessageDialog(null, "La membresía no pudo ser creada.");
								return false;
							}	
						}else {
							return false;
						}
					}else {
						JOptionPane.showMessageDialog(null, "El vehículo no está asociado al cliente.");
						return false;
					}
				}				
			}else {
				JOptionPane.showMessageDialog(null, "El cliente no está registrado.");
				return false;
			}
		}
		return false;
    }
    
    public 
    
    
    
    
    
    
    
    
    
    
    
    
} 
