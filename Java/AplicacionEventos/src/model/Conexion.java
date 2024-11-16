package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String db="proyecto_eventos"; //nombre de bases de datos
    private String url="jdbc:mysql://localhost:3306/" + db;
    private String user="root";
    private String password="Greatwolflodge1919";
    Connection connect = null;

    public Connection conectar() throws SQLException{
        try {
            connect = DriverManager.getConnection(url,user,password);
            System.out.println("conexion ok");
        } catch (SQLException e){
            System.out.println("Error en conexion " + e);
        }
        return connect;
    }
}
