package Model;
import java.util.List;
public class CalculoImpuestos {
        private double[] fraccionBasica = {11902, 15159, 19682, 26031, 34255, 45407, 60450, 80605, 107199};
        private double[] tasa = {0, 0.05, 0.1, 0.12, 0.15, 0.2, 0.25, 0.3, 0.35, 0.37}; 
        private double[] impuesto = {0, 0, 163, 615, 1377, 2611, 4841, 8602, 14648, 23956}; 

    public double calcularTotalIngresos(List<Ingreso> ingresos) {
        double totalIngresos = 0; 
        for (Ingreso ingreso : ingresos) { 
            totalIngresos += ingreso.getSueldoMensual(); 
        }
        return totalIngresos; 
    }
    public double calcularTotalDeducciones(List<Tipo_Factura> facturas) {
        double totalDeducciones = 0; 
        for (Tipo_Factura factura : facturas) { 
            totalDeducciones += factura.getMontoMaximo(); 
        }
        return totalDeducciones; 
    }
    public double calcularImpuestos(Usuario usuario) {
        double totalIngresos = calcularTotalIngresos(usuario.getIngresos()) * 12; 
        double totalDeducciones = calcularTotalDeducciones(usuario.getFacturas()); 
        double ingresosNetos = totalIngresos - totalDeducciones; 
        for (int i = 0; i < fraccionBasica.length; i++) {
            if (ingresosNetos > fraccionBasica[i] && (i == fraccionBasica.length - 1 || ingresosNetos <= fraccionBasica[i + 1])) {
                return impuesto[i] + ((ingresosNetos - fraccionBasica[i]) * tasa[i]);
            }
        }
        return 0; 
    }
}