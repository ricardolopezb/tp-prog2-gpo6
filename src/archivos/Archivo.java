package archivos;

import entidades.Encuentro;
import entidades.Evento;
import entidades.Fecha;
import usuarios.Ciudadano;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

    public static void addToLocal(Ciudadano c){
        writeFile(c.toString(), "BaseLocal.txt");
    }

    public static void removeLocal(Ciudadano c){
        String toRemove = c.toString();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src\\archivos\\BaseLocal.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\archivos\\BaseLocal.txt"));

            String currentLine;

            while(null != (currentLine = reader.readLine())) {
                if(currentLine.trim().equals(toRemove)){
                    writer.write("");
                    writer.close();
                    reader.close();
                    break;
                }

            }

        } catch(IOException e){
            e.getMessage();
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
            sintomas = null;
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
            String[] fch1 = encuentro1Split[2].split("-");
            int[]f1 = new int[3];;
            for (int i = 0; i < fch1.length ; i++) {
                f1[i] = Integer.parseInt(fch1[i]);
            }
            Fecha fecha1 = new Fecha(f1[0], f1[1], f1[2]);


            String[] fch2 = encuentro1Split[3].split("-");
            int[]f2 = new int[3];
            for (int i = 0; i < fch2.length ; i++) {
                f2[i] = Integer.parseInt(fch2[i]);
            }

            Fecha fecha2 = new Fecha(f2[0], f2[1], f2[2]);
            e1 = new Encuentro(encuentro1Split[0], encuentro1Split[1], fecha1, fecha2);

        }
        if(encuentro2NoSplit.equals("null")){
            e2 = null;
        } else{
            String[] encuentro2Split = encuentro2NoSplit.split(",");
            String[] fch3 = encuentro2Split[2].split("-");
            int[]f3 = new int[3];;
            for (int i = 0; i < fch3.length ; i++) {
                f3[i] = Integer.parseInt(fch3[i]);
            }
            Fecha fecha3 = new Fecha(f3[0], f3[1], f3[2]);


            String[] fch4 = encuentro2Split[3].split("-");
            int[]f4 = new int[3];
            for (int i = 0; i < fch4.length ; i++) {
                f4[i] = Integer.parseInt(fch4[i]);
            }

            Fecha fecha4 = new Fecha(f4[0], f4[1], f4[2]);
            e2 = new Encuentro(encuentro2Split[0], encuentro2Split[1], fecha3, fecha4);
        }

        return new Ciudadano(cuil, celular, block, zona, rechazos, sintomas, e1, e2);




    }

    public static Ciudadano searchCUIL(String CUIL){
        try(BufferedReader br = new BufferedReader(new FileReader("src\\archivos\\BaseLocal.txt"));){
            String line = br.readLine();
            while(line != null){
                String[] x = line.split("\t");
                if(CUIL.equals(x[0])){
                    return decode(line);
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Ciudadano searchCelular(String cel){
        try(BufferedReader br = new BufferedReader(new FileReader("src\\archivos\\BaseLocal.txt"));){
            String line = br.readLine();
            while(line != null){
                String[] x = line.split("\t");
                if(cel.equals(x[1])){
                    return decode(line);
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
        for (String line: lines) {
            System.out.println(line);
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
