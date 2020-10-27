package interfaz;

import archivos.Archivo;
import usuarios.Admin;
import usuarios.Ciudadano;
import util.Check;

public class Tester {
    public static void main(String[] args) {

        Ciudadano c = Archivo.searchCUIL("20465925434");
        System.out.println(c.getZona());
        c.setZona("Pilar");
        c.overwrite();
        System.out.println(c.getZona());







    }
}
