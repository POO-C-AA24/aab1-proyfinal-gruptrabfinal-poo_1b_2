
package Controller;

import Model.Categoria;
import Model.Impuestoss;
import Model.Usuario;
import View.Vista;
import java.io.FileWriter;
import java.io.IOException;

public class Controlador {
    private Usuario usuario;
    private Impuestoss impuestos;
    private Vista vista;
    private String[] meses;

    public Controlador(Usuario usuario, Impuestoss impuestos, Vista vista, String[] meses) {
        this.usuario = usuario;
        this.impuestos = impuestos;
        this.vista = vista;
        this.meses = meses;
    }

    public void generarSueldosMensuales() {
        double[] sueldosMensuales = usuario.getSueldosMensuales();
        for (int i = 0; i < sueldosMensuales.length; i++) {
            sueldosMensuales[i] = (int) (Math.random() * (2000 - 0 + 1) + 900);
        }
        vista.mostrarSueldosMensuales(sueldosMensuales, meses);
    }

    public void agregarFactura(String categoriaNombre, double gasto) {
        usuario.agregarGasto(categoriaNombre, gasto);
        vista.mostrarCategorias(usuario.getCategorias());
    }

    public void calcularImpuestos() {
        double sueldoAnual = 0;
        double deducciones = 0;
        double maximoDeduccion = 5327;

        // Calculo de sueldo anual
        for (double sueldo : usuario.getSueldosMensuales()) {
            sueldoAnual += sueldo;
        }

        // Calculo de deducciones
        for (Categoria categoria : usuario.getCategorias()) {
            deducciones += categoria.getTotalGasto();
        }

        // Aplica el máximo de deducciones permitidas
        deducciones = Math.min(deducciones, maximoDeduccion);

        // Calculo de el impuesto usando la tabla de impuestos
        double impuesto = impuestos.calcularImpuesto(sueldoAnual, deducciones);

        // Mostrar resultados detallados
        vista.mostrarCalculoImpuestos(sueldoAnual, deducciones, impuesto);

       
    }
}
   
