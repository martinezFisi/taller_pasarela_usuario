package pe.edu.sistemas.microservices.conexion;

import java.sql.Connection;

public interface ConexionInterface {
	public Connection getConnection();
}
