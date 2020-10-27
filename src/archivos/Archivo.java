package archivos;

import entidades.Encuentro;
import entidades.Evento;
import entidades.Fecha;
import usuarios.Ciudadano;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Archivo {

    public static void addToLocal(Ciudadano c){
        writeFile(c.toString(), "BaseLocal.txt");
    }

    public static void overwrite(Ciudadano ciudadano){
        removeLocal(ciudadano);
        addToLocal(ciudadano);
    }

    public static void removeLine(String toRemove, String file){
        ArrayList<String> allLines = collectFileLines(file);
        for(Iterator<String> itr = allLines.iterator(); itr.hasNext();){
            String line = itr.next();
            if(line.startsWith(toRemove)){
                itr.remove();
                cleanFile(file);
            }

        }
        for (String line : allLines) {
            writeFile(line, file);

        }
    }


    public static void removeLocal(Ciudadano c){
        removeLine(c.getCUIL(), "BaseLocal.txt");
    }


    public static boolean checkCuilInLocal(String cuil){
        return searchCUIL(cuil) != null;
    }
    public static boolean checkCelInLocal(String celular){
        return searchCelular(celular) != null;
    }

    private static void cleanFile(String file){
        try {
            PrintWriter writer = new PrintWriter(new File(("src\\archivos\\"+file)));
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Ciudadano decode(String info){
        //CUIL\t Celular\t Bloqueado\t Zona\t Rechazos\t Sintoma1,Sintoma2,Sintoma3\t    (2002049954(CUIL CIUD 1),1924894392(CUIL CIUD 2),100920(Fecha de Inicio en numero)


        String[] tabSplit = info.split("\t");

        String cuil = tabSplit[0];
        String celular = tabSplit[1];
        String zona = tabSplit[3];
        boolean block = Boolean.parseBoolean(tabSplit[2]);
        int rechazos = Integer.parseInt(tabSplit[4]);
        String sintomasNoSplit = tabSplit[5];
        String encuentro1NoSplit = tabSplit[6];
        String encuentro2NoSplit = tabSplit[7];

        ArrayList<Evento> sintomas;
        Encuentro e1;
        Encuentro e2;

        if(sintomasNoSplit.equals("null")){
            sintomas = new ArrayList<Evento>();
        } else{
            sintomas = new ArrayList<>();
            String[] sintomasSplit = sintomasNoSplit.split(",");
            for (String s: sintomasSplit) {
                sintomas.add(new Evento(s));
            }
        }

        if(encuentro1NoSplit.equals("null")){
            e1 = null;
        } else{
            String[] encuentro1Split = encuentro1NoSplit.split(",");
            //String[] fch1 = encuentro1Split[2].split("-");
            //int[]f1 = new int[3];;
            //for (int i = 0; i < fch1.length ; i++) {
            //    f1[i] = Integer.parseInt(fch1[i]);
            //}
            //Fecha fecha1 = new Fecha(f1[0], f1[1], f1[2]);


            String[] fch2 = encuentro1Split[3].split("-");
            int[]f2 = new int[3];
            for (int i = 0; i < fch2.length ; i++) {
                f2[i] = Integer.parseInt(fch2[i]);
            }

            Fecha fecha2 = new Fecha(f2[0], f2[1], f2[2]);
            // fecha1, estaba en los parametros del constructor.
            e1 = new Encuentro(encuentro1Split[0], encuentro1Split[1], fecha2);

        }
        if(encuentro2NoSplit.equals("null")){
            e2 = null;
        } else{
            String[] encuentro2Split = encuentro2NoSplit.split(",");
            //String[] fch3 = encuentro2Split[2].split("-");
            //int[]f3 = new int[3];;
            //for (int i = 0; i < fch3.length ; i++) {
            //    f3[i] = Integer.parseInt(fch3[i]);
            //}
            //Fecha fecha3 = new Fecha(f3[0], f3[1], f3[2]);


            String[] fch4 = encuentro2Split[3].split("-");
            int[]f4 = new int[3];
            for (int i = 0; i < fch4.length ; i++) {
                f4[i] = Integer.parseInt(fch4[i]);
            }

            Fecha fecha4 = new Fecha(f4[0], f4[1], f4[2]);
            //en los parametros de aca abajo estaba fecha3, como fecha de inicio.
            e2 = new Encuentro(encuentro2Split[0], encuentro2Split[1],  fecha4);
        }

        return new Ciudadano(cuil, celular, block, zona, rechazos, sintomas, e1, e2);




    }

    private static Ciudadano searchCiudadanoBy(String criterio, int posicion){
        try(BufferedReader br = new BufferedReader(new FileReader("src\\archivos\\BaseLocal.txt"));){
            String line = br.readLine();
            while(line != null){
                String[] x = line.split("\t");
                if(criterio.equals(x[posicion])){
                    return decode(line);
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Ciudadano searchCUIL(String CUIL){
        return searchCiudadanoBy(CUIL, 0);
    }

    public static Ciudadano searchCelular(String cel){
        return searchCiudadanoBy(cel, 1);
    }

    public static void writeFile(String toWrite, String file){
        //metodo para abstraer escribir en un archivo.

        String directory = "src\\archivos\\" + file;
        try(BufferedWriter br = new BufferedWriter(new FileWriter(directory, true));){
            br.write(toWrite + "\n");
        } catch(IOException e){
            e.getMessage();
        }
    }

    public static void printFileLines(String file){
        ArrayList<String> lines = collectFileLines(file);
        int i = 1;
        for (String line: lines) {
            System.out.println(i + ". "+line);
            i++;
        }
    }

    public static ArrayList<String> collectFileLines(String file){
        String directory = "src\\archivos\\" + file;
        ArrayList<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(directory));){
            String line = br.readLine();
            int i = 0;
            while(line != null){
                lines.add(line);
                line = br.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
