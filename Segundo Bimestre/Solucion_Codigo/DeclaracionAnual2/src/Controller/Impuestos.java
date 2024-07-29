package Controller;

import Model.Usuario;
import Model.CalculoImpuestos;

public class Impuestos {
    private Usuario usuario;
    private CalculoImpuestos calculoImpuestos;

    public Impuestos(Usuario usuario) {
        this.usuario = usuario;
        this.calculoImpuestos = new CalculoImpuestos();
    }

    public double calcularImpuestos() {
        return calculoImpuestos.calcularImpuestos(usuario);
    }
}