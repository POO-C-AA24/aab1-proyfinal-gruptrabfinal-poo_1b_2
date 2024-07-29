package Model;
import java.util.List;
public class Usuario {
    private String nombre;
    private String dni;
    private List<Ingreso> ingresos;
    private List<Tipo_Factura> facturas;

    public Usuario(String nombre, String dni, List<Ingreso> ingresos, List<Tipo_Factura> facturas) {
        this.nombre = nombre;
        this.dni = dni;
        this.ingresos = ingresos;
        this.facturas = facturas;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }
    public List<Ingreso> getIngresos() {
        return ingresos;
    }
    public List<Tipo_Factura> getFacturas() {
        return facturas;
    }
}