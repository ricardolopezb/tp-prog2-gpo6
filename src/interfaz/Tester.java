package interfaz;

import archivos.Archivo;
import de.fhpotsdam.unfolding.geo.Location;
import entidades.Fecha;
import estadistica.Zona;
import estadistica.mapa.BuscadorCoordenadas;
import notificaciones.ContactNotification;
import usuarios.Admin;
import usuarios.Ciudadano;
import util.Check;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {

        Location coordsPilar = BuscadorCoordenadas.getCoordenadas("Mendoza");

        System.out.println(coordsPilar.x);
        System.out.println(coordsPilar.y);









    }
}
