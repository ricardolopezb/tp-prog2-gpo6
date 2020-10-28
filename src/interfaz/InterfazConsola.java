package interfaz;

import archivos.Archivo;
import entidades.Evento;
import usuarios.Admin;
import usuarios.Ciudadano;
import util.Check;
import util.MetodosAuxiliares;
import util.Scanner;

public class InterfazConsola {
    static Admin admin = new Admin();
    static Ciudadano ciudadano;

    public static void main(String[] args) {

        Admin admin = new Admin();
        System.out.println("********** TraceIt **********\n");
        //int eleccion1 = printInicio();
        System.out.println("Ingrese el numero de la accion que desee ejecutar:");
        switch (printInicio()) {
            case 1:
                //clearScreen();
                System.out.println("Ingrese su CUIL");
                String cuil_ingresado = Scanner.getString("--> ");
                if(Archivo.checkCuilInLocal(cuil_ingresado)) {
                    ciudadano = Archivo.searchCUIL(cuil_ingresado);
                    printLogeoExistoso();

                }
                break;

            case 2:
                //clearScreen();
                System.out.println("Ingrese su Celular");
                String cel_ingresado = Scanner.getString("--> ");
                if(Archivo.checkCelInLocal(cel_ingresado)) {
                    ciudadano = Archivo.searchCelular(cel_ingresado);
                    printLogeoExistoso();
                }
                break;
            case 3:
                //clearScreen();
                admin.agregarCiudadano();
                break;

            case 9:
                //clearScreen();
                printPassAdmin();
                break;


        }


    }

    private static void printPassAdmin() {
        String pass = Scanner.getString("Ingrese su contraseña: ");
        if(Check.checkPassAdmin(pass) ){
            printAdminMenu();
        }else {
            System.out.println("Datos invalidos");
            MetodosAuxiliares.delay(1500);
            printPassAdmin();
        }
    }

    //*************************** entrada del case 1 y 2 **************************************************//
    private static void printLogeoExistoso() { //para ingreso por CUIL o celular
        System.out.println("********** TraceIt **********");
        System.out.println("Bienvenido\n");
        System.out.println("1. Síntomas");
        System.out.println("2. Reportar contacto cercano (a implementar)");
        System.out.println("3. Notificaciones\n");
        System.out.println("9. Salir");

        switch (Scanner.getInt("--> ")) {
            case 1:
                printSintoma();
                break;
            case 2:
                ciudadano.solicitudDeContacto();
                break;
            case 3:
                ciudadano.showNotifications();
                break;
            case 9:
                ciudadano.overwrite();
                System.exit(0);
            default:
                printLogeoExistoso();
                break;
        }
    }


    private static void printSintoma() {
        System.out.println("********** TraceIt **********\n");
        System.out.println("1. Reportar sintoma");
        System.out.println("2. Bajar sintoma");
        System.out.println("0. Regresar");

        switch (Scanner.getInt("--> ")){
            case 0:
                printLogeoExistoso();
                break;
            case 1:
                darAltaSintoma();
                break;
            case 2:
                darBajaSintoma();
                break;
            default:
                printSintoma();
                break;
        }
    }
    private static void darAltaSintoma() {
        ciudadano.agregarSintoma();
    }
    private static void darBajaSintoma(){
        ciudadano.removerSintoma();

    }


    private static void printReporteContacto() {
        //reportar contacto con otro ciudadano
    }



    private static void printNotificaciones() {
        /*
            notif de brote
            hubo contacto con persona de 2 sintomas
            tuvo contacto con x persona? si / no
         */
        System.out.println("********** TraceIt **********\n");
        System.out.println("Desea ver notificaciones de:");
        System.out.println("    1. Brotes (a implementar)");
        System.out.println("    2. Contactos recibidos (a implementar)");
        System.out.println("    3. Contactos realizados (a implementar)");// estan chekeados esos nombes?
        System.out.println("    0. Regresar");

        switch (Scanner.getInt("--> ")) {
            case 0:
                printLogeoExistoso();
                break;
            case 1:
                printBrotes();
                break;
            case 2:
                printContactoRecibidos();
                break;
            case 3:
                printContactoRealizado();
                break;
            default:
                printNotificaciones();
                break;
        }
    }
    private static void printBrotes(){
        //brote en zona concurrida
    }
    private static void printContactoRecibidos(){
        // recibe la confirmacion de contacto con otro ciudadano, por si o no

    }
    private static void printContactoRealizado() {
        // ingrersa que tuvo contacto con otro ciudadano en x zona
        // el otro ciudadano la recibe por printContactoRecibido()
    }

//******************************* cierre entrada 1 y 2 ******************************************//

//******************************* menu del administrador ****************************************//
    public static void printAdminMenu(){
        System.out.println("********** TraceIt **********\n");
        System.out.println("1. Manejar Ciudadanos");
        System.out.println("2. Notificaciones");
        System.out.println("3. Manejar Eventos");
        System.out.println("4. Buscar Ciudadanos (a implementar)");
        System.out.println("5. Ver Mapa de Brotes (a implementar)\n");
        System.out.println("9. Salir");

        switch(Scanner.getInt("--> ")){
            case 1:
                printAdminSubManejar();
                break;
            case 2:
                printAdminSubNotif();
                break;
            case 3:
                printAdminSubEvents();
                break;
            case 4:
                printAdminSubBuscar();
                break;
            case 5:
                printAdminMapa();
                break;
            case 9:
                System.exit(0);

            default:
                printAdminMenu();
                break;
        }

    }


