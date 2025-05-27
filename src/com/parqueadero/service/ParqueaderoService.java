package com.parqueadero.service;

import java.time.Duration;
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
import com.parqueadero.model.Pago;
import com.parqueadero.model.Parqueadero;
import com.parqueadero.model.TipoPago;
import com.parqueadero.model.TipoVehiculo;
import com.parqueadero.model.Vehiculo;
import com.parqueadero.utils.SelectorFecha;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Interfaces.GestionClientes;
import Interfaces.Tarifable;

public class ParqueaderoService implements GestionClientes {

    // Atributos según el UML
	private String nombre;
	private String direccion;
	private String representante;
	private String contacto;
	private int espaciosMotos;
	private int espaciosCarros;
	private int espaciosCamiones;
	private PagoService adminPago; //Es necesario para guardar los pagos en una sola lista.
	
    private ArrayList<String> espaciosDisponibles;
    private ArrayList<Cliente> clientes;
    // los metodos de aqui hacia arriba son los mismos de la clase parqueadero
    private ArrayList<IngresoSalida> vehiculosTemporales;
    private ArrayList<IngresoSalida> historial;
    private ArrayList<Membresia> membresias;
    private ArrayList<String> vehiculosIngresados;



    // Constructor vacío
    public ParqueaderoService(String nombre, String direccion, String representante, String contacto, int espaciosMotos, int espaciosCarros, int espaciosCamiones, PagoService adminPago) {
    	this.nombre= nombre;
    	this.direccion=direccion;
    	this.representante= representante;
    	this.contacto=contacto;
    	this.espaciosMotos= espaciosMotos;
    	this.espaciosCarros= espaciosCarros;
    	this.espaciosCamiones=espaciosCamiones;
        this.espaciosDisponibles =new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vehiculosTemporales = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.membresias= new ArrayList<>();

        this.vehiculosIngresados=new ArrayList<>();
        this.adminPago= adminPago;
        

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
        Vehiculo vehiculo1 = new Automovil(TipoVehiculo.AUTOMOVIL, "ABC123", "Negro", "2025", cliente1);
        Vehiculo vehiculo2 = new Moto(TipoVehiculo.MOTO, "MOT456", "Rojo", "2024", cliente1);

        Vehiculo vehiculo3 = new Camion(TipoVehiculo.CAMION, "CAM789", "Blanco", "2023", cliente2);
        Vehiculo vehiculo4 = new Automovil(TipoVehiculo.AUTOMOVIL, "XYZ123", "Azul", "2026", cliente2);

        Vehiculo vehiculo5 = new Moto(TipoVehiculo.MOTO, "JKL456", "Verde", "2022", cliente3);
        Vehiculo vehiculo6 = new Automovil(TipoVehiculo.AUTOMOVIL, "QWE789", "Gris", "2025", cliente3);

        Vehiculo vehiculo7 = new Camion(TipoVehiculo.CAMION, "RTY654", "Amarillo", "2024", cliente4);
        Vehiculo vehiculo8 = new Moto(TipoVehiculo.MOTO, "UIO321", "Negro", "2023", cliente4);

        Vehiculo vehiculo9 = new Automovil(TipoVehiculo.AUTOMOVIL, "PAS111", "Blanco", "2026", cliente5);
        Vehiculo vehiculo10 = new Camion(TipoVehiculo.CAMION, "ZXC222", "Rojo", "2022", cliente5);

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
    
        
        crearMembresia("1012", "ABC123", LocalDate.now(), 30);
        crearMembresia("1012", "MOT456", LocalDate.now(), 7);
        crearMembresia("2023", "CAM789", LocalDate.now(), 365);
    }

