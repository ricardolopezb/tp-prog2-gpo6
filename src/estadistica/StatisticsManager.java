package estadistica;

import archivos.Archivo;
import util.Scanner;

import java.util.ArrayList;

public class StatisticsManager {

    ArrayList<Zona> zonas;
    ArrayList<Brote> brotes;
    BroteChecker broteChecker;

    public StatisticsManager(){
        ArrayList<String> zonasString = Archivo.listaDeZonas();
        this.zonas = new ArrayList<>();
        for (String s : zonasString) {
            zonas.add(new Zona(s));
        }
        broteChecker = new BroteChecker();
    }

    public void menuZonas(){
        displayZonas();
        Zona zonaSeleccionada = seleccionarZona();
        zonaSeleccionada.printRanking();
    }

    public void showBrotes(){
        checkBrotes();
        System.out.println("Se han encontrado "+ brotes.size() + " brotes.\nDesea verlos? Y/N");

        char seleccion = Character.toLowerCase(Scanner.getChar("--> "));
        if(seleccion == 'n') return;
        if(seleccion == 'y'){
            for (Brote brote: brotes) {
                System.out.println(brote.toString());
            }
        }

    }


    public void checkBrotes(){
        Brote broteEncontrado = broteChecker.checkBrotes();
        if(broteEncontrado == null) return;
        brotes.add(broteEncontrado);

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
