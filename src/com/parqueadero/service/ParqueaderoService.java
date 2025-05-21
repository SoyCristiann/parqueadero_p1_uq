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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class ParqueaderoService {

    // Atributos según el UML
    private String nombre;
    private String direccion;
    private String representante;
    private String contacto;
    private Map<String, Integer> espaciosDisponibles;
    private List<Cliente> clientes = new ArrayList<>();

    // Constructor vacío
    public ParqueaderoService() {
    	this.nombre = "";
        this.direccion = "";
        this.representante = "";
        this.contacto = "";
        this.espaciosDisponibles =new HashMap<>();;
        this.clientes = new ArrayList<>();
    }

    // Constructor con parámetros
    public ParqueaderoService(String nombre, String direccion, String representante, String contacto, Map<String, Integer> espaciosDisponibles, List<Cliente> clientes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.representante = representante;
        this.contacto = contacto;
        this.espaciosDisponibles = espaciosDisponibles;
        this.clientes = clientes;
    }

    // Getters
    public String getNombre() { 
    	return nombre; 
    }
    public String getDireccion() { 
    	return direccion;
    }
    public String getRepresentante() { 
    	return representante; 
    }
    public String getContacto() { 
    	return contacto;
    }
    public Map<String, Integer> getEspaciosDisponibles() { 
    	return espaciosDisponibles;
    }
    public List<Cliente> getClientes() {
    	return clientes;
    }

    // Setters
    public void setNombre(String nombre) { 
    	this.nombre = nombre;
    }
    public void setDireccion(String direccion) {
    	this.direccion = direccion;
    }
    public void setRepresentante(String representante) {
    	this.representante = representante;
    }
    public void setContacto(String contacto) {
    	this.contacto = contacto;
    }
    public void setEspaciosDisponibles(Map<String, Integer> espaciosDisponibles) {
        this.espaciosDisponibles = espaciosDisponibles;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // metodos
    
//    registrar Cliente
    public void registrarCliente(Cliente cliente) {
    	clientes.add(cliente);
    }
    
//	eliminar Cliente
    public void eliminarCliente(String cedula) {
    	boolean validacion = false;
    	for (int i = 0; i < clientes.size(); i++) {
    		if(clientes.get(i).getCedula().equals(cedula)) {
    			clientes.remove(i);
    			validacion = true;
    			break;
    		} 	
    	}
    	if (validacion) {
    		JOptionPane.showMessageDialog(null, "Eliminación correcta." );
    	} else {
    		JOptionPane.showMessageDialog(null, "No existe un cliente con esa cédula." );		    		
    	}
    }

//  buscar Cliente  
    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    
//  actualizar Cliente 
    public boolean actualizarCliente(Cliente clienteActualizado) {
    	boolean verificacion = false;
    	for (Cliente c : clientes) {
    		if(c.getCedula().equals(clienteActualizado.getCedula())) {
				
				c.setNombre(clienteActualizado.getNombre());
				c.setTelefono(clienteActualizado.getTelefono());
				c.setCorreo(clienteActualizado.getCorreo());
				
				verificacion = true;
				break;
			}
		
    	}
    	return verificacion;
    	
    }
    
//  ver Vehiculos Cliente  
    public List<Vehiculo> verVehiculosCliente(String cedula) {
        Cliente cliente = buscarCliente(cedula);
        if (cliente != null) {
            return cliente.getVehiculos();
        }
        return Collections.emptyList();
    }


    /* class IngresoSalida
     
     private String placa;
	private String tipoVehiculo;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSalida;
	private double valorCalculado;*/
    
//  registrar Ingreso
    public void registrarIngreso(Vehiculo vehiculo) {
    	
    }

//  registrar Salida
    public void registrarSalida(String placa) {
    	
    }

    public double calcularMonto(Vehiculo vehiculo, int horas) {
        return 0;
    }

    public Factura generarFactura(Vehiculo vehiculo) {
        return null;
    }

    public List<IngresoSalida> consultarHistorialCliente(String cedula) {
        return null;
    }

    public double calcularGanancias(LocalDate fechaInicio, LocalDate fechaFin) {
        return 0;
    }

    
//  listar Vehiculos Actuales  
    public List<Vehiculo> listarVehiculosActuales() {
        
    	return null; // listVehiculosActuales;
    }
}
