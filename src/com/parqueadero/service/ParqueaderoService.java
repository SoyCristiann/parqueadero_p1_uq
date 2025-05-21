package com.parqueadero.service;

import com.parqueadero.model.Cliente;
import com.parqueadero.model.Factura;
import com.parqueadero.model.IngresoSalida;
import com.parqueadero.model.Membresia;
import com.parqueadero.model.Vehiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class ParqueaderoService {

    // Atributos según el UML
    private String nombre;
    private String direccion;
    private String representante;
    private String contacto;
    private ArrayList<String> espaciosDisponibles;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<IngresoSalida> registrosActivos;
    private ArrayList<IngresoSalida> historial;


    // Constructor vacío
    public ParqueaderoService() {
    	this.nombre = "";
        this.direccion = "";
        this.representante = "";
        this.contacto = "";
        this.espaciosDisponibles =new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.registrosActivos = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    // Constructor con parámetros
    public ParqueaderoService(String nombre, String direccion, String representante, String contacto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.representante = representante;
        this.contacto = contacto;
        this.espaciosDisponibles = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.registrosActivos = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getRepresentante() { return representante; }
    public String getContacto() { return contacto; }
    public ArrayList<String> getEspaciosDisponibles() { return espaciosDisponibles; }
    public ArrayList<Cliente> getClientes() { return clientes; }
    public ArrayList<IngresoSalida> getRegistrosActivos() {return registrosActivos;}
    public ArrayList<IngresoSalida> getHistorial() {return historial;}

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setRepresentante(String representante) { this.representante = representante; }
    public void setContacto(String contacto) {this.contacto = contacto; }
    public void setEspaciosDisponibles (ArrayList<String> espaciosDisponibles) {this.espaciosDisponibles = espaciosDisponibles;}
    public void setClientes(ArrayList<Cliente> clientes) {this.clientes = clientes;}

    // metodos
    
//    registrar Cliente
    public boolean registrarCliente(Cliente cliente) {
    	for (Cliente c : clientes) {
    		if (c.getCedula() != cliente.getCedula()) {
    			clientes.add(cliente);
    			JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
    			return true;
    		}
    	}
    	
    	JOptionPane.showMessageDialog(null, "Ya hay un cliente con esa cedula registrado.");
    	return false; 
    }
    
//	eliminar Cliente
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
    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
            	return cliente;
            }
        }
        return null; // no encontró un cliente con esa cedula
    }
//    buscar cliente para el usuario (Este solo mostrara: nombre, cedula, telefono y correo)
    public void buscarClienteForUsuario(String cedula) {
    	for (Cliente cliente : clientes) {
    		if (cliente.getCedula().equals(cedula)) {
    			JOptionPane.showMessageDialog(null, 
    			"Nombre: " + cliente.getNombre() 
    			+ "\nCédula: " + cliente.getCedula() 
    			+ "\nTeléfono: " + cliente.getTelefono() 
    			+ "\nCorreo: " + cliente.getCorreo()
    			+ "\n\n");
    			
    		}
    	}
    	JOptionPane.showMessageDialog(null, "No se encontró un cliente con esa cédula.");
    	
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
    
//  ver Vehiculos Cliente  
    public void verVehiculosCliente(String cedula) {
        Cliente cliente = buscarCliente(cedula);
        if (cliente != null) {
        	JOptionPane.showMessageDialog(null, "");
        } else {
        	JOptionPane.showMessageDialog(null, "");
        }
        
    }

    /*
    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Cliente c : clientes) {
            for (Vehiculo v : c.getVehiculos()) {
                if (v.getPlaca().equalsIgnoreCase(placa)) {
                    return v;
                }
            }
        }
        return null;
    } */

    
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
//    	No se ha terminado
    	
    }
//   hace la operacion 
    public double calcularMonto(String tipoVehiculo, double duracion) {
		double montoAPagar = 0;
		
		return montoAPagar;
	}
    
    

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
    public List<Vehiculo> listarVehiculosActuales() {
        
    	return null; // listVehiculosActuales;
    }


	
}
