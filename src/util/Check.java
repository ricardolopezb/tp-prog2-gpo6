package util;

public class Check {


    public static boolean checkCUIL(String cuil){
        //chequear que el numero que se ingrese es valido en forma, o sea que tenga la cant de numeros que son, que no haya espacios,
        return checkNumero(cuil, 11);

    }

    public static boolean checkCelular(String celular) {
        return checkNumero(celular, 10);
    }


    private static boolean checkNumero(String numero, int digitos){
        //lo mismo que arriba. un numero de tlf tiene 10 digitos
        if (numero == null || numero.length() != digitos) {
            return false;
        }
        try {
            int x = Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
        }

    /*public static boolean checkAnses(String CUIL, String celular){ //este metodo se usa solo en el registro
        return true;
        //un metodo para chequear que el cuil y el numero esten en el .txt y que esten juntos.
    }*/

    // metodo que chequea el log in en la base nuestra



}
