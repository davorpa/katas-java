package devengos;

public class CalculadoraDevengo {

    private double interesMensual;

    public CalculadoraDevengo(final double interesMensual) {
        this.interesMensual = interesMensual;
    }

    public double calcular(final Deposito deposito, final int numeroDeMeses) {
        return deposito.getCantidad() * Math.pow(1.0 + interesMensual, numeroDeMeses);
    }
}
