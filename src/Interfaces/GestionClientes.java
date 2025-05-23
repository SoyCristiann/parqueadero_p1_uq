package Interfaces;
import com.parqueadero.model.Cliente;

public interface GestionClientes {
	 boolean registrarCliente(Cliente cliente);
	 boolean eliminarCliente(String cedula);
	 Cliente buscarCliente(String cedula);
}
