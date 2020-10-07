package util;

public class MetodosAuxiliares {

    public static void delay(int millis){
        try{
            Thread.sleep(millis);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
