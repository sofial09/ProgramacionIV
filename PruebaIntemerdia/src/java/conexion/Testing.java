package conexion;

public class Testing {

    public static void main(String[] args) {
        Conexion conn = new Conexion();

        conn.conectar();
        conn.desconectar();

    }
}
