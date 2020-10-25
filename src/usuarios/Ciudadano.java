package usuarios;

import archivos.Archivo;
import entidades.Encuentro;
import entidades.Evento;
import util.MetodosAuxiliares;
import util.Scanner;

import java.util.ArrayList;

public class Ciudadano {
    boolean bloqueado;
    final String CUIL;
    final String celular;
    Encuentro anterior;
    Encuentro posterior;
    ArrayList<Evento> sintomas;
    final String zona;
    int solicitudesRechazadas;
    boolean covid;

    //  CUIL\t Celular\t Bloqueado\t Zona\t Rechazos\t Sintoma1,Sintoma2,Sintoma3\t(2002049954(CUIL CIUD 1),1924894392(CUIL CIUD 2),100920(Fecha de Inicio en numero),
    //                      250920(fecha de fin en numero)


    //este se va a usar cuando se cree un ciudadano por primera vez
    public Ciudadano(String CUIL, String celular) {
        this.CUIL = CUIL;
        this.celular = celular;
        this.bloqueado = false;
        solicitudesRechazadas = 0;
        this.zona = MetodosAuxiliares.zonaEnAnses(CUIL);
        anterior = null;
        posterior = null;
        sintomas = null;


    }

    //Este constructor se va a usar cuando se recarguen todos los ciudadanos a partir de nuestra base local
    public Ciudadano(String CUIL, String celular, boolean bloqueado, String zona, int solicitudesRechazadas, ArrayList<Evento> sintomas, Encuentro anterior, Encuentro posterior) {
        this.bloqueado = bloqueado;
        this.CUIL = CUIL;
        this.celular = celular;
        this.anterior = anterior;
        this.posterior = posterior;
        this.sintomas = sintomas;
        this.zona = zona;
        this.solicitudesRechazadas = solicitudesRechazadas;
        this.covid = checkCovid();
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public void printCiudadano(){
        //Un metodo que printea los datos de un ciudadano en especifico. Para que lo use el admin en el metodo para obtener info.
    }

    public String toString(){
        String strSintomas = "";
        String anteriorStr;
        String posteriorStr;
        try {
            for (Evento e : sintomas) {
                strSintomas += e.getNombre() + ",";

            }
        } catch (NullPointerException e){
            strSintomas = "null";
        }
        //(2002049954(CUIL CIUD 1),1924894392(CUIL CIUD 2),100920(Fecha de Inicio en numero),250920(fecha de fin en numero)
        try{
            anteriorStr = anterior.toString();
        } catch (NullPointerException e){
            anteriorStr = "null";
        }
        try{
            posteriorStr = posterior.toString();
        } catch (NullPointerException e){
            posteriorStr = "null";
        }

        String display = CUIL +"\t"+ celular +"\t"+ bloqueado +"\t"+ zona +"\t"+ solicitudesRechazadas +"\t"+ strSintomas +"\t" + anteriorStr +"\t" + posteriorStr;

        return display;

    }

    public boolean checkCovid(){
        //return sintomas.containsAll(listadesintomas xd);
        return true;
    }

    public String getCUIL(){
        return this.CUIL;
    }

    public String getCelular() {
        return celular;
    }

    public void agregarSintoma(){
        String file = "SintomasGenerados.txt";
        Archivo.printFileLines(file);
        ArrayList<String> sintomasPosibles = Archivo.collectFileLines(file);
        Integer seleccion = Scanner.getInt("Seleccione su sintoma\n--> ");
        switch(seleccion){
            case 1:
                sintomas.add(new Evento(sintomasPosibles.get(0)));
                break;
            case 2: sintomas.add(new Evento(sintomasPosibles.get(1)));
                break;
            case 3:sintomas.add(new Evento(sintomasPosibles.get(2)));
                break;
            case 4:sintomas.add(new Evento(sintomasPosibles.get(3)));
                break;
            case 5:sintomas.add(new Evento(sintomasPosibles.get(4)));
                break;
            case 6:sintomas.add(new Evento(sintomasPosibles.get(5)));
                break;
            case 7:sintomas.add(new Evento(sintomasPosibles.get(6)));
                break;
            case 8: sintomas.add(new Evento(sintomasPosibles.get(7)));
                break;
            case 9: sintomas.add(new Evento(sintomasPosibles.get(8)));
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }
    }
}