    // Getters
    public String getNombre() {return nombre;}
    public String getDireccion() {return direccion;}
    public String getRepresentante() {return representante;}
    public String getContacto() {return contacto;}
    public int getEspaciosMotos() {return espaciosMotos;}
    public int getEspaciosCarros() {return espaciosCarros;}
    public int getEspaciosCamion() {return espaciosCamiones;}    
    public ArrayList<String> getEspaciosDisponibles() { return espaciosDisponibles; }
    public ArrayList<Cliente> getClientes() { return clientes; }
    public ArrayList<IngresoSalida> getRegistrosActivos() {return vehiculosTemporales;}
    public ArrayList<IngresoSalida> getHistorial() {return historial;}
    public ArrayList<IngresoSalida> getVehiculosTemporales(){return vehiculosTemporales;}

    // Setters
    public void setNombre(String nombre) {this.nombre=nombre;}
    public void setDireccion(String nombre) {this.direccion=nombre;}
    public void setRepresentante(String nombre) {this.representante=nombre;}
    public void setContacto(String nombre) {this.contacto=nombre;}
    public void setEspaciosMotos(int espacios) {this.espaciosMotos=espacios;}
    public void setEspaciosCarros(int espacios) {this.espaciosCarros=espacios;}
    public void setEspaciosCamiones(int espacios) {this.espaciosCamiones=espacios;}    
    public void setEspaciosDisponibles (ArrayList<String> espaciosDisponibles) {this.espaciosDisponibles = espaciosDisponibles;}
    public void setClientes(ArrayList<Cliente> clientes) {this.clientes = clientes;}
    public void setVehiculosTemporales(ArrayList<IngresoSalida> vehiculosTemporales) {this.vehiculosTemporales = vehiculosTemporales;}
    
    
    
    
    
    
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
    public void registrarIngreso(String placa, TipoVehiculo tipoVehiculo) {
        LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		// Verificar si ya está registrado
        for (IngresoSalida ingresoExistente : vehiculosTemporales) {
            if (ingresoExistente.getPlaca().equalsIgnoreCase(placa) &&
                ingresoExistente.getHoraSalida() == null) {
            	JOptionPane.showMessageDialog(null, "El vehículo ya está registrado y no ha salido.");
                return;// Salir sin registrar
            }
        }
        
        
        // Verificar espacio disponible
        if ((tipoVehiculo == TipoVehiculo.AUTOMOVIL && espaciosCarros <= 0) ||
            (tipoVehiculo == TipoVehiculo.MOTO && espaciosMotos <= 0) ||
            (tipoVehiculo == TipoVehiculo.CAMION && espaciosCamiones <= 0)) {
            JOptionPane.showMessageDialog(null, "No hay espacios disponibles para este tipo de vehículo.");
            return;
        }
        
		
		        
        // Si no está, registrar nuevo ingreso
        IngresoSalida ingreso = new IngresoSalida();
        ingreso.setPlaca(placa);
        ingreso.setTipoVehiculo(tipoVehiculo);
        ingreso.setHoraEntrada(ahora);
        ingreso.setHoraSalida(null); 
        vehiculosTemporales.add(ingreso);
        vehiculosIngresados.add(placa);
        if(tipoVehiculo == TipoVehiculo.AUTOMOVIL) {
        	espaciosCarros-=1;
        }
        
        if(tipoVehiculo == TipoVehiculo.MOTO) {
        	espaciosMotos-=1;
        }
        
        if(tipoVehiculo == TipoVehiculo.CAMION) {
        	espaciosCamiones-=1;
        }

        JOptionPane.showMessageDialog(null, "Registro de entrada exitoso, con fecha: " + ahora.format(formatter));

        return;
    }

    
    

//  registrar Salida
    
