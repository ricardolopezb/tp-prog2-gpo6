package interfaz;

import entidades.Fecha;
import usuarios.Admin;
import usuarios.Ciudadano;
import util.MetodosAuxiliares;

import java.io.File;

public class Tester {
    public static void main(String[] args) {
        Ciudadano c = new Ciudadano("20193573592", "1583644750");
        System.out.println(c.toString());
        String droga = new File("BaseAnses.txt").getAbsolutePath();
        System.out.println(droga);






    }
}
