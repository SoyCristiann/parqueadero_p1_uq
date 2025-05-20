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
    private ArrayList<IngresoSalida> registrosActivos = new ArrayList<>();
    private ArrayList<IngresoSalida> historial = new ArrayList<>();


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
    public ParqueaderoService(String nombre, String direccion, String representante, String contacto,
    		ArrayList<String> espaciosDisponibles, ArrayList<Cliente> clientes) {
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
    public void registrarCliente(Cliente cliente) {
    	clientes.add(cliente);
    }
    
//	eliminar Cliente
    public boolean eliminarCliente(String cedula) {
    	Cliente c = buscarCliente(cedula);
    	if (c != null) {
    		clientes.remove(c);
    		return true;
    	}
    	return false;
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
    	Cliente c = buscarCliente(clienteActualizado.getCedula());
    	if (c != null) {			
    			c.setNombre(clienteActualizado.getNombre());
    			c.setTelefono(clienteActualizado.getTelefono());
    			c.setCorreo(clienteActualizado.getCorreo());
    			// para modificar la cedula es un metodo aparte
    			return true;
    	}
    	
    	return false;	
    }
    
//  ver Vehiculos Cliente  
    public List<Vehiculo> verVehiculosCliente(String cedula) {
        Cliente cliente = buscarCliente(cedula);
        if (cliente != null) {
            return cliente.getVehiculos();
        }
        return Collections.emptyList();
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
    public boolean registrarIngreso(String placa, String tipoVehiculo, LocalDateTime horaEntrada) {
        // Verificar si ya está registrado
        for (IngresoSalida ingresoExistente : registrosActivos) {
            if (ingresoExistente.getPlaca().equalsIgnoreCase(placa) &&
                ingresoExistente.getHoraSalida() == null) {
                System.out.println("El vehículo ya está registrado y no ha salido.");
                return false; // Salir sin registrar
            }
        }

        // Si no está, registrar nuevo ingreso
        IngresoSalida ingreso = new IngresoSalida();
        ingreso.setPlaca(placa);
        ingreso.setTipoVehiculo(tipoVehiculo);
        ingreso.setHoraEntrada(LocalDateTime.now());
        ingreso.setHoraSalida(null); 
        registrosActivos.add(ingreso);
        return true;
    }


//  registrar Salida
    public void registrarSalida(String placa) {
        IngresoSalida ingreso = null; //  aún no se sabe si existe un IngresoSalida con esa placa
        for (IngresoSalida r : registrosActivos) {
            if (r.getPlaca().equalsIgnoreCase(placa)) {
                ingreso = r;
                break;
            }
        }
    } // aun no esta terminado


    public double calcularMonto(String tipoVehiculo, long horas) {
        /* long horas = java.time.Duration.between(ingreso.getHoraEntrada(), ingreso.getHoraSalida()).toHours();
            double monto = calcularMonto(ingreso.getTipoVehiculo(), horas);
            ingreso.setValorCalculado(monto);

            historial.add(ingreso);
            registrosActivos.remove(ingreso);*/
    	return 0;
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
