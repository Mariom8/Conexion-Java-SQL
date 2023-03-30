package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Conexion;

public class ClienteController implements ClienteDAO {

	public final String SELECT_ALL = "SELECT * FROM Cliente";
	public final String SELECT_BY_ID_CLIENTE = "SELECT * FROM Cliente WHERE id_cliente = ?";
	public final String SELECT_BY_ID_RESPONSABLE = "SELECT * FROM Cliente WHERE id_responsable = ?";
	public final String INSERT_CLIENTE = "INSERT INTO Cliente VALUES (?, ?, ?, ?, ?)";
	public final String UPDATE_NOMBRE_BY_ID_CLIENTE = "UPDATE Cliente SET nombre = ? WHERE id_cliente = ?";
	public final String DELETE_CLIENTE_BY_ID_CLIENTE = "DELETE FROM Cliente WHERE id_cliente = ?";

	private Connection con;

	public ClienteController() {
		Conexion conector = new Conexion("root", "3306", "127.0.0.1", "jdbc:mysql", "tienda", "",
				"jdbc:mysql://127.0.0.1:3306/tienda");
		try {
			this.con = conector.AbrirConexion();
		} catch (Exception e) {
			e.printStackTrace();
			this.con = null;
		}
	}

	@Override
	public ArrayList<Cliente> SelectAll() {

		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery(SELECT_ALL);

			while (rs.next()) {
				Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				clientes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			clientes = null;
		}

		return clientes;
	}

	@Override
	public Cliente SelectByIdCliente(int idCliente) {

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(SELECT_BY_ID_CLIENTE);
			ps.setInt(1, idCliente);
			ResultSet rs = (ResultSet) ps.executeQuery();
			rs.next();
			Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ArrayList<Cliente> SelectByIdResponsable(int idResponsable) {

		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(SELECT_BY_ID_RESPONSABLE);
			ps.setInt(1, idResponsable);
			ResultSet rs = (ResultSet) ps.executeQuery();
			//rs.next();
			while (rs.next()) {
				Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				clientes.add(c);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean InsertCliente(int idCliente, String nombre, String direccion, int telefono, int idResponsable) {
		
		 try {
	            PreparedStatement ps = (PreparedStatement) con.prepareStatement(INSERT_CLIENTE);
	            ps.setInt(1, idCliente);
	            ps.setString(2, nombre);
	            ps.setString(3, direccion);
	            ps.setInt(4, telefono);
	            ps.setInt(5, idResponsable);
	            ps.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
		
	}

	@Override
	public boolean UpdateCliente(int idCliente, String nombre) {
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(UPDATE_NOMBRE_BY_ID_CLIENTE);
			ps.setString(1, nombre);
			ps.setInt(2, idCliente);
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean DeleteCliente(int idCliente) {
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(DELETE_CLIENTE_BY_ID_CLIENTE);
			ps.setInt(1, idCliente);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}

}
