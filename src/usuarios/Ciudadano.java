package usuarios;

public class Ciudadano {
    boolean bloqueado;
    final String CUIL;
    final String celular;
    /*Encuentro anterior;
    Encuentro posterior;
    ArrayList<Eventos> sintomas;
    final String zona;*/

    public Ciudadano(String CUIL, String celular) {
        this.CUIL = CUIL;
        this.celular = celular;
        this.bloqueado = false;

        //this.zona = dataset.getZona();

    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public void printCiudadano(){
        //Un metodo que printea los datos de un ciudadano en especifico. Para que lo use el admin en el metodo para obtener info.
    }
}
