package notificaciones;

import usuarios.Ciudadano;

public class AcceptedContactNotification extends Notification {

    public AcceptedContactNotification(Ciudadano receiver, Ciudadano sender) {
        super(receiver, sender);
    }

    @Override
    public String serialize() {
        String toSerialize = "accept@"+ receiver.getCUIL() + "@" +sender.getCUIL() ;
        return toSerialize;

    }

    @Override
    public void printNotification() {
        String toPrint = "Su solicitud de contacto ha sido aceptada por " + sender.getNombre();
        System.out.println(toPrint);

    }
}
