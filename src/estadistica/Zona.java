package estadistica;

import archivos.Archivo;
import entidades.Evento;
import usuarios.Ciudadano;

import java.util.ArrayList;
import java.util.HashMap;

public class Zona {
    private final String nombre;
    ArrayList<Ciudadano> residentes;
    HashMap<String, Integer> ranking;


    public Zona(String nombre){
        this.nombre = nombre;
        residentes = Archivo.searchCiudadanosPorZona(nombre);
        ranking = new HashMap<>();
        checkRankingSintomas();

    }

    public void checkRankingSintomas(){
        ArrayList<String> sintomasActuales = Archivo.collectFileLines("SintomasGenerados.txt");
        HashMap<String, Integer> ranking = new HashMap<>();
        for (String sintoma : sintomasActuales) {
            Integer veces = 0;
            for (Ciudadano ciudadano: residentes) {
                ArrayList<Evento> sintomasDelCiudadano = ciudadano.getSintomas();
                for (Evento sintomaCiudadano: sintomasDelCiudadano) {
                    if(sintoma.equals(sintomaCiudadano.getNombre())){
                        veces++;
                    }

                }
            }

            ranking.put(sintoma, veces);
        }



    }





    public void printResidentes(){
        for (Ciudadano residente : residentes) {
            residente.printCiudadano();

        }
    }




}
