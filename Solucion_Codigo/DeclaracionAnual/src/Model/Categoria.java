package Model;

import java.io.Serializable;

public class Categoria implements Serializable {
    private String nombre;
    private double totalGasto;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.totalGasto = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTotalGasto() {
        return totalGasto;
    }

    public void agregarGasto(double gasto) {
        this.totalGasto += gasto;
    }
}