    public static void printAdminSubManejar() {
        //bloquear / desbloquear / agregar / eliminar
        System.out.println("********** TraceIt **********\n");
        System.out.println("1. Desbloquear Ciudadanos (a implementar)");
        System.out.println("2. Agregar Ciudadanos");
        System.out.println("3. Eliminar Ciudadanos");
        System.out.println("\n0. Regresar");

        Admin admin = new Admin();

        switch(Scanner.getInt("--> ")){
            case 0:
                printAdminMenu();
                break;
            case 1:
                //en admin, borra ;(
                //Ciudadano c = mostrarBloqueados();
                //admin.desbloquear(c);
            case 2:
                admin.agregarCiudadano();
                break;
            case 3:
                admin.eliminarCiudadano();
                break;
            default:
                printAdminSubManejar();
                break;
        }


    }


    public static void printAdminSubNotif() {
        //brotes / usuarios bloqueados
        System.out.println("********** TraceIt **********\n");
        System.out.println("1. Notificaciones de brote por zona (a implementar)");
        System.out.println("2. Notificaciones de ciudadanos bloqueados (a implementar)");
        System.out.println("\n0. Regresar");

        switch (Scanner.getInt("--> ")){
            case 0:
                printAdminMenu();
                break;
            case 1:
                printNotifBrotes();
                break;
            case 2:
                printCiudadanosBloqueados();
                break;
            default:
                printAdminSubNotif();
                break;

        }
    }
    private static void printNotifBrotes() {
        //donde hay brotes segun la relacion con los sintomas
    }
    private static void printCiudadanosBloqueados() {
        //cuantos y quienes son los usuarios bloqueados
    }


    public static void printAdminSubEvents() {
        //crear / eliminar / ver E / top 3 eventos por zona
        //manejo de eventos
        System.out.println("********** TraceIt **********\n");
        System.out.println("Manejo de eventos");
        System.out.println("1. Generar evento");
        System.out.println("2. Eliminar evento");
        System.out.println("3. Ver eventos existentes");
        System.out.println("4. Ver top de eventos por zona (a implementar)");
        System.out.println("\n0. Regresar");

        switch (Scanner.getInt("--> "))   {
            case 0:
                printAdminMenu();
                break;
            case 1:
                admin.generarEvento();
                break;
            case 2:
                admin.eliminarEvento();
                break;
            case 3:
                Archivo.printFileLines("SintomasGenerados.txt");
                break;
            case 4:
                printTopEvent();
                break;
            default:
                printAdminSubEvents();
                break;

        }
    }
    private static void printGenerateEvent() {
        //para crear evento
    }
    private static void printDeleteEvent() {
        //para borrar evento
    }
    private static void printExistEvent() {
        //lista de eventos existentes
    }
    private static void printTopEvent() {
        //top 3 de eventos
    }


    public static void printAdminSubBuscar() {
        //busqueda por cuil o celular
    }


    public static void printAdminMapa() {
        //para ver el mapa
    }

//************************************** cierre menu del administrador ******************************************//




    public static int printInicio(){
        System.out.println("1. Ingresar con CUIL");
        System.out.println("2. Ingresar con Celular");
        System.out.println("3. Registrarse\n");
        System.out.println("9. Ingresar como Administrador");
        return Scanner.getInt("--> ");
    }

    public static void clearScreen(){
        for (int i = 0; i < 30 ; i++) {
            System.out.println();

        }
    }




}
