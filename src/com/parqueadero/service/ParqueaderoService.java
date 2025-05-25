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
	private String nombre;
	private String direccion;
	private String representante;
	private String contacto;
	private int espaciosMotos;
	private int espaciosCarros;
	private int espaciosCamiones;
	
    private ArrayList<String> espaciosDisponibles;
    private ArrayList<Cliente> clientes;
    private ArrayList<IngresoSalida> registrosActivos;
    private ArrayList<IngresoSalida> historial;
    private ArrayList<Membresia> membresias;


    // Constructor vacío
    public ParqueaderoService(String nombre, String direccion, String representante, String contacto, int espaciosMotos, int espaciosCarros, int espaciosCamiones) {
    	this.nombre= nombre;
    	this.direccion=direccion;
    	this.representante= representante;
    	this.contacto=contacto;
    	this.espaciosMotos= espaciosMotos;
    	this.espaciosCarros= espaciosCarros;
    	this.espaciosCamiones=espaciosCamiones;
        this.espaciosDisponibles =new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.registrosActivos = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.membresias= new ArrayList<>();
        
      //Datos para que el sistema esté alimantado
        
        //Clientes
        Cliente cliente1 = new Cliente("Pedro Perez", "1012", "3100000003", "pedroperez@correo.com");
        Cliente cliente2 = new Cliente("Maria Gómez", "2023", "3123456789", "mariagomez@correo.com");
        Cliente cliente3 = new Cliente("Juan Rodríguez", "3034", "3156789012", "juanrodriguez@correo.com");
        Cliente cliente4 = new Cliente("Laura Fernández", "4045", "3201234567", "laurafernandez@correo.com");
        Cliente cliente5 = new Cliente("Carlos Méndez", "5056", "3224567890", "carlosmendez@correo.com");
        this.clientes.add(cliente1);
        this.clientes.add(cliente2);
        this.clientes.add(cliente3);
        this.clientes.add(cliente4);
        this.clientes.add(cliente5);
        
       
     // Vehículos
        Vehiculo vehiculo1 = new Vehiculo(TipoVehiculo.AUTOMOVIL, "ABC123", "Negro", "2025", cliente1);
        Vehiculo vehiculo2 = new Vehiculo(TipoVehiculo.MOTO, "MOT456", "Rojo", "2024", cliente1);

        Vehiculo vehiculo3 = new Vehiculo(TipoVehiculo.CAMION, "CAM789", "Blanco", "2023", cliente2);
        Vehiculo vehiculo4 = new Vehiculo(TipoVehiculo.AUTOMOVIL, "XYZ123", "Azul", "2026", cliente2);

        Vehiculo vehiculo5 = new Vehiculo(TipoVehiculo.MOTO, "JKL456", "Verde", "2022", cliente3);
        Vehiculo vehiculo6 = new Vehiculo(TipoVehiculo.AUTOMOVIL, "QWE789", "Gris", "2025", cliente3);

        Vehiculo vehiculo7 = new Vehiculo(TipoVehiculo.CAMION, "RTY654", "Amarillo", "2024", cliente4);
        Vehiculo vehiculo8 = new Vehiculo(TipoVehiculo.MOTO, "UIO321", "Negro", "2023", cliente4);

        Vehiculo vehiculo9 = new Vehiculo(TipoVehiculo.AUTOMOVIL, "PAS111", "Blanco", "2026", cliente5);
        Vehiculo vehiculo10 = new Vehiculo(TipoVehiculo.CAMION, "ZXC222", "Rojo", "2022", cliente5);

        // Asignar los vehículos a los clientes
        cliente1.registrarVehiculo(vehiculo1);
        cliente1.registrarVehiculo(vehiculo2);

        cliente2.registrarVehiculo(vehiculo3);
        cliente2.registrarVehiculo(vehiculo4);

        cliente3.registrarVehiculo(vehiculo5);
        cliente3.registrarVehiculo(vehiculo6);

        cliente4.registrarVehiculo(vehiculo7);
        cliente4.registrarVehiculo(vehiculo8);

        cliente5.registrarVehiculo(vehiculo9);
        cliente5.registrarVehiculo(vehiculo10);
        
        //Membresias
        
        
        

    }

    // Getters
    public String getNombre() {return nombre;}
    public String getDireccion() {return direccion;}
    public String getrepresentante() {return representante;}
    public String getContacto() {return contacto;}
    public int getEspaciosMotos() {return espaciosMotos;}
    public int getEspaciosCarros() {return espaciosCarros;}
    public int getEspaciosCamion() {return espaciosCamiones;}    
    public ArrayList<String> getEspaciosDisponibles() { return espaciosDisponibles; }
    public ArrayList<Cliente> getClientes() { return clientes; }
    public ArrayList<IngresoSalida> getRegistrosActivos() {return registrosActivos;}
    public ArrayList<IngresoSalida> getHistorial() {return historial;}

    // Setters
    public void seetNombre(String nombre) {this.nombre=nombre;}
    public void setDireccion(String nombre) {this.direccion=nombre;}
    public void setRepresentante(String nombre) {this.representante=nombre;}
    public void setContacto(String nombre) {this.contacto=nombre;}
    public void setEspaciosMotos(int espacios) {this.espaciosMotos=espacios;}
    public void setEspaciosCarros(int espacios) {this.espaciosCarros=espacios;}
    public void setEspaciosCamiones(int espacios) {this.espaciosCamiones=espacios;}    
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

    
//Vehiculos    
    
    
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
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.", getNombre(), JOptionPane.WARNING_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.", getNombre(), JOptionPane.WARNING_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No hay vehículos registrados.", getNombre(), JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    
    public boolean editarVehiculo(String placa,TipoVehiculo tipoVehiculo,String color, String modelo) {
    	for(Cliente c: clientes) {
    		for(Vehiculo v: c.getVehiculos()) {
    			if(v.getPlaca().equalsIgnoreCase(placa.trim())) {
    				v.setTipoVehiculo(tipoVehiculo);
    				v.setPlaca(placa.toUpperCase().trim());
    				v.setColor(color);
    				v.setModelo(modelo);
    				v.setCliente(c);
    				if(v.confirmarVehiculo(v)) {
    					JOptionPane.showMessageDialog(null, "Los datos del vehículo se han modificado de forma correcta.");
            			return true;
        			}
    			}
    		}
    	}
    	JOptionPane.showMessageDialog(null, "El vehiculo no existe.");
    	return false;
    }
    
    
    public boolean eliminar(Vehiculo vehiculo) {
    	int aux=0;
    	for(Cliente c:clientes) {
    		for(Vehiculo v: c.getVehiculos()) {
        		if(v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca().trim())) {
        			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar El vehículo?\n" + v, getNombre(), 0);
        			if(confirmacion==0) {
            			c.getVehiculos().remove(aux);
            			if(v instanceof Moto) {
            				espaciosMotos+=1;
            			}
						if(v instanceof Automovil) {
							espaciosCarros+=1;        				
            			}
						if(v instanceof Moto) {
							espaciosCamiones+=1;
						}
            			JOptionPane.showMessageDialog(null, "El vehículo se ha elimiando de forma correcta.");
        				return true;
        			}
        			
        		}
        		aux+=1;
        	}
    	}
    	
    	
    	return false;
    }
    
    
    public boolean eliminar(Membresia membresia) {
    	int aux=0;
    	for(Membresia m: membresias) {
    		if(m.getVehiculo().getPlaca().equalsIgnoreCase(membresia.getVehiculo().getPlaca().trim())) {
    			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la membresía?\n" + m , getNombre(), 0);
    			if(confirmacion==0) {
        			membresias.remove(aux);
        			JOptionPane.showMessageDialog(null, "La membresía se ha elimiando de forma correcta.");
    				return true;
    			}
    			
    		}
    		aux+=1;
    	}
    	return false;
    }
    
    
    
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
    
    
    public Membresia crearMembresia(String cedula,String placa, LocalDate fechaInicio) {
    	System.out.println("Ha ingresado al metodo crear membresia");
    	Membresia membresia=null;
    	
    	if(membresias.size()>0) {
    		for(Membresia m: membresias) {
    			System.out.println("Placa extraída de la lista de mebresías" + m.getVehiculo().getPlaca());
        		if(m.getVehiculo().getPlaca().equalsIgnoreCase(placa.trim())) {
        			System.out.println("Ha dado por veradero");
        			JOptionPane.showMessageDialog(null, "Ya existe una membresía para el vehículo ingresado.");
        			return null;
        		}
    		}
    	}
		System.out.println("El vehiculo no tiene membresia y sigue");
		//String cedula= JOptionPane.showInputDialog("Ingrese la cédula del cliente: ");
		for(Cliente c: clientes) {
			if(c.getCedula().equalsIgnoreCase(cedula.trim())) {
				//String placa= JOptionPane.showInputDialog("Ingrese la placa del vehículo: ");
				for(Vehiculo v:c.getVehiculos()) {
					System.out.println("Placa extraída de la lista " + v.getPlaca());
					System.out.println("Placa enviada por parametro " + placa);
					if(v.getPlaca().equalsIgnoreCase(placa.trim())) {
						//LocalDate fechaInicio = SelectorFecha.seleccionarFecha();
						if(SelectorFecha.validarFechaVigente(fechaInicio)) {
							System.out.println("Ingreso a las instancias");
							if(v instanceof Automovil) {
								 membresia= new Membresia(fechaInicio, v, c, Automovil.getTarifaMembresia());
								 espaciosCarros-=1;
								 System.out.println(membresia);
								 System.out.println("Espacios para automoviles: " + espaciosCarros);
							}if(v instanceof Moto) {
								membresia= new Membresia(fechaInicio, v, c, Moto.getTarifaMembresia());
								espaciosMotos-=1;
								System.out.println("Espacios para motos: " + espaciosMotos);
							}if(v instanceof Camion) {
								membresia= new Membresia(fechaInicio, v, c, Camion.getTarifaMembresia());
								espaciosCamiones-=1;
								System.out.println("Espacios para camiones: " + espaciosCamiones);
							}
							if(membresia!=null) {
								if(membresia.confirmarMembresia(membresia)) {
									membresias.add(membresia);
									JOptionPane.showMessageDialog(null, "La membresía fue guardada de forma correcta.");
									return membresia;
								}else {
									JOptionPane.showMessageDialog(null, "La membresía no pudo ser creada.");
									return null;
								}
							}else {
								JOptionPane.showMessageDialog(null, "La membresía no pudo ser creada.");
								return null;
							}	
						}else {
							return null;
						}
					}
				}	
				JOptionPane.showMessageDialog(null, "El vehículo no está asociado al cliente.");
				return null;			
			}else {
				JOptionPane.showMessageDialog(null, "El cliente no está registrado.");
				return null;
			}
		}return null;
	}
    
    
    
    
    
    public void listarMembresias() {
    	StringBuilder mensaje = new StringBuilder();
        for(Membresia m: membresias) {
			mensaje.append(m).append("\n");     	
        }
        if (mensaje.length() > 0) {
            JOptionPane.showMessageDialog(null, membresias.toString(), "Lista de Vehículos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay membresías registradas.", getNombre(), JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public Membresia getMembresia(String placa) {
    	for(Membresia m: membresias) {
    		if(m.getVehiculo().getPlaca().equalsIgnoreCase(placa.trim())) {
    			return m;
    		}
    	}
    	return null;
    }
    
    
    
    public boolean editarMembresia(String cedula,String placa, LocalDate fechaInicio) {
    	Cliente c= buscarCliente(cedula);
    	for(Membresia m: membresias) {
    		if(m.getVehiculo().getPlaca().equalsIgnoreCase(placa.trim())) {
    			m.setFechaInicio(fechaInicio);
    			m.setCliente(c);
    			m.setFechaInicio(fechaInicio);
    			m.setFechaFinal(fechaInicio.plusDays(m.getCantidadDiasMembresia()));
    			if(m.confirmarMembresia(m)) {
					JOptionPane.showMessageDialog(null, "La membresía se ha modificado de forma exitosa.");
        			return true;
    			}
    		}
    	}
    	return false;
    }
    
    
    
    
    
    public String toString() {
    	return "Nombre del parqueadero: " + nombre + "\nDireccion: " + direccion + "\nRepresentante: " + representante + "\nContacto: " + contacto + "\nEspacios para motos: " + espaciosMotos + "\nEspacios para carros: " + espaciosCarros + "\nEspacios para camiones: " + espaciosCamiones;
    }
    
    
    
    
    
    
    
    
} 
