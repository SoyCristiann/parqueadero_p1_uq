package com.parqueadero.utils;

import javax.swing.JOptionPane;

public class Menu {
	
	public static byte seleccionarMenuPrincipal() {
		StringBuilder menu= new StringBuilder();
		menu.append("====== MENÚ PRINCIPAL ======\n");
		menu.append("1: Registrar ingreso rápido de vehículo.\n");
		menu.append("2: Registrar salida rápida de vehículo.\n");
		menu.append("3: Módulo clientes.\n");
		menu.append("4: Módulo vehículos.\n");
		menu.append("5: Módulo Membresías.\n");
		
		String opcion = JOptionPane.showInputDialog(null, menu.toString(), "Seleccione una opción:", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("Opción seleccionada en el menú principal: " + opcion);
        
		//Validaciones
		if (opcion == null || opcion.isBlank()) {
            return 0; // Si presiona Cancel o X
        }

        try {
            return Byte.parseByte(opcion.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
            return 0;
        }
	}
	
	//Submenu clientes
	public static byte seleccioanrMenuClientes() {
		StringBuilder menu= new StringBuilder();
		menu.append("====== MENÚ CLIENTES ======\n");
		menu.append("1: Buscar un cliente.\n");
		menu.append("2: Registrar nuevo cliente.\n");
		menu.append("3: Editar cliente.\n");
		menu.append("4: Eliminar cliente.\n");
		menu.append("5: Menú principal.\n");
		
		String opcion = JOptionPane.showInputDialog(null, menu.toString(), "Seleccione una opción:", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("Opción seleccionada en el menú clientes: " + opcion);
        
		//Validaciones
		if (opcion == null || opcion.isBlank()) {
            return 0; // Si presiona Cancel o X
        }

        try {
            return Byte.parseByte(opcion.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
            return 0;
        }
	}
	
	
	//Submenu vehículos
		public static byte seleccioanrMenuVehiculos() {
			StringBuilder menu= new StringBuilder();
			menu.append("====== MENÚ VEHICULOS ======\n");
			menu.append("1: Ver vehiculos registrados.\n");
			menu.append("2: Registrar nuevo vehiculo.\n");
			menu.append("3: Editar vehiculo.\n");
			menu.append("4: Eliminar vehiculo.\n");
			menu.append("5: Menú principal.\n");
			
			String opcion = JOptionPane.showInputDialog(null, menu.toString(), "Seleccione una opción:", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Opción seleccionada en el menú vehículos: " + opcion);
	        
			//Validaciones
			if (opcion == null || opcion.isBlank()) {
	            return 0; // Si presiona Cancel o X
	        }

	        try {
	            return Byte.parseByte(opcion.trim());
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Entrada inválida.");
	            return 0;
	        }
		}
		
		
		//Submenu membresías
				public static byte seleccioanrMenuMembresias() {
					StringBuilder menu= new StringBuilder();
					menu.append("====== MENÚ Membresías ======\n");
					menu.append("1: Ver membresías vigentes.\n");
					menu.append("2: Crear nueva membresía.\n");
					menu.append("3: Editar membresía.\n");
					menu.append("4: Eliminar membresía.\n");
					menu.append("5: Menú principal.\n");
					
					String opcion = JOptionPane.showInputDialog(null, menu.toString(), "Seleccione una opción:", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Opción seleccionada en el menú membresías: " + opcion);
			        
					//Validaciones
					if (opcion == null || opcion.isBlank()) {
			            return 0; // Si presiona Cancel o X
			        }

			        try {
			            return Byte.parseByte(opcion.trim());
			        } catch (NumberFormatException e) {
			            JOptionPane.showMessageDialog(null, "Entrada inválida.");
			            return 0;
			        }
				}

	
	
}
