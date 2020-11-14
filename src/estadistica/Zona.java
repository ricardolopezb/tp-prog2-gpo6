package estadistica;

import archivos.Archivo;
import entidades.Evento;
import usuarios.Ciudadano;

import java.util.*;

public class Zona {
    private final String nombre;
    ArrayList<Ciudadano> residentes;
    HashMap<String, Integer> ranking;


    public Zona(String nombre){
        this.nombre = nombre;
        residentes = Archivo.searchCiudadanosPorZona(nombre);
        ranking = new HashMap<>();
        refreshRanking();

    }


    public void refreshRanking(){
        this.ranking = getRankingSintomas();
        sortByValue();
    }

    public void printRanking(){
        for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
            System.out.println(entry.getKey() + "- Veces: "+ entry.getValue());
        }

    }

    private HashMap<String, Integer> getRankingSintomas(){
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
        return ranking;

    }

    public void sortByValue() {
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        ranking.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        this.ranking = reverseSortedMap;

    }

    public void printResidentes(){
        for (Ciudadano residente : residentes) {
            residente.printCiudadano();

        }
    }




}
