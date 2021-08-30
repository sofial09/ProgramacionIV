package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static String bd = "PIntermedia";
    private static String user = "root";
    private static String pass = "";
    private static String url = "jdbc:mysql://localhost:3306/" + bd;

    Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void Conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, pass);
            if (this.conn != null) {
                System.out.println("Conexión exitosa");
            } else {
                System.out.println("Error al conectar");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void Desconectar() throws Exception {
        try {
            if (this.conn != null) {
                if (this.conn.isClosed() != true) {
                    this.conn.close();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