    public TipoVehiculo registrarSalida(String placa, LocalDateTime horaSalidaN) {
    	Pago pago;
        for (IngresoSalida r : vehiculosTemporales) {
            if (r.getPlaca().equalsIgnoreCase(placa)) {
                if (r.getHoraSalida() == null) {
                    r.setHoraSalida(horaSalidaN);
                    
                    // Busca el vehiculo por la placa en lista de vehiculos actuales y la borra.
                    vehiculosIngresados.removeIf(p -> p.equalsIgnoreCase(placa));

                    
                    JOptionPane.showMessageDialog(null, "Registro de salida exitoso.");
                    if (r.getTipoVehiculo() == TipoVehiculo.AUTOMOVIL) {
                    	espaciosCarros+= 1;
                    }
                    
                    if (r.getTipoVehiculo() == TipoVehiculo.MOTO) {
                    	espaciosMotos+= 1;
                    }
                    
                    if (r.getTipoVehiculo() == TipoVehiculo.CAMION) {
                    	espaciosCamiones+= 1;
                    }
                    
                    return r.getTipoVehiculo();
                } else {
                    JOptionPane.showMessageDialog(null, "El vehículo ya salió del parqueadero.");    
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El vehículo no está registrado.");
        return null;
    }
    
    
    
    public double calcularHoras(String placa) {
        for (IngresoSalida r : vehiculosTemporales) {
            if (r.getPlaca().equalsIgnoreCase(placa)) {
                if (r.getHoraEntrada() != null && r.getHoraSalida() != null) {
                    Duration duracion = Duration.between(r.getHoraEntrada(), r.getHoraSalida());
                    return duracion.toMinutes() / 60.0; // horas decimales
                } else {
                    JOptionPane.showMessageDialog(null, "El vehículo aún no ha salido del parqueadero.");
                    return 0;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        return 0;
    }

    
    
//		Tarifa
 
        public void editarTarifaVehiculo(TipoVehiculo tipoVehiculo, double nuevaTarifa) {
            switch (tipoVehiculo) {
                case MOTO:
                    Moto.setTarifaHoraMoto(nuevaTarifa);
                    break;
                case AUTOMOVIL:
                    Automovil.setTarifaHoraAutomovil(nuevaTarifa);
                    break;
                case CAMION:
                    Camion.setTarifaHoraCamion(nuevaTarifa);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de vehículo no válido");
            }
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
      //Se valida si vehículos tiene información que mostrar
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
        			for (int i = 0; i < vehiculosIngresados.size(); i++) {
        			    if (vehiculosIngresados.get(i).equalsIgnoreCase(m.getVehiculo().getPlaca().trim())) {
        			        vehiculosIngresados.remove(i);
        			        i--; // Ajusta el índice para evitar saltos en la iteración
        			    }
        			}       			
        			if(m.getVehiculo() instanceof Moto) {
        				espaciosMotos+=1;
        			}
					if(m.getVehiculo() instanceof Automovil) {
						espaciosCarros+=1;        				
        			}
					if(m.getVehiculo() instanceof Camion) {
						espaciosCamiones+=1;
					}
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
		setNombre(nombreN);
		setDireccion(direccionN);
		setRepresentante(representanteN);
		setContacto(contactoN);
		setEspaciosCamiones(espaciosDisponiblesCamionesN);
		setEspaciosCarros(espaciosDisponiblesCarrosN);
		setEspaciosMotos(espaciosDisponiblesMotosN);
		
		JOptionPane.showMessageDialog(null, "Los datos fueron editados correctamente");
    }
    

    
   
	public void mostrarDatosParqueadero() {
	   String mensaje = "DATOS DEL PARQUEADERO:\n\n" +
	                     "Nombre: " + getNombre() + "\n" +
	                     "Dirección: " + getDireccion() + "\n" +
	                     "Representante: " + getRepresentante() + "\n" +
	                     "Contacto: " + getContacto() + "\n" +
	                     "Espacios disponibles:\n" +
	                     "  Motos: " + getEspaciosMotos() + "\n" +
	                     "  Carros: " + getEspaciosCarros() + "\n" +
	                     "  Camiones: " + getEspaciosCamion();
	
	   JOptionPane.showMessageDialog(null, mensaje);
	}
    

    
    
    //Membresias
    
    
    public Membresia crearMembresia(String cedula,String placa, LocalDate fechaInicio, int cantidadDias) {
    	Membresia membresia=null;
    	Cliente c=null;
    	Vehiculo v=null;
    	
    	//Verifica si ya existe una membresia
    	if(membresias.size()>0) {
    		for(Membresia m: membresias) {
        		if(m.getVehiculo().getPlaca().equalsIgnoreCase(placa.trim())) {
        			JOptionPane.showMessageDialog(null, "Ya existe una membresía para el vehículo ingresado.");        			
        			return null;
        		}
    		}
    	}
    	
    	//Busca el cliente según la cédula.
		for(Cliente cliente: clientes) {
			System.out.println("Cedula del cliente por el for " + cliente.getCedula());
			System.out.println("Cedula parametro " + cedula);
			if(cliente.getCedula().equalsIgnoreCase(cedula.trim())) {
				c = cliente;
				break;
			}
		}
		
		//Buscar el vehículo dentro de cliente.
		for(Vehiculo vehiculo:c.getVehiculos()) {
			if(vehiculo.getPlaca().equalsIgnoreCase(placa.trim())) {
				v=vehiculo;
				break;
			}
		}	
		
		
		//Validar que la fecha sea válida.
		if(!SelectorFecha.validarFechaVigente(fechaInicio)) {
			return null;
		}
		
		//Crear la membresía según el tipo de vehículo
		membresia= new Membresia(fechaInicio, v, c, v.getTarifaMembresia(), cantidadDias);
		/*if(v instanceof Automovil) {
			 membresia= new Membresia(fechaInicio, v, c, Automovil.getTarifaMembresia());
		}if(v instanceof Moto) {
			membresia= new Membresia(fechaInicio, v, c, Moto.getTarifaMembresia());
		}if(v instanceof Camion) {
			membresia= new Membresia(fechaInicio, v, c, Camion.getTarifaMembresia());
		}*/
		if(membresia!=null) {
			if(membresia.confirmarMembresia(membresia)) {
				membresias.add(membresia); // Se agrega a la lista de membresías.
				vehiculosIngresados.add(membresia.getVehiculo().getPlaca()); // Se agrega a la lista de vehículos dentro del parqueadero.
				JOptionPane.showMessageDialog(null, "La membresía fue guardada de forma correcta.");
				Pago pago= new Pago(c,v, membresia.getMonto(), TipoPago.MEMBRESIA);
				adminPago.registrarPago(pago, membresia);
				if(v instanceof Automovil) {
					 espaciosCarros-=1;
				}if(v instanceof Moto) {
					espaciosMotos-=1;
				}if(v instanceof Camion) {
					espaciosCamiones-=1;
				}
				return membresia;
			}else {
				JOptionPane.showMessageDialog(null, "Ha cancelado el registro de la membresía.");
				return null;
			}
		}
		return null;
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
    
    public void mostrarVehiculosActuales() {
    	StringBuilder mensaje=new StringBuilder();
    	for(String elemento:vehiculosIngresados) {
    		mensaje.append(elemento + "\n");
    	}
    	JOptionPane.showMessageDialog(null, mensaje);
    }
    
    
    
    public String toString() {
    	return "Nombre del parqueadero: " + nombre + "\nDireccion: " + direccion + "\nRepresentante: " + representante + "\nContacto: " + contacto + "\nEspacios para motos: " + espaciosMotos + "\nEspacios para carros: " + espaciosCarros + "\nEspacios para camiones: " + espaciosCamiones;
    }

	public ArrayList <String> getVehiculosIngresados() {
		return vehiculosIngresados;
	}

	public void setVehiculosIngresados(ArrayList <String> vehiculosIngresados) {
		this.vehiculosIngresados = vehiculosIngresados;
	}
    
    
    
    
    
    
    
    
} 
