package usuarios;

import entidades.Encuentro;
import entidades.Evento;
import util.MetodosAuxiliares;

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

    public String getCUIL(){
        return this.CUIL;
    }

    public String getCelular() {
        return celular;
    }
}
