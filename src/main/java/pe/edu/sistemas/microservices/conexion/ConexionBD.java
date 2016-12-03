package pe.edu.sistemas.microservices.conexion;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConexionBD {

	public DriverManagerDataSource ConexionBD(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/pasarelabd");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
        
	}
}
