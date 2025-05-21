package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConnection() {
        Connection conexion = null;
        String baseDatos = "inventario_db";
        String url = "jdbc:mysql://localhost:3306/" + baseDatos;
        String usuario = "root";
        String password = "Dinosaurio02";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }
        catch(Exception e){
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        Connection conexion = Conexion.getConnection();
        if (conexion != null) {
            System.out.println("conexion establecida"+conexion);
        }
        else {
            System.out.println("conexion no establecida");
        }
    }
}
