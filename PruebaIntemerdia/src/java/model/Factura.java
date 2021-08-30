package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int id_factura;
    private String nombre;
    private int numf;
    private Date fecha_vencimiento;
    private String marca;
    private String modelo;
    private String descripcion;

    public Factura() {

    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumf() {
        return numf;
    }

    public void setNumf(int numf) {
        this.numf = numf;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Factura(int id_factura, String nombre, int numf, String fecha_vencimiento, String marca, String modelo, String descripcion) {
        this.id_factura = id_factura;
        this.nombre = nombre;
        this.numf = numf;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        try {
            this.fecha_vencimiento = new SimpleDateFormat("dd-MM-yyyy").parse(fecha_vencimiento);
        } catch (Exception ex) {
            System.out.println("ERROR");
        }
    }

    public Factura(int id_factura, String nombre, int numf, Date fecha_vencimiento, String marca, String modelo, String descripcion) {
        this.id_factura = id_factura;
        this.nombre = nombre;
        this.numf = numf;
        this.fecha_vencimiento = fecha_vencimiento;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;

    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        try {
            this.fecha_vencimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_vencimiento);
        } catch (Exception ex) {
            System.out.println("ERRROR");
        }
    }

    public String getFechadeVencimiento() {
        String fechaV = "";
        String formato = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(formato);
        fechaV = df.format(this.getFecha_vencimiento());
        return fechaV;
    }

    public Factura(int id_factura) {
        this.id_factura = id_factura;
    }

}
