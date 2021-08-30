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
        //insert into factura values ("1","Andres", "23500", "2011-02-21", "Hyundai", "Accent", "Bujías sin punta");
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

            if (lista.size() > 0) {
                System.out.println("Lista llena");
            }
            conexion.desconectar();
            return lista;            
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            return null;
        }  

    }

}

/* public boolean actualizar(Factura fac) {
        boolean flag = false;
        String sql = "UPDATE `factura` SET `nombre` = ?, `numf` = ?, `fecha_vencimiento` = ?, `marca` = ?, `modelo` = ?, `descripcion` = ? WHERE (`id_factura` = ?);";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setString(1, fac.getNombre());
            ps.setInt(2, fac.getNumf());
            ps.setString(3, fac.getFechadeVencimiento());
            ps.setString(4, fac.getMarca());
            ps.setString(5, fac.getModelo());
            ps.setString(6, fac.getDescripcion());
            ps.setInt(7, fac.getId_factura());

            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Registro actualizado");
            } else {
                System.out.println("Error al actualizar");
            }
            conexion.desconectar();

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return flag;
    }

    public boolean eliminar(int id_factura) {
        boolean flag = false;
        String sql = "DELETE FROM `factura` WHERE (`id` = ?);";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id_factura);
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Registro eliminado");
            } else {
                System.out.println("Error al eliminar");
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return flag;
    }

    public List<Factura> selectById(int id_factura) {
        String sql = "select * from factura where id_factura = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_factura);
            ResultSet rs = ps.executeQuery();
            Factura fc;

            List<Factura> lista = new LinkedList<>();
            while (rs.next()) {
                fc = new Factura(rs.getInt("id"));
                fc.setNombre(rs.getString("Nombre"));
                fc.setNumf(rs.getInt("Numero de factura"));
                fc.setFecha_vencimiento(rs.getDate("Fecha de Vencimiento"));
                fc.setMarca(rs.getString("Marca"));
                fc.setModelo(rs.getString("Modelo"));
                fc.setDescripcion(rs.getString("Descripcion"));
                lista.add(fc);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }*/
