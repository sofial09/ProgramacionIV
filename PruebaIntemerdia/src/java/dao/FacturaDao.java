package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Factura;

public class FacturaDao {

    Conexion conn;

    public FacturaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(Factura fac) {
        boolean flag = false;
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO factura(id_factura,nombre,numf,fecha_vencimiento,marca,modelo,descripcion) "
                + "VALUES (?,?,?,?,?,?,?);";
       
        try {
            fac.setDescripcion("...");
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setInt(1, fac.getId_factura());
            ps.setString(2, fac.getNombre());
            ps.setInt(3, fac.getNumf());
            ps.setString(4, fac.getFechadeVencimiento());
            ps.setString(5, fac.getMarca());
            ps.setString(6, fac.getModelo());
            ps.setString(7, fac.getDescripcion());

            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Se ha registrado correctamente");
            } else {
                System.out.println("Error en el registro");
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
        return flag;
    }

    public List<Factura> selectAll() {
        List<Factura> lista = new LinkedList<Factura>();
        String sql = "SELECT * FROM factura;";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Factura fc;
            while (rs.next()) {
                fc = new Factura(rs.getInt("id_factura"));
                fc.setNombre(rs.getString("nombre"));
                fc.setNumf(rs.getInt("numf"));
                fc.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
                fc.setMarca(rs.getString("marca"));
                fc.setModelo(rs.getString("modelo"));
                fc.setDescripcion(rs.getString("descripcion"));
                lista.add(fc);
            }

            return lista;
        } catch (Exception e) {
            return null;
        }
    }

}

