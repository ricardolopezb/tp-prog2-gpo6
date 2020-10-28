package notificaciones;

import archivos.Archivo;
import entidades.Encuentro;
import entidades.Fecha;
import usuarios.Ciudadano;
import util.Scanner;

public class ContactNotification extends Notification {


    private Fecha fechaDeFin;

    public ContactNotification(Ciudadano receiver,Ciudadano sender,  Fecha fechaDeFin) {
        super(receiver, sender);
        this.fechaDeFin = fechaDeFin;
    }

    @Override
    public String serialize() {
        String serialized = "solicitud@"+ receiver.getCUIL() + "@" + sender.getCUIL() + "@" + fechaDeFin.toString();
        return serialized;
    }

    public void send(){
        Archivo.writeFile(this.serialize(), "Notificaciones.txt");
    }




    @Override
    public void printNotification() {
        String[] fechaDividida = fechaDeFin.toString().split("-");
        String toShow = "--- Solicitud de Encuentro ---" + "\n" +
                sender.getNombre() + " dice que tuvieron contacto el " + fechaDividida[0] +
                "/"+fechaDividida[1];
        System.out.println(toShow);
    }

    public void getResponse(){
        String[] fechaDividida = fechaDeFin.toString().split("-");
        char seleccion = Character.toLowerCase(Scanner.getChar("Acepta? Y/N\n--> "));
        switch(seleccion){
            case 'y':
                Encuentro nuevoEncuentro = new Encuentro(sender.getCUIL(), receiver.getCUIL(), new Fecha(Integer.parseInt(fechaDividida[0]),Integer.parseInt(fechaDividida[1]),Integer.parseInt(fechaDividida[2])));
                if(receiver.getAnterior() == null){
                    receiver.setAnterior(nuevoEncuentro);
                } else{
                    receiver.setAnte_anterior(receiver.getAnterior());
                    receiver.setAnterior(nuevoEncuentro);
                }

                if(sender.getAnterior() == null){
                    sender.setAnterior(nuevoEncuentro);

                } else{
                    sender.setAnte_anterior(sender.getAnterior());
                    sender.setAnterior(nuevoEncuentro);
                }
                receiver.sendSolicitudAceptada(sender);
            case 'n':
                receiver.addSolicitudRechazada();
                sender.addSolicitudRechazada();
                receiver.sendSolicitudRechazada(sender);
        }
    }




    @Override
    public void writeNotification() {

    }
}
