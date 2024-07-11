package com.usta;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    String nombre;
    LocalDate fechaNacimiento;
    int edadEnMeses;

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.edadEnMeses = calcularEdadEnMeses(fechaNacimiento);
    }

    private int calcularEdadEnMeses(LocalDate fechaNacimiento) {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        return periodo.getYears() * 12 + periodo.getMonths();
    }

    public String obtenerEdad() {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        return periodo.getYears() + " años y " + periodo.getMonths() + " meses";
    }

    public String diferenciaExacta(LocalDate otraFechaNacimiento) {
        Period periodo = Period.between(otraFechaNacimiento, fechaNacimiento);
        if (periodo.getYears() > 0) {
            return periodo.getYears() + " años";
        } else if (periodo.getMonths() > 0) {
            return periodo.getMonths() + " meses";
        } else {
            return periodo.getDays() + " días";
        }
    }
}



