package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Permiso_db extends Crud_db {

    public Permiso_db() throws SQLException {}

    // Método para crear un permiso
    public void crearPermiso(Permiso permiso) {
        String sql = "INSERT INTO permiso (nombre, descripcion) VALUES (?, ?)";
        try {
            executeUpdate(sql, permiso.getNombre(), permiso.getDescripcion());
            System.out.println("Permiso creado con éxito");
        } catch (SQLException error) {
            System.out.println("Error al crear el permiso: " + error);
        }
    }

    // Método para leer un permiso por ID
    public Permiso leerPermiso(int id) {
        String sql = "SELECT * FROM permiso WHERE id = ?";
        try {
            ResultSet result = executeSql(sql, id);
            if (result.next()) {
                return new Permiso(
                        result.getInt("id"),
                        result.getString("nombre"),
                        result.getString("descripcion")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al leer el permiso: " + e.getMessage());
        }
        return null;
    }

    // Método para editar un permiso
    public void editarPermiso(Permiso permiso) {
        String sql = "UPDATE permiso SET nombre = ?, descripcion = ? WHERE id = ?";
        try {
            executeUpdate(sql, permiso.getNombre(), permiso.getDescripcion(), permiso.getId());
            System.out.println("Permiso actualizado con éxito.");
        } catch (SQLException error) {
            System.out.println("Error al actualizar el permiso: " + error);
        }
    }

    // Método para eliminar un permiso
    public void deletePermiso(int id) {
        String sql = "DELETE FROM permiso WHERE id = ?";
        try {
            executeUpdate(sql, id);
            System.out.println("Permiso eliminado con éxito");
        } catch (SQLException error) {
            System.out.println("Error al eliminar el permiso: " + error);
        }
    }

    // Método para obtener todos los permisos
    public List<Permiso> getAllPermisos() {
        List<Permiso> permisos = new ArrayList<>();
        String sql = "SELECT * FROM permiso";
        try (ResultSet rs = executeSql(sql)) {
            while (rs.next()) {
                permisos.add(new Permiso(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todos los permisos: " + e.getMessage());
        }
        return permisos;
    }

}

