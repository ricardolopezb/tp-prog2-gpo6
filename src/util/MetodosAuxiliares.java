package util;

import entidades.Fecha;
import interfaz.InterfazConsola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MetodosAuxiliares {

    public static void delay(int millis){
        try{
            Thread.sleep(millis);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    public static String pedirCUIL() {
        System.out.println("Ingrese el CUIL");
        String CUIL = Scanner.getString("--> ");
        boolean x = Check.checkCUIL(CUIL);
        if (x) {
            return CUIL;
        } else {
            System.out.println("Datos Invalidos");
            MetodosAuxiliares.delay(3000);
            InterfazConsola.clearScreen();
            pedirCUIL();
        }
        return "";
    }

    public static Fecha pedirFecha(){
        System.out.println("Ingrese la fecha:\n");
        int day = Scanner.getInt("Dia --> ");
        int month = Scanner.getInt("Mes --> ");
        String year = Scanner.getString("Año --> ");
        if(day >31 || day < 1 || month > 12 || month < 1){
            System.out.println("Datos Invalidos");
            delay(3000);
            InterfazConsola.clearScreen();
            return pedirFecha();
        }
        int newYear;
        if(year.length() == 2){
            year = "20"+year;
            newYear = Integer.parseInt(year);
        } else if (year.length() == 4){
            newYear = Integer.parseInt(year);
        } else{
            System.out.println("Datos Invalidos");
            delay(3000);
            InterfazConsola.clearScreen();
            return pedirFecha();
        }

        return new Fecha(day, month, newYear);
    }

    public static String pedirCel() {
        System.out.println("Ingrese el Celular");
        String celular = Scanner.getString("--> ");
        boolean x = Check.checkCelular(celular);
        if (x) {
            return celular;
        } else {
            System.out.println("Datos Invalidos");
            MetodosAuxiliares.delay(3000);
            InterfazConsola.clearScreen();
            pedirCel();
        }
        return "";
    }

    public static String zonaEnAnses(String CUIL){
        try{
            BufferedReader br = new BufferedReader(new FileReader("src\\archivos\\BaseAnses.txt"));
            String line = br.readLine();

            while(line != null){
                String[] x = line.split("\t");
                if(x[1].equals(CUIL)){
                    return x[3];
                }
                line = br.readLine();
            }
            br.close();

        } catch (IOException e) {
            e.getMessage();
        }
        return "-";
    }





}





