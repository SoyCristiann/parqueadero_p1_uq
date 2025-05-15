package com.proyectoParqueadero;

import com.parqueadero.model.Cliente;
import com.parqueadero.service.ParqueaderoService;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de prueba
        Cliente cliente = new Cliente("Juan", "1234567890", null, null, null);
        System.out.println("Cliente creado: " + cliente.getNombre());

        ParqueaderoService servicio = new ParqueaderoService();
        
        
//      espacio para llamar metodos para probar funcionamiento
        
        
        
        
        
    }
}
