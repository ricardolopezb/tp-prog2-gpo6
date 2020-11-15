package estadistica;

import archivos.Archivo;
import util.Scanner;

import java.util.ArrayList;

public class StatisticsManager {

    ArrayList<Zona> zonas;
    ArrayList<BroteChecker> brotes;

    public StatisticsManager(){
        ArrayList<String> zonasString = Archivo.listaDeZonas();
        this.zonas = new ArrayList<>();
        for (String s : zonasString) {
            zonas.add(new Zona(s));
        }
    }

    public void menuZonas(){
        displayZonas();
        Zona zonaSeleccionada = seleccionarZona();
        zonaSeleccionada.printRanking();
    }

    public void checkBrotes(){

    }

    private void displayZonas(){
        int i = 1;
        for (Zona zona : zonas) {
            System.out.println(i + ". " + zona.getNombre());
            i++;
        }
    }

    private Zona seleccionarZona() {
        Integer seleccion = Scanner.getInt("Escoja la Zona para ver \n--> ");
        return zonas.get(seleccion-1);
    }


}
