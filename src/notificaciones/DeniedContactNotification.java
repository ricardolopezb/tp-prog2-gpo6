package notificaciones;

import usuarios.Ciudadano;

public class DeniedContactNotification extends Notification {


    public DeniedContactNotification(Ciudadano receiver,Ciudadano sender) {
        super(receiver, sender);
    }

    @Override
    public String serialize() {
        String toSerialize = "negacion@"+ receiver.getCUIL() + "@" +sender.getCUIL() ;
        return toSerialize;
    }

    @Override
    public void printNotification() {
        String toPrint = "Su solicitud de contacto ha sido negada por " + sender.getNombre();
        System.out.println(toPrint);

    }

}
