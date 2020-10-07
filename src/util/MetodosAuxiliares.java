package util;

import interfaz.InterfazConsola;

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







}
