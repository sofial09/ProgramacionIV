package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    static String bd = "PIntermedia";
    static String user = "root";
    static String pass = "";
    static String url = "jdbc:mysql://localhost:3306/" + bd;

    Connection conn = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Exito en la conexion");
            }
        } catch (Exception e) {
            System.out.println("Error en la Conexion " + e);
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        System.out.println("Desconectado");
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("ERROR AL CERRAR LA CONEXION : " + e);
        }
    }
}
