package devengos;

public class CalculadoraDevengo {

    private final double interesMensual;

    public CalculadoraDevengo(final double interesMensual) {
        this.interesMensual = interesMensual;
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public double calcularTotalDevengado(final Deposito deposito, final int numeroDeMeses) {
        return deposito.getCantidad() * Math.pow(1.0 + interesMensual, numeroDeMeses);
    }
}
