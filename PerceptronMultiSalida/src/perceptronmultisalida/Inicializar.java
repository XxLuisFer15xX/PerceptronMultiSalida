/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmultisalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luis Fernando
 */
public class Inicializar {
    
    public static void InicializarTablaEntrenamiento(
            TablaEntrenamiento t,
            ArrayList<ArrayList<Integer>> vectorEntrada
            , ArrayList<ArrayList<Integer>> vectorSalida
    ){
        
        
        // Inicializar TablaEntradas
        int tablaEntradas[][] = new int[t.getnFilas()][t.getnX()];
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            for ( int j = 0 ; j < t.getnX() ; j++ ){
                tablaEntradas[i][j] = vectorEntrada.get(i).get(j);
            }
	}
        t.setTablaEntradas(tablaEntradas);
        
        // Inicializar Target
        int tablaTarget[][] = new int[t.getnFilas()][t.getnY()];
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            for ( int j = 0 ; j < t.getnY() ; j++ ){
                tablaTarget[i][j] = vectorSalida.get(i).get(j);
            }
	}
        t.setTablaTarget(tablaTarget);
        
        // Inicializar Bias
        int bias[][] = new int[t.getnFilas()][t.getnY()];
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            for ( int j = 0 ; j < t.getnY() ; j++ ){
                bias[i][j] = 1;
            }
	}
        t.setTablaBias(bias);
    }
    
    
    public static void InicializarPerceptron(Perceptron p, TablaEntrenamiento t){
        
        // Inicializar atributos del perceptron
        int net[][] = new int[t.getnFilas()][t.getnY()];
        int out[][] = new int[t.getnFilas()][t.getnY()];
        int pesos_bias[][] = new int[t.getnFilas()][t.getnY()];
        int cambio_pesos_bias[][] = new int[t.getnFilas()][t.getnY()];
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
	    for ( int j = 0 ; j < t.getnY() ; j++ ){
                net[i][j] = 0;
                out[i][j] = 0;
                pesos_bias[i][j] = 0;
                cambio_pesos_bias[i][j] = 0;
            }
        }
        p.setYj(net);
        p.setY_inj(out);
        p.setWb(pesos_bias);
        p.setWbChange(cambio_pesos_bias);
        
        // Inicializar Atributos Pesos
        int pesos_xi[][][] = new int[t.getnFilas()][t.getnX()][t.getnY()];
        int cambio_pesos_xi[][][] = new int[t.getnFilas()][t.getnX()][t.getnY()];
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
	    for ( int k = 0 ; k < t.getnX() ; k++ ){
                for ( int j = 0 ; j < t.getnY() ; j++ ){
                    pesos_xi[i][k][j] = 0;
                    cambio_pesos_xi[i][k][j] = 0;
                }
            }
        }
        p.setW(pesos_xi);
        p.setWChange(cambio_pesos_xi);
    }
    
    
    
    public static int leerFilasCsv(
            String nombreArchivo
            , ArrayList<ArrayList<Integer>> vectorEntrada
            , ArrayList<ArrayList<Integer>> vectorSalida
            , int nEntradas
            , int nSalidas
    ){
        
        
        
        int filas = 0;
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
            filas++;
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
                return -1;
            }
        }
        return filas;
    }

    public static void DigitalizarCSV(String[] Datos, String nombreArchivo){
        String salidaArchivo = nombreArchivo;
        boolean existe= new File(salidaArchivo).exists();

        if(existe){
            File archivo = new File(salidaArchivo);
            archivo.delete();
        }

        try{
            Cswriter salidaCSV = new CsvWriter (new FileWriter(salidaArchivo, true), ',');
            
            for(String data: Datos){
                salidaCSV.write(data);

                salidaCSV.endRecord();
            }

            salidaCSV.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
