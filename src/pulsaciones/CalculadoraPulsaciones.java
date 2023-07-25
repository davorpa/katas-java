package pulsaciones;

public class CalculadoraPulsaciones {

    private static final int PULSACIONES_MAXIMAS = 220;

    private int pulsacionesMaximas;


    public CalculadoraPulsaciones() {
        this(PULSACIONES_MAXIMAS);
    }

    protected CalculadoraPulsaciones(int pulsacionesMaximas) {
        this.pulsacionesMaximas = pulsacionesMaximas;
    }


    public double calcularNumeroDePulsaciones(Persona persona) {
        return (pulsacionesMaximas - persona.getEdad()) / 10.0;
    }
}
