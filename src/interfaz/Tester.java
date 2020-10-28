package interfaz;

import archivos.Archivo;
import entidades.Fecha;
import notificaciones.ContactNotification;
import usuarios.Admin;
import usuarios.Ciudadano;
import util.Check;

public class Tester {
    public static void main(String[] args) {

        Ciudadano c = Archivo.searchCUIL("20465925434");
        Ciudadano c2 = Archivo.searchCUIL("20955205834");

        ContactNotification notif = new ContactNotification(c, c2, new Fecha(10, 2, 2020));

        notif.send();







    }
}
