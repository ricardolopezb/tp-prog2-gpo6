package entidades;

import archivos.Archivo;
import usuarios.Ciudadano;

public class Encuentro {
    Ciudadano ciud1;
    Ciudadano ciud2;

    //Fecha fechaInicio;
    Fecha fechaFin;
    Fecha finDeEfecto;

                            //Fecha fechaInicio,
    public Encuentro(String cuil1, String cuil2, Fecha fechaFin) {
        this.ciud1 = Archivo.searchCUIL(cuil1);
        this.ciud2 = Archivo.searchCUIL(cuil2);
        //this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        finDeEfecto = fechaFin.add48hs();
    }

    public String toString(){
        //(2002049954(CUIL CIUD 1),1924894392(CUIL CIUD 2),100920(Fecha de Inicio en numero),250920(fecha de fin en numero)
        return ciud1.getCUIL()+","+ciud2.getCUIL()+","+fechaFin.toString();

        //fechaInicio.toString()+","+
    }



}
