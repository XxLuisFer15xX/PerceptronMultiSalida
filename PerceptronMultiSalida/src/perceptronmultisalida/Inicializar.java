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
    
<<<<<<< HEAD
    public static void Inicializar(){
        
        
    }
    
    public static boolean leerCsv(String nombreArchivo, ArrayList<ArrayList<Integer>> vectorEntrada, ArrayList<ArrayList<Integer>> vectorSalida, int nEntradas, int nSalidas){
=======
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
    
    
    public static void InicializarPerceptron(Perceptron p){
        
        // Inicializar atributos del perceptron
        int net[][] = new int[p.getnFilas()][p.getnY()];
        int out[][] = new int[p.getnFilas()][p.getnY()];
        int pesos_bias[][] = new int[p.getnFilas()][p.getnY()];
        int cambio_pesos_bias[][] = new int[p.getnFilas()][p.getnY()];
        
        for ( int i = 0 ; i < p.getnFilas() ; i++ ){
	    for ( int j = 0 ; j < p.getnY() ; j++ ){
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
        int pesos_xi[][][] = new int[p.getnFilas()][p.getnX()][p.getnY()];
        int cambio_pesos_xi[][][] = new int[p.getnFilas()][p.getnX()][p.getnY()];
        for ( int i = 0 ; i < p.getnFilas() ; i++ ){
	    for ( int k = 0 ; k < p.getnX() ; k++ ){
                for ( int j = 0 ; j < p.getnY() ; j++ ){
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
>>>>>>> fd5867bccca310392247a7a6d10ab2502211e99f
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
<<<<<<< HEAD
=======
            filas++;
>>>>>>> fd5867bccca310392247a7a6d10ab2502211e99f
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
<<<<<<< HEAD
                return true;
            }
        }
        System.out.println(vectorEntrada);
        System.out.println(vectorSalida);
        return false;
=======
                return -1;
            }
        }
        return filas;
>>>>>>> fd5867bccca310392247a7a6d10ab2502211e99f
    }
}
