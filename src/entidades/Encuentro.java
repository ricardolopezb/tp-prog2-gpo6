package entidades;

import usuarios.Ciudadano;

public class Encuentro {
    Ciudadano ciud1;
    Ciudadano ciud2;

    Fecha fechaInicio;
    Fecha fechaFin;
    Fecha finDeEfecto;

    public Encuentro(Ciudadano ciud1, Ciudadano ciud2, Fecha fechaInicio, Fecha fechaFin) {
        this.ciud1 = ciud1;
        this.ciud2 = ciud2;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        finDeEfecto = fechaFin.add48hs();
    }
}
