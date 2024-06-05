
package Model;

import java.io.Serializable;

public class Impuestoss implements Serializable {
    private double[] fraccionBasica;
    private double[] tasa;
    private double[] impuesto;

    public Impuestoss(double[] fraccionBasica, double[] tasa, double[] impuesto) {
        this.fraccionBasica = fraccionBasica;
        this.tasa = tasa;
        this.impuesto = impuesto;
    }

    public double calcularImpuesto(double sueldoAnual, double deducciones) {
        double baseImponible = sueldoAnual - deducciones;
        double impuestoPagar = 0;

        for (int i = 0; i < fraccionBasica.length; i++) {
            if (baseImponible <= fraccionBasica[i]) {
                impuestoPagar = (baseImponible * tasa[i]) + impuesto[i];
                break;
            }
        }

        return impuestoPagar;
    }
}