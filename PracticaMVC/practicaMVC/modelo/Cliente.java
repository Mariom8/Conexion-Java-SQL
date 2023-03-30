package modelo;

public class Cliente {
	
	int idCliente;
	String nombre;
	String direccion;
	int telefono;
	int idResponsable;

	
	public Cliente(int idCliente, String nombre, String direccion, int telefono, int idResponsable ) {
		
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.idResponsable = idResponsable;
		
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public int getIdResponsable() {
		return idResponsable;
	}


	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", idResponsable=" + idResponsable + "]";
	}
	
	
}
