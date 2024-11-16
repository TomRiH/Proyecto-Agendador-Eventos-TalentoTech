import model.Conexion;
import model.Rol;
import model.rol_db;
import java.util.Scanner;

import java.sql.SQLException;
import java.sql.Timestamp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

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
            rol_db r_db = new rol_db();

            switch (decisionUsuario) {

                case 1:
                    Conexion pruebaConexion = new Conexion();
                    pruebaConexion.conectar();
                    break;

                case 2:
                    //INSERT
                    Rol rolObj = new Rol("Admin",currentTimestamp,null);
                    //Instanciar rol_db arriba
                    r_db.CreateRole(rolObj);

                    break;

                case 3:
                    //UPDATE
                    Rol rolObjUpd = new Rol(1,"Admin",null,currentTimestamp);
                    //Instanciar rol_db arriba
                    r_db.UpdateRole(rolObjUpd);


                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                default:
                    System.out.println("Por favor ingrese un  numero del 1 al 6");
            }

        }
        while (decisionUsuario != 6);

        scanner.close();
    }
}