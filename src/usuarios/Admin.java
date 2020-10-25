package usuarios;

import archivos.Archivo;
import interfaz.InterfazConsola;
import util.Check;
import util.MetodosAuxiliares;
import util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Admin {


    public void desbloquear(Ciudadano c) {
        c.setBloqueado(false);
    }

    public void bloquear(Ciudadano c) {
        c.setBloqueado(true);
    }

    public void generarEvento(){
        Archivo.printFileLines("SintomasTotales.txt");
        Integer seleccion = Scanner.getInt("Seleccione el sintoma a agregar\n--> ");
        switch(seleccion){
            case 1:
                Archivo.writeFile("Fiebre", "SintomasGenerados.txt");
                break;
            case 2: Archivo.writeFile("Tos", "SintomasGenerados.txt");
                    break;
            case 3:Archivo.writeFile("Dolor de garganta", "SintomasGenerados.txt");
                    break;
            case 4:Archivo.writeFile("Dificultad respiratoria", "SintomasGenerados.txt");
                    break;
            case 5:Archivo.writeFile("Dolor muscular", "SintomasGenerados.txt");
                    break;
            case 6:Archivo.writeFile("Dolor de cabeza", "SintomasGenerados.txt");
                    break;
            case 7:Archivo.writeFile("Diarrea", "SintomasGenerados.txt");
                    break;
            case 8: Archivo.writeFile("Vómitos", "SintomasGenerados.txt");
                    break;
            case 9: Archivo.writeFile("Pérdida de gusto/olfato", "SintomasGenerados.txt");
                    break;

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





