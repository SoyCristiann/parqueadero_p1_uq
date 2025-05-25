package com.parqueadero.utils;
import javax.swing.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
/*
 * Se crea esta clase para manejar la funcionalidad de selector de fecha.
 * */

public abstract class SelectorFecha {	
	
	    public static LocalDate seleccionarFecha() {
	        JSpinner spinner = new JSpinner(new SpinnerDateModel());
	        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
	        spinner.setEditor(editor);
	        JOptionPane.showMessageDialog(null, spinner, "Seleccione una fecha", JOptionPane.PLAIN_MESSAGE);
	        Date fechaSeleccionada= (Date) spinner.getValue();
	        return fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();	        
    }
	    
	    //Validar si una fecha es igual o superior a a actual. Retorna falso si la fecha es en el pasado.
	    public static boolean validarFechaVigente(LocalDate fecha) {
	    	if(fecha.isAfter(LocalDate.now()) || fecha.isEqual(LocalDate.now())) {
	    		return true; //Fecha válida
	    	}else {
	    		JOptionPane.showMessageDialog(null, "La fecha no puede estar en el pasado.");
	    		return false; //Fecha inválida
	    	}
	    }
}
