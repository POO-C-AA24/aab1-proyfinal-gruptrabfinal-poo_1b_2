
package View;

import Model.Categoria;
import java.util.List;

public class Vista {
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarCalculoImpuestos(double sueldoAnual, double deducciones, double impuesto) {
        System.out.println("---------Calculo de Impuestos-----------");
        System.out.println("Total Sueldo Anual: " + sueldoAnual);
        System.out.println("Total Deducciones: " + deducciones);
        System.out.println("Impuesto a Pagar: " + impuesto);
    }

    public void mostrarSueldosMensuales(double[] sueldosMensuales, String[] meses) {
        System.out.println("---------Sueldos Mensuales-----------");
        for (int i = 0; i < sueldosMensuales.length; i++) {
            System.out.println(meses[i] + ": " + sueldosMensuales[i]);
        }
    }

    public void mostrarCategorias(List<Categoria> categorias) {
        System.out.println("---------Gastos por Categoria-----------");
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getNombre() + ": " + categoria.getTotalGasto());
        }
    }
}

    

