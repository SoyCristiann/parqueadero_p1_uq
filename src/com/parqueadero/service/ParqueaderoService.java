package com.parqueadero.service;

import com.parqueadero.model.Cliente;
import com.parqueadero.model.Factura;
import com.parqueadero.model.IngresoSalida;
import com.parqueadero.model.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParqueaderoService {

    // Atributos según el UML
    private String nombre;
    private String direccion;
    private String representante;
    private String contacto;
    private Map<String, Integer> espaciosDisponibles;
    private List<Cliente> clientes = new ArrayList<>();

    // Constructor vacío
    public ParqueaderoService() {}

    // Constructor con parámetros
    public ParqueaderoService(String nombre, String direccion, String representante, String contacto,
                              Map<String, Integer> espaciosDisponibles, List<Cliente> clientes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.representante = representante;
        this.contacto = contacto;
        this.espaciosDisponibles = espaciosDisponibles;
        this.clientes = clientes;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getRepresentante() { return representante; }
    public String getContacto() { return contacto; }
    public Map<String, Integer> getEspaciosDisponibles() { return espaciosDisponibles; }
    public List<Cliente> getClientes() { return clientes; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setRepresentante(String representante) { this.representante = representante; }
    public void setContacto(String contacto) { this.contacto = contacto; }
    public void setEspaciosDisponibles(Map<String, Integer> espaciosDisponibles) {
        this.espaciosDisponibles = espaciosDisponibles;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // metodos
    
//    registrar Cliente
    public void registrarCliente(Cliente cliente) {
    	
    }
    
//	eliminar Cliente
    public void eliminarCliente(String cedula) {
    	
    }

//  buscar Cliente  
    public Cliente buscarCliente(String cedula) {
        
    	return null; // cliente;
    }
    
//  actualizar Cliente 
    public void actualizarCliente(Cliente cliente) {
    	
    }

//  ver Vehiculos Cliente  
    public List<Vehiculo> verVehiculosCliente(String cedula) {
        
    	return null; // vehiculos;
    }

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
