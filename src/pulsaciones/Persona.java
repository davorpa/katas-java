package pulsaciones;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {

    private final LocalDate fechaNacimiento;

    public Persona(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the fechaNacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public long getEdad() {
        return ChronoUnit.YEARS.between(getFechaNacimiento(), LocalDate.now());
    }

}
