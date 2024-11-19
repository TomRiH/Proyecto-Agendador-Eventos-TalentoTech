package model;
import java.sql.*;

public abstract class Crud_db {
    protected Conexion cone = new Conexion();
    protected Connection connection;

    public Crud_db() throws SQLException{
        this.connection = cone.conectar();
    }

    // Método para cerrar la conexión
    public void cerrarConexion() throws SQLException{
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Conexión cerrada.");
        }
    }

    // Método para ejecutar consultas (select)
    protected ResultSet executeSql(String query, Object... params) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        setParameters(ps, params);
        return ps.executeQuery();
    }

    // Método para ejecutar operaciones de modificación (insertar,editar,borrar)
    protected int executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        setParameters(ps, params);
        return ps.executeUpdate();
    }

    // Método para establecer los parámetros en el PreparedStatement
    private void setParameters(PreparedStatement ps, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
    }
}

