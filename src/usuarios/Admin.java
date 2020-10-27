package usuarios;

import archivos.Archivo;
import interfaz.InterfazConsola;
import util.Check;
import util.MetodosAuxiliares;
import util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Admin {


    public void desbloquear(Ciudadano c) {
        c.setBloqueado(false);
    }

    public void bloquear(Ciudadano c) {
        c.setBloqueado(true);
    }

    public void generarEvento(){
        Archivo.printFileLines("SintomasTotales.txt");
        ArrayList<String> sintomas = Archivo.collectFileLines("SintomasTotales.txt");
        Integer seleccion = Scanner.getInt("Seleccione el sintoma a agregar\n--> ");
        switch(seleccion){
            case 1:
                    Archivo.writeFile(sintomas.get(0), "SintomasGenerados.txt");
                    break;
            case 2: Archivo.writeFile(sintomas.get(1), "SintomasGenerados.txt");
                    break;
            case 3:Archivo.writeFile(sintomas.get(2), "SintomasGenerados.txt");
                    break;
            case 4:Archivo.writeFile(sintomas.get(3), "SintomasGenerados.txt");
                    break;
            case 5:Archivo.writeFile(sintomas.get(4), "SintomasGenerados.txt");
                    break;
            case 6:Archivo.writeFile(sintomas.get(5), "SintomasGenerados.txt");
                    break;
            case 7:Archivo.writeFile(sintomas.get(6), "SintomasGenerados.txt");
                    break;
            case 8: Archivo.writeFile(sintomas.get(7), "SintomasGenerados.txt");
                    break;
            case 9: Archivo.writeFile(sintomas.get(8), "SintomasGenerados.txt");
                    break;

        }
    }

    public void eliminarEvento(){
        Archivo.printFileLines("SintomasGenerados.txt");
        ArrayList<String> sintomasGenerados = Archivo.collectFileLines("SintomasGenerados.txt");
        Integer seleccion = Scanner.getInt("--> ");
        if(seleccion > 0 && seleccion <= sintomasGenerados.size()){
            Archivo.removeLine(sintomasGenerados.get(seleccion-1), "SintomasGenerados.txt");
        }

    }

    /*public void darDeBajaSintoma(){
        //debe sacarle el sintoma a los ciudadanos que lo tengan
    }*/

    public void agregarCiudadano() {
        String CUIL = MetodosAuxiliares.pedirCUIL();
        System.out.println();
        String celular = MetodosAuxiliares.pedirCel();

        if (Check.checkAnses(CUIL, celular)) {
            Archivo.addToLocal(new Ciudadano(CUIL, celular));
            System.out.println("Ciudadano registrado con exito.");

        } else {
            System.out.println("Datos Invalidos");
            MetodosAuxiliares.delay(3000);
            InterfazConsola.clearScreen();
            agregarCiudadano();
        }


    }


    public void eliminarCiudadano() {
        int opcion = Scanner.getInt("1. Buscar por CUIL\n2. Buscar por Celular\n--> ");

        switch (opcion) {
            case 1:
                String CUIL = Scanner.getString("Ingrese el CUIL del Ciudadano a eliminar\n--> ");
                Ciudadano c = Archivo.searchCUIL(CUIL);
                Archivo.removeLocal(c);
                break;
            case 2:
                String celular = Scanner.getString("Ingrese el Celular del Ciudadano a eliminar\n--> ");
                Ciudadano x = Archivo.searchCelular(celular);
                Archivo.removeLocal(x);
                break;
        }

    /*public void buscarInfo(String cuil_o_cel){
        Ciudadano c = buscar(cuil_o_cel);
        c.printCiudadano();

    }*/


    }
}





