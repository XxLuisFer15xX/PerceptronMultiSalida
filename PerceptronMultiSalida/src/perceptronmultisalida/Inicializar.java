/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmultisalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luis Fernando
 */
public class Inicializar {
    
    public static void Inicializar(){
        
        
    }
    
    public static boolean leerCsv(String nombreArchivo, ArrayList<ArrayList<Integer>> vectorEntrada, ArrayList<ArrayList<Integer>> vectorSalida, int nEntradas, int nSalidas){
        File file= new File(nombreArchivo);

        // this gives you a 2-dimensional array of strings
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // the following code lets you iterate through the 2-dimensional array
        for(List<String> line: lines) {
            int columnNo = 1;
            ArrayList<Integer> lineaEntrada = new ArrayList<>();            
            ArrayList<Integer> lineaSalida = new ArrayList<>();
            for (String value: line) {
                if(columnNo <= nEntradas){
                    lineaEntrada.add(Integer.parseInt(value));
                } else{
                    lineaSalida.add(Integer.parseInt(value));
                }
                columnNo++;
            }
            if (columnNo-1 == (nEntradas + nSalidas)){
                vectorEntrada.add(lineaEntrada);
                vectorSalida.add(lineaSalida);
            }else{
                vectorEntrada.clear();
                vectorSalida.clear();
                return true;
            }
        }
        System.out.println(vectorEntrada);
        System.out.println(vectorSalida);
        return false;
    }
}
