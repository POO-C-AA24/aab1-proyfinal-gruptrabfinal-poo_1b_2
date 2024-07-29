
package declaracionanual2;
import Model.*;
import View.ImpuestosView;

import java.util.Arrays;
public class Ejecutor {
    public static void main(String[] args) {
        Ingreso ingreso1 = new Ingreso(1500.00);
       
        Tipo_Factura factura1 = new Tipo_Factura.Factura_Vivienda(200, "2024-01-15");
        Tipo_Factura factura2 = new Tipo_Factura.Factura_Educación(1500.00, "2024-02-15");
        Tipo_Factura factura3 = new Tipo_Factura.Factura_Alimentación(200, "2024-03-15");
        Tipo_Factura factura4 = new Tipo_Factura.Factura_Vestimenta(100, "2024-04-15");
        Tipo_Factura factura5 = new Tipo_Factura.Factura_Salud(150, "2024-05-15");
        Tipo_Factura factura6 = new Tipo_Factura.Factura_Turismo(500, "2024-06-15");

        Usuario usuario = new Usuario("Jean", "1105919664", Arrays.asList(ingreso1), Arrays.asList(factura1, factura2, factura3, factura4, factura5, factura6));

        ImpuestosView view = new ImpuestosView();
        view.mostrarDeclaracion(usuario);
    }
}