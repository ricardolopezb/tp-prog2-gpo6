package interfaz;

import archivos.Archivos;
import entidades.Fecha;
import usuarios.Admin;
import usuarios.Ciudadano;
import util.MetodosAuxiliares;

import java.io.File;

public class Tester {
    public static void main(String[] args) {
        Ciudadano c = new Ciudadano("20193573592", "1583644750");
        Archivos.addToLocal(c);






    }
}
