package model;

import java.sql.*;

public class rol_db {
    Conexion cone = new Conexion();
    Connection connection = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet res = null;

    public void CreateRole(Rol rol) {
        String sqlInsertRol = "Insert INTO rol (nombre, fecha_creacion, fecha_modificacion) VALUES (?,?,?)";
        Boolean resultado = false;
        try{
            connection = cone.conectar();
            ps = connection.prepareStatement(sqlInsertRol);
            ps.setString(1,rol.getNombre());
            ps.setTimestamp(2,rol.getFecha_creacion());
            ps.setTimestamp(3,rol.getFecha_modificacion());
            resultado = ps.executeUpdate()>0;

        } catch (SQLException e) {
            System.out.println("No se escribio en la table " + e);
        }

    }

    public void UpdateRole(Rol rol){
        String sqlUpdateRol = "UPDATE rol SET nombre = ?,fecha_modificacion = ? WHERE id = ? ";
        Boolean resultado = false;
        try {
            connection = cone.conectar();
            ps = connection.prepareStatement(sqlUpdateRol);
            ps.setString(1,rol.getNombre());
            ps.setTimestamp(2,rol.getFecha_modificacion());
            ps.setInt(3,rol.getId());
            resultado = ps.executeUpdate()>0;

        } catch (Exception e) {
            System.out.println("No se actualizo en la tabla " + e);
        }

    }






}
