package com.parqueadero.utils;
import javax.swing.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
/*
 * Se crea esta clase para manejar la funcionalidad de selector de fecha.
 * */

public class SelectorFecha {	
	
	    public static LocalDate seleccionarFecha() {
	        JSpinner spinner = new JSpinner(new SpinnerDateModel());
	        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
	        spinner.setEditor(editor);
	        JOptionPane.showMessageDialog(null, spinner, "Seleccione una fecha", JOptionPane.PLAIN_MESSAGE);
	        Date fechaSeleccionada= (Date) spinner.getValue();
	        return fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();	        
    }
}
