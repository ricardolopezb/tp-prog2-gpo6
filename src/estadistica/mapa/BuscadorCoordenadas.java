package estadistica.mapa;

import archivos.Archivo;
import de.fhpotsdam.unfolding.geo.Location;
import util.ScriptPython;
import util.MetodosAuxiliares;

import java.io.File;
import java.util.ArrayList;

public class BuscadorCoordenadas {

    public static Location getCoordenadas(String zona){
        Archivo.writeFile(zona, "Zona.txt");
        ScriptPython scriptPython = new ScriptPython();
        scriptPython.runScript();
        MetodosAuxiliares.delay(12000);
        ArrayList<String> coordenadas = Archivo.collectFileLines("Coordenadas.txt");
        File residuoPy = new File("src\\archivos\\Coordenadas.txt");
        residuoPy.delete();

        String strCoord = coordenadas.get(0);
        String[] coordsDivididas = strCoord.split(",");
        float latitud = Float.parseFloat(coordsDivididas[0]);
        float longitud = Float.parseFloat(coordsDivididas[1]);
        Archivo.removeLine(zona, "Zona.txt");

        return new Location(latitud, longitud);
    }




}
