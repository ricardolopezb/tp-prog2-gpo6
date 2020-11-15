package estadistica;

import archivos.Archivo;
import usuarios.Ciudadano;

import java.util.ArrayList;

public class BroteChecker {
    private final ArrayList<Zona> zonas;

    // caso positivo:  cuil@zona
    // encuentrosAceptados: sender.getCUIL()+"-"+receiver.getCUIL()


    public BroteChecker(ArrayList<Zona> zonasExistentes) {
        this.zonas = zonasExistentes;
    }

    public Brote checkBrotes(){
        if(!checkQuantity()) return null;

        if(checkPositiveContact()){
            Brote broteEncontrado = new Brote();
        }



    }


    private boolean checkQuantity(){
        ArrayList<String> casosPositivos = Archivo.collectFileLines("CasosPositivos.txt");
        if(casosPositivos.size() < 5) return false;

        for (Zona zona: zonas) {
            ArrayList<Ciudadano> ciudadanosDeZona = Archivo.searchCiudadanosPorZona(zona.getNombre());
            int positivos = 0;
            for (Ciudadano ciudadano : ciudadanosDeZona) {
                if(ciudadano.getCovid()){
                    positivos++;
                }
            }
            if(positivos >= 5){
                return true;
            }

        }



        return ;

    }


    public String[] checkIntermediario(){
        ArrayList<String> lineasEncuentros = Archivo.collectFileLines("EncuentrosAceptados.txt");
        String[] toReturn = new String[3];
        for (int i = 0; i < lineasEncuentros.size(); i++) {
            String[] cuilsInvolucrados = lineasEncuentros.get(i).split("-");
            for (int j = 0; j < lineasEncuentros.size(); j++) {
                String[] otraLinea_cuils = lineasEncuentros.get(j).split("-");
                if(cuilsInvolucrados[0].equals(otraLinea_cuils[1])){
                    toReturn[0] = cuilsInvolucrados[0];
                    toReturn[1] = cuilsInvolucrados[1];
                    toReturn[3] = otraLinea_cuils[0];
                }
            }
        }
        return null;
    }

    public boolean checkPositiveContact(){
        String[] datosContagio = checkIntermediario();
        if(datosContagio == null) return false;

        Ciudadano intermediario = Archivo.searchCUIL(datosContagio[0]);
        Ciudadano receptorDeCovid = Archivo.searchCUIL(datosContagio[1]);
        Ciudadano vectorDeCovid = Archivo.searchCUIL(datosContagio[3]);

        return intermediario.getCovid() && vectorDeCovid.getCovid() && receptorDeCovid.getCovid();



    }





}
