package View;

import Controller.Impuestos;
import Model.Usuario;
import Model.Ingreso;
import Model.Tipo_Factura;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ImpuestosView {
    public void mostrarDeclaracion(Usuario usuario) {
        Impuestos controller = new Impuestos(usuario);
        double impuestos = controller.calcularImpuestos();
        double sueldoAnual = 0;
        double totalDeducciones = 0; // Variable para el total de deducciones

        try (PrintWriter writer = new PrintWriter(new FileWriter("declaracion_impuestos.csv"))) {
            writer.println("Sueldos Mensuales:");
            for (Ingreso ingreso : usuario.getIngresos()) {
                writer.println(" - " + ingreso.getSueldoMensual());
                sueldoAnual += ingreso.getSueldoMensual();
            }
            sueldoAnual *= 12;
            writer.println("Sueldo Anual: " + sueldoAnual);

            writer.println("Facturas:");
            for (Tipo_Factura factura : usuario.getFacturas()) {
                writer.println("Categoria: " + factura.getClass().getSimpleName() + 
                               ", Monto: " + factura.getMonto() +
                               ", Fecha: " + factura.getFecha() +
                               ", Monto Maximo Deducible: " + factura.getMontoMaximo());
                totalDeducciones += factura.getMontoMaximo(); // Acumula el total de deducciones
            }
            
            writer.println("Total de Deducciones: " + totalDeducciones); // Imprime el total de deducciones
            
            writer.println("Declaracion de Impuestos");
            writer.println("Nombre: " + usuario.getNombre());
            writer.println("DNI: " + usuario.getDni());
            writer.println("Impuestos a pagar: " + impuestos);

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
