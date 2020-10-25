package interfaz;

import usuarios.Admin;
import usuarios.Ciudadano;
import util.Check;
import util.MetodosAuxiliares;
import util.Scanner;

public class InterfazConsola {
    public static void main(String[] args) {
    /*
        "menu de entrada e interacicon
     */
        Admin admin = new Admin();
        System.out.println("********** TraceIt **********\n");
        //int eleccion1 = printInicio();
        System.out.println("Ingrese el numero de la accion que desee ejecutar:");
        switch (printInicio()) {
            case 1:
                //clearScreen();
                System.out.println("Ingrese su CUIL");
                String cuil_ingresado = Scanner.getString("--> ");
                printLogeoExistoso();
                break;

            case 2:
                //clearScreen();
                System.out.println("Ingrese su Celular");
                String cel_ingresado = Scanner.getString("--> ");
                printLogeoExistoso();
                break;
            case 3:
                //clearScreen();
                admin.agregarCiudadano();
                MetodosAuxiliares.delay(1500);
                main(args);
                break;

            case 9:
                //clearScreen();
                printPassAdmin();
                break;


        }


    }

    private static void printPassAdmin() {
        /*
        validacion de contraseña de administrador
         */
        String pass = Scanner.getString("Ingrese su contraseña: ");
        if(Check.checkPassAdmin(pass) ){
            // si la contraseña es valida accede al menu especifico
            printAdminMenu();
        }else {
            System.out.println("Datos invalidos");
            MetodosAuxiliares.delay(1500);
            printPassAdmin();
        }
    }

    //*************************** entrada del case 1 y 2 **************************************************//
    private static void printLogeoExistoso() { //para ingreso por CUIL o celular
      /*
      para una vez que se complete el registro e ingreso:
       */
        System.out.println("********** TraceIt **********");
        System.out.println("Bienvenido\n");
        System.out.println("1. Síntomas");
        System.out.println("2. Reportar contacto cercano (a implementar)");
        System.out.println("3. Notificaciones");

        switch (Scanner.getInt("--> ")) {
            case 1:
                printSintoma();
                break;
            case 2:
                printReporteContacto();
                break;
            case 3:
                printNotificaciones();
                break;
            default:
                System.out.println("Por favor, ingrese una opcion válida.");
                printLogeoExistoso();
                break;
        }
    }


    private static void printSintoma() {
        System.out.println("********** TraceIt **********\n");
        System.out.println("1. Reportar sintoma (a implementar)");
        System.out.println("2. Bajar sintoma (a implementar)"); //chekeado que se dice asi ? xdxd
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
        //a implementar
    }
    private static void darBajaSintoma(){
        //a implementar
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
        /*
        para administrador:
         */
        System.out.println("********** TraceIt **********\n");
        System.out.println("1. Manejar Ciudadanos");
        System.out.println("2. Notificaciones");
        System.out.println("3. Manejar Eventos");
        System.out.println("4. Buscar Ciudadanos (a implementar)");
        System.out.println("5. Ver Mapa de Brotes (a implementar)");

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

            default:
                printAdminMenu();
                break;
        }

    }


    public static void printAdminSubManejar() {
        /*
        manejo de los ciudadanos
         */
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
                //borra all:(
                admin.eliminarCiudadano();
                break;
            default:
                /*
                para que imprima nuevamente el menu de manejo de ciud
                 */
                System.out.println("Por favor, ingrese una opcion válida.");
                printAdminSubManejar();
                break;
        }


    }


    public static void printAdminSubNotif() {
        /*
        para tener acceso a las notificaciones
         */
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
        /*
        para el manejo de eventos
         */
        //crear / eliminar / ver E / top 3 eventos por zona
        //manejo de eventos
        System.out.println("********** TraceIt **********\n");
        System.out.println("Manejo de eventos");
        System.out.println("1. Generar evento (a implementar)");
        System.out.println("2. Eliminiar evento (a implementar)");
        System.out.println("3. Ver eventos existentes (a implementar)");
        System.out.println("4. Ver top de eventos por zona (a implementar)");
        System.out.println("\n0. Regresar");

        switch (Scanner.getInt("--> "))   {
            case 0:
                printAdminMenu();
                break;
            case 1:
                printGenerateEvent();
                break;
            case 2:
                printDeleteEvent();
                break;
            case 3:
                printExistEvent();
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
        /*
        menu inicial para el ingreso y registro, tanto como ciudadano como administrador
         */
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
