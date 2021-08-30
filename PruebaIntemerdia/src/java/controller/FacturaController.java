package controller;

import conexion.Conexion;
import dao.FacturaDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Factura;

public class FacturaController {

    public static void main(String[] args) throws ParseException {
        Scanner teclado = new Scanner(System.in);
        Factura fac = new Factura();
        Conexion conn = new Conexion();
        FacturaDao fd = new FacturaDao(conn);

        //Solicitamos los datos a insertar
        System.out.println("\tDatos para generar la factura");
        System.out.println("\t-------------------------------");
        System.out.println("Ingrese el nombre del cliente: ");
        fac.setNombre(teclado.next());
        System.out.println("Ingrese el numero de factura: ");
        fac.setNumf(teclado.nextInt());
        System.out.println("Ingrese la fecha de vencimiento YYYY-MM-DD: ");
        String date1 = teclado.next();
        Date datef = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
        fac.setFecha_vencimiento(datef);
        //Validando formato de fecha

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date testDate = null;
        String date = date1;
        try {
            testDate = df.parse(date);
        } catch (Exception e) {
            System.out.println("Formato no válido");
        }
        if (!df.format(testDate).equals(date)) {
            System.out.println("Fecha inválida!");
        }
        //Fin validacion formato de fecha
        System.out.println("Ingrese la marca del auto: ");
        fac.setMarca(teclado.next());
        System.out.println("Ingrese el modelo del auto: ");
        fac.setModelo(teclado.next());
        System.out.println("Descripcion del arreglo al auto: ");
        fac.setDescripcion(teclado.next());
        //Hacemos la inserción en la BD
        boolean respuesta = fd.insertar(fac);
        //Válidamos si se hizo la insercción de los datos
        if (respuesta) {
            System.out.println("\n¡Registro guardado!");
        } else {
            System.out.println("\n¡Error, registro no guardado!");
        }

        // Recorremos los registros de la tabla y los mostramos
        for (Factura fac1 : fd.selectAll()) {
            System.out.println("N° Registro: " + fac1.getId_factura());
            System.out.println("Nombre del cliente: " + fac1.getNombre());
            System.out.println("Número de Factura: " + fac1.getNumf());
            System.out.println("Fecha de Vencimiento: " + fac1.getFechadeVencimiento());
            System.out.println("Marca del auto: " + fac1.getMarca());
            System.out.println("Modelo del auto: " + fac1.getModelo());
            System.out.println("Descripcion del arreglo al auto: " + fac1.getDescripcion());
            System.out.println("--------------------------------\n");
        }

    }

}
