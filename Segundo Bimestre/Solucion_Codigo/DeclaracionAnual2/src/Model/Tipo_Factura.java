package Model;

public abstract class Tipo_Factura {
    private double monto;
    private String fecha;

    public Tipo_Factura(double monto, String fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    public abstract double getMontoMaximo();

    public static class Factura_Vivienda extends Tipo_Factura {
        public Factura_Vivienda(double monto, String fecha) {
            super(monto, fecha);
        }

        @Override
        public double getMontoMaximo() {
            return getMonto() * 0.1;
        }
    }

    public static class Factura_Educación extends Tipo_Factura {
        public Factura_Educación(double monto, String fecha) {
            super(monto, fecha);
        }

        @Override
        public double getMontoMaximo() {
            return 800;
        }
    }

    public static class Factura_Alimentación extends Tipo_Factura {
        public Factura_Alimentación(double monto, String fecha) {
            super(monto, fecha);
        }

        @Override
        public double getMontoMaximo() {
            return getMonto() * 0.1;
        }
    }

    public static class Factura_Vestimenta extends Tipo_Factura {
        public Factura_Vestimenta(double monto, String fecha) {
            super(monto, fecha);
        }

        @Override
        public double getMontoMaximo() {
            return 100;
        }
    }

    public static class Factura_Salud extends Tipo_Factura {
        public Factura_Salud(double monto, String fecha) {
            super(monto, fecha);
        }

        @Override
        public double getMontoMaximo() {
            return Math.min(getMonto() * 0.2, 300);
        }
    }

    public static class Factura_Turismo extends Tipo_Factura {
        public Factura_Turismo(double monto, String fecha) {
            super(monto, fecha);
        }

        @Override
        public double getMontoMaximo() {
            return 100;
        }
    }
}