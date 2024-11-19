import model.Conexion;

import model.Rol;
import model.rol_db;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.Permiso_db;
import model.Permiso;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        rol_db r_db = new rol_db();
        Permiso_db permisoBD = new Permiso_db();
        Scanner scanner = new Scanner(System.in);

        System.out.println("------SISTEMA CRUD BASE DE DATOS EVENTOS------");
        System.out.println("Selecciona una opcion: ");
        System.out.println("");

        System.out.println("1. Operaciones de la tabla rol");
        System.out.println("2. Operaciones de la tabla permiso");
        System.out.println("3. Salir del programa");

        int decisionOperation = scanner.nextInt();
        scanner.nextLine();

        switch (decisionOperation) {
            case 1 :
                // operaciones con la tabla rol
                rolOperaciones(r_db);
                scanner.close();
                break;

            case 2 :
                // operaciones con la tabla permiso
                permisoOperaciones(permisoBD);
                scanner.close();
                break;

            case 3 :
                System.out.println("Usted ha salido del sistema ");
                System.exit(0);
                break;

            default:
                if (decisionOperation < 1 || decisionOperation > 3) {
                    System.out.println("Opcion no valida. Por favor, ingrese un  numero del 1 al 3.");
                }
                break;
        }

    }

    private static void rolOperaciones(rol_db r_db) {
        Scanner scanner = new Scanner(System.in);
        //Crear variable Timestamp para agregar fecha actual
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        int decisionUsuario;

        do {
            System.out.println("------SISTEMA CRUD BASE DE DATOS EVENTOS------");
            System.out.println("1. Probar Conexion con base de datos");
            System.out.println("2. Insertar Dato");
            System.out.println("3. Actualizar Datos");
            System.out.println("4. Borrar Datos");
            System.out.println("5. Leer Datos");
            System.out.println("6. Salir del programa");

            decisionUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (decisionUsuario) {
                case 1:
                    //INSERT
                    Rol rolObj = new Rol("Admin",currentTimestamp,null);
                    //Instanciar rol_db arriba
                    r_db.CreateRole(rolObj);

                    break;

                case 2:
                    //UPDATE
                    Rol rolObjUpd = new Rol(1,"Admin",null,currentTimestamp);
                    //Instanciar rol_db arriba
                    r_db.UpdateRole(rolObjUpd);


                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6 :
                    System.out.println("Usted ha salido del sistema ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Por favor ingrese un  numero del 1 al 6");
            }

        }
        while (decisionUsuario != 6);

        scanner.close();
    }

    private static void permisoOperaciones(Permiso_db permiso_db) throws SQLException {
        System.out.println("-----------------------------------");
        System.out.println("Operaciones de la tabla permiso");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        // Crear un permiso
        System.out.println("Crear un nuevo permiso");
        System.out.println("Ingrese el nombre del permiso:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la descripción del permiso:");
        String descripcion = scanner.nextLine();
        Permiso nuevoPermiso = new Permiso(nombre, descripcion);
        permiso_db.crearPermiso(nuevoPermiso);

        // Editar un permiso
        System.out.println("");
        System.out.println("Editar un permiso");
        System.out.println("Ingrese el ID del permiso que desea editar :");
        int id = scanner.nextInt();
        Permiso permisoLeido = permiso_db.leerPermiso(id);
        System.out.println(permisoLeido);
        scanner.nextLine();
        System.out.println("Ingrese el nuevo nombre del permiso:");
        permisoLeido.setNombre(scanner.nextLine());
        System.out.println("Ingrese la nueva descripción del permiso:");
        permisoLeido.setDescripcion(scanner.nextLine());
        permiso_db.editarPermiso(permisoLeido);

        // Eliminar un permiso
        System.out.println("");
        System.out.println("Eliminar un permiso");
        System.out.println("Ingrese el ID del permiso a eliminar:");
        int idEliminar = scanner.nextInt();
        permiso_db.deletePermiso(idEliminar);

        // Mostrar todos los permisos
        System.out.println("");
        List<Permiso> permisos = permiso_db.getAllPermisos();
        System.out.println("Lista de permisos:");
        for (Permiso p : permisos) {
            System.out.println(p);
        }

        permiso_db.cerrarConexion();
        scanner.close();
    }
}