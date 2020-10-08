package interfaz;

import usuarios.Admin;
import util.Scanner;

public class InterfazConsola {
    public static void main(String[] args) {

        Admin admin = new Admin();
        System.out.println("********** TraceIt **********\n");
        //int eleccion1 = printInicio();

        switch(printInicio()){
            case 1:
                clearScreen();
                System.out.println("Ingrese su CUIL");
                String cuil_ingresado = Scanner.getString("--> ");

                break;

            case 2:
                clearScreen();
                System.out.println("Ingrese su Celular");
                String cel_ingresado = Scanner.getString("--> ");
                break;
            case 3:
                clearScreen();
                admin.agregarCiudadano();
                break;

            case 9:
                clearScreen();
                printAdminMenu();

        }



    }

    public static void printAdminMenu(){
        System.out.println("********** TraceIt **********\n");
        System.out.println("1. Manejar Ciudadanos");
        System.out.println("2. Notificaciones");
        System.out.println("3. Manejar Eventos");
        System.out.println("4. Buscar Ciudadanos");
        System.out.println("5. Ver Mapa de Brotes");
        System.out.println("\n9. Regresar");

        /*switch(Scanner.getInt("--> ")){
            case 1:
                printAdminSubManejar();
                break;
            case 2:
                printAdminSubNotif();
                break;
            case 3: printAdminSub*/

        }




















    public static int printInicio(){
        System.out.println("1. Ingresar con CUIL");
        System.out.println("2. Ingresar con Celular");
        System.out.println("3. Registrarse\n");
        System.out.println("9. Ingresar como Administrador");
        return Scanner.getInt("--> ");
    }

    public static void clearScreen(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(Exception E){System.out.println(E.getMessage());}
    }




}
