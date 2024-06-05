package View;

import Controller.Controlador;
import Model.Categoria;
import Model.Impuestoss;
import Model.Usuario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ejecutor {
    public static void main(String[] args) {
        // Inicialización de los sueldos mensuales con valores reales
        double[] sueldosMensuales = {2000, 2500, 2800, 3000, 3200, 3300, 3400, 3500, 3600, 3700, 3800, 4000};
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String[] categorias = {"Vivienda", "Educacion", "Alimentacion", "Vestimenta", "Salud", "Turismo"};
        
        List<Categoria> listaCategorias = new ArrayList<>();
        for (String categoria : categorias) {
            listaCategorias.add(new Categoria(categoria));
        }

        Usuario usuario = new Usuario(sueldosMensuales, listaCategorias);
        
        double[] fraccionBasica = {11902, 15159, 19682, 26031, 34255, 45407, 60450, 80605, 107199};
        double[] tasa = {0, 0.05, 0.1, 0.12, 0.15, 0.2, 0.25, 0.3, 0.35, 0.37}; 
        double[] impuesto = {0, 0, 163, 615, 1377, 2611, 4841, 8602, 14648, 23956};
        
        Impuestoss impuestos2023 = new Impuestoss(fraccionBasica, tasa, impuesto);

        Vista vista = new Vista();
        Controlador controlador = new Controlador(usuario, impuestos2023, vista, meses);

        controlador.generarSueldosMensuales();
        controlador.agregarFactura("Vivienda", 50);
        controlador.agregarFactura("Educacion", 30);
        controlador.agregarFactura("Alimentacion", 10);
        controlador.agregarFactura("Vestimenta", 20);
        controlador.agregarFactura("Salud", 50);
        controlador.agregarFactura("Turismo", 80);

        controlador.calcularImpuestos();

        try (FileOutputStream fileOut = new FileOutputStream("datos.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(usuario);
            out.writeObject(impuestos2023);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
