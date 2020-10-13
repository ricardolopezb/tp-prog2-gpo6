package interfaz;

import archivos.Archivos;
import entidades.Fecha;
import usuarios.Admin;
import usuarios.Ciudadano;
import util.MetodosAuxiliares;

import java.io.File;

public class Tester {
    public static void main(String[] args) {
        Ciudadano c = Archivos.decode("27957675826\t1549300455\tfalse\tCiudad de Buenos Aires\t0\tnull\tnull\tnull");

        System.out.println(c);





    }
}
