package interfaz;

import usuarios.Admin;
import usuarios.Ciudadano;
import util.Check;

public class Tester {
    public static void main(String[] args) {

        Admin admin = new Admin();
        admin.generarEvento();

        Ciudadano c1 = new Ciudadano("2121111515", "2511151155");
        c1.agregarSintoma();

        System.out.println(c1.toString());





    }
}
