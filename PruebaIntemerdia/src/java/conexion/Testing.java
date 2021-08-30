package conexion;

public class Testing {

    public static void main(String[] args) {
        try {
            Conexion cn = new Conexion();
            cn.Conectar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
