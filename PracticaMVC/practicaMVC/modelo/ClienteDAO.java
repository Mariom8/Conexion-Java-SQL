package modelo;

import java.util.ArrayList;


	public interface ClienteDAO {
	    public ArrayList<Cliente> SelectAll();
	    public Cliente SelectByIdCliente(int idCliente);
	    public ArrayList<Cliente> SelectByIdResponsable(int idResponsable);
	    public boolean InsertCliente(int idCliente, String nombre, String direccion, int telefono,int idResponsable);
	    public boolean UpdateCliente(int idCliente, String nombre);
	    public boolean DeleteCliente(int idCliente);

	
}


