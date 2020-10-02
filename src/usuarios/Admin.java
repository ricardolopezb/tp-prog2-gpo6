package usuarios;

import util.Scanner;

public class Admin {




    public void desbloquear(Ciudadano c){
        c.setBloqueado(false);
    }
    public void bloquear(Ciudadano c){
        c.setBloqueado(true);
    }


    public void agregarCiudadano(){
        String CUIL = Scanner.getString("Ingrese el CUIL del Ciudadano: ");
        String celular = Scanner.getString("Ingrese el Telefono del Ciudadano: ");
        //(donde se guardan los datos).add(new Ciudadano(CUIL, celular))
    }
    public void eliminarCiudadano(){
        int opcion = Scanner.getInt("1. Buscar por CUIL\n2. Buscar por Telefono");
        buscar(opcion);

        //################################################################
        //Aca hay que implementar como buscar ese ciudadano especifico en donde sea que guardemos los ciudadanos.
        //Deberiamos poder buscarlos o por CUIL o por celular, cualquiera de los dos.
        //################################################################


        //switch(opcion){
        //    case 1: String CUIL = Scanner.getString("Ingrese el CUIL del Ciudadano a eliminar");
        //            break;
        //    case 2: String celular =


        //(donde se guardan los datos).remove(new Ciudadano(CUIL, celular))
    }

    public void buscarInfo(String cuil_o_cel){
        Ciudadano c = buscar(cuil_o_cel);
        c.printCiudadano();

    }


    private Ciudadano buscar(String cuil_o_cel){
        //A implementar
    }




}





