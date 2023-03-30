package modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {
	
	String user;
	String port;
	String hostname;
	String conector;
	String database;
	String password;
	String url;
	Connection con;
	/**
	 * @param user
	 * @param port
	 * @param hostname
	 * @param conector
	 * @param database
	 * @param password
	 * @param url
	 */
	public Conexion(String user, String port, String hostname, String conector, String database, String password,
			String url) {
		super();
		this.user = user;
		this.port = port;
		this.hostname = hostname;
		this.conector = conector;
		this.database = database;
		this.password = password;
		this.url = url;
	}

	
	public Connection AbrirConexion() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		this.con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
		return this.con;
	}
	
	public void CerrarConexion() throws SQLException {
		this.con.close();
	}
}
	


