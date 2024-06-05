
package Model;
import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {
    private double[] sueldosMensuales;
    private List<Categoria> categorias;

    public Usuario(double[] sueldosMensuales, List<Categoria> categorias) {
        this.sueldosMensuales = sueldosMensuales;
        this.categorias = categorias;
    }

    public double[] getSueldosMensuales() {
        return sueldosMensuales;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void agregarGasto(String categoriaNombre, double gasto) {
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equals(categoriaNombre)) {
                categoria.agregarGasto(gasto);
                return;
            }
        }
    }
}
