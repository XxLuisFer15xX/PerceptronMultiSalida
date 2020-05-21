/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmultisalida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * 
 */
public class Funcion {
    // Funcion Activacion
    // <====={Funcion para y_inj}=====>
    public static void y_inj(
            Perceptron p,
            TablaEntrenamiento t,
            int fila,
            int salida
    ){
        int nFilas = t.getnFilas();
        int nEntradas = t.getnX();
        int nSalidas = t.getnY();
        int net = 0;
        if (fila == 0){
            net = p.getWb()[nFilas-1][salida] * t.getTablaBias()[fila][salida];
        }else{
            net = p.getWb()[fila-1][salida] * t.getTablaBias()[fila][salida];
        }
        for ( int k = 0 ; k < nEntradas ; k++ ){
            if (fila == 0){
                net += ( p.getW()[nFilas-1][k][salida] * t.getTablaEntradas()[fila][k] );
            }else{
                net += ( p.getW()[fila-1][k][salida] * t.getTablaEntradas()[fila][k] );
            }
        }
        p.setY_inj(net, fila, salida);
    }
    
    // <====={Funcion para yj}=====>
    public static void yj(
            Perceptron p,
            TablaEntrenamiento t,
            int fila,
            int salida
    ){
        int nFilas = t.getnFilas();
        int nSalidas = t.getnY();
        int net = p.getY_inj()[fila][salida];
        int out = 0;
        if (net > p.getTeta()){
            out = 1;
        } else if (   (-1)*p.getTeta() <= net   &&   net <= p.getTeta()   ){
            out = 0;
        }else if ( net < (-1)*p.getTeta() ){
            out = -1;
        }
        p.setYj(out, fila, salida);
    }
    
    public static void Ejecutar(
        Perceptron p,
        TablaEntrenamiento t
    ){
        // Prueba de los pesos
        int Y_inj = 0;
        int Yj = 0;
        System.out.println("Y_inj = (bj) + Sumatoria(xi*wij)");
        for ( int j = 0 ; j < t.getnY() ; j++ ){
            // Encabezado
            System.out.println();
            System.out.println("Y_in" + (j+1) + " = (b" + j+1 + ") + Sumatoria(xi*wi" + j+1 + ")\t\t\t\tt"+ (j+1));    
            for ( int i = 0 ; i < t.getnFilas() ; i++ ){
                Y_inj = t.getTablaBias()[i][j] * p.getWb()[i][j];
                System.out.print("Y_in" + (j+1) + " = "
                + "(" + t.getTablaBias()[i][j] + ")"
                + "(" + p.getWb()[i][j] + ")"
                + " + [") ;

                Y_inj += t.getTablaEntradas()[i][0] * p.getW()[i][0][j];
                System.out.print(" (" + t.getTablaEntradas()[i][0] + ")"
                + "(" + p.getW()[i][0][j] + ")");
                for ( int k = 1 ; k < t.getnX() ; k++ ){
                    Y_inj += t.getTablaEntradas()[i][k] * p.getW()[i][k][j];
                    System.out.print(" + (" + t.getTablaEntradas()[i][k] + ")"
                    + "(" + p.getW()[i][k][j] + ")");
                }
                System.out.print(" ] = " + Y_inj);
                
                System.out.print( "\t\t " + "t" + (j+1) + " = ");
                if (Y_inj > p.getTeta()){
                    Yj = 1;
                } else if (   (-1)*p.getTeta() <= Y_inj   &&   Y_inj <= p.getTeta()   ){
                    Yj = 0;
                }else if ( Y_inj < (-1)*p.getTeta() ){
                    Yj = -1;
                }
                System.out.println(Yj);
            }
            System.out.println();
        }
    }
    
    
    public static String EjecutarAprendisaje(
        Perceptron p,
        TablaEntrenamiento t,
        int[] entradas,
        String[] caracterLetra
    ){
        // Prueba de los pesos
        int Y_inj = 0;
        int Yj = 0;
        String letra = "Error no se reconoce la palabra";
        System.out.println("Y_inj = (bj) + Sumatoria(xi*wij)");
        int contador = 0;
        int nLetra = 0;
        for ( int j = 0 ; j < t.getnY() ; j++ ){
            // Encabezado
            System.out.println();
            System.out.println("Y_in" + (j+1) + " = (b" + j+1 + ") + Sumatoria(xi*wi" + j+1 + ")\t\t\t\tt"+ (j+1));    
            
            Y_inj = t.getTablaBias()[1][j] * p.getWb()[1][j];
            System.out.print("Y_in" + (j+1) + " = "
            + "(" + t.getTablaBias()[1][j] + ")"
            + "(" + p.getWb()[1][j] + ")"
            + " + [") ;

            Y_inj += entradas[0] * p.getW()[1][0][j];
            System.out.print(" (" + entradas[0] + ")"
            + "(" + p.getW()[1][0][j] + ")");
            for ( int k = 1 ; k < t.getnX() ; k++ ){
                Y_inj += entradas[k] * p.getW()[1][k][j];
                System.out.print(" + (" + entradas[k] + ")"
                + "(" + p.getW()[1][k][j] + ")");
            }
            System.out.print(" ] = " + Y_inj);
            
            System.out.print( "\t\t " + "t" + (j+1) + " = ");
            if (Y_inj > p.getTeta()){
                Yj = 1;
                
                contador++;
                nLetra = j;
            } else if (   (-1)*p.getTeta() <= Y_inj   &&   Y_inj <= p.getTeta() ){
                Yj = 0;
                
                contador = -1;
                j = t.getnY();
            }else if ( Y_inj < (-1)*p.getTeta() ){
                Yj = -1;
                
            }
            System.out.println(Yj);

            System.out.println();
        }
        if (contador == 1){
            letra = "La palabra correcta es: " + caracterLetra[nLetra];
        }
        return letra;
    }
    
    
    
    public static int[] cadenaEntradas(
            String palabra
            , int maxlenght
    ){
        String datosEntradas = "";
        char [] Arreglo = new char[32];
        Arreglo[0] = 'a';
        Arreglo[1] = 'b';
        Arreglo[2] = 'c';
        Arreglo[3] = 'd';
        Arreglo[4] = 'e';
        Arreglo[5] = 'f';
        Arreglo[6] = 'g';
        Arreglo[7] = 'h';
        Arreglo[8] = 'i';
        Arreglo[9] = 'j';
        Arreglo[10] = 'k';
        Arreglo[11] = 'l';
        Arreglo[12] = 'm';
        Arreglo[13] = 'n';
        Arreglo[14] = 'ñ';
        Arreglo[15] = 'o';
        Arreglo[16] = 'p';
        Arreglo[17] = 'q';
        Arreglo[18] = 'r';
        Arreglo[19] = 's';
        Arreglo[20] = 't';
        Arreglo[21] = 'u';
        Arreglo[22] = 'v';
        Arreglo[23] = 'w';
        Arreglo[24] = 'x';
        Arreglo[25] = 'y';
        Arreglo[26] = 'z';
        Arreglo[27] = 'á';
        Arreglo[28] = 'é';
        Arreglo[29] = 'í';
        Arreglo[30] = 'ó';
        Arreglo[31] = 'ú';
        
        
        for (int x = 0; x < palabra.length() ; x++){
            for (int a = 0; a < Arreglo.length; a++){
                if ( palabra.substring(x, x+1).charAt(0) == Arreglo[a]){
                    for (int b = 0; b < a; b++){
                        datosEntradas += "-1,";
                    }
                    datosEntradas += "1,";
                    for (int b = a+1; b < Arreglo.length; b++){
                        datosEntradas += "-1,";
                    }
                }
            }
        }
        for (int x = palabra.length() ; x < maxlenght ; x++){
            for (int a = 0; a < Arreglo.length; a++){
                datosEntradas += "-1,";
            }
        }
        
        
        
        String separador = ",";
        String[] valores = datosEntradas.split(separador);
        
        int z = 0;
        for (String valor: valores) {
            z++;
            System.out.println(z + ": " + valor);
        }
        
        int[] valoresEnteros = new int[valores.length];
        z = 0;
        for (String valor: valores) {
            valoresEnteros[z] = Integer.parseInt(valor);
            z++;
        }
        
        
        return valoresEnteros;
    }
    
    public static String cadenaSalidas(
        String[] palabras
        , String palabra
    ){
        String datosSalidas = "";
        for (int a = 0; a < palabras.length ; a++){
            if (palabra == palabras[a]){
                for (int b = 0; b < a; b++){
                    datosSalidas += "-1,";
                }
                datosSalidas += "1,";
                for (int b = a+1; b < palabras.length; b++){
                    datosSalidas += "-1,";
                }
            }
        }
        return datosSalidas.substring(0, datosSalidas.length() - 1);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static String mapaDatos(
        String[] palabras
        , String palabra
        , char Arreglo[]
        , int maxlenght
    ){
        String datosEntradas = "";
        String datosSalidas = "";
        
        //Datos Entrada
        for (int x = 0; x < palabra.length() ; x++){
            for (int a = 0; a < Arreglo.length; a++){
                if ( palabra.substring(x, x+1).charAt(0) == Arreglo[a]){
                    for (int b = 0; b < a; b++){
                        datosEntradas += "-1,";
                    }
                    datosEntradas += "1,";
                    for (int b = a+1; b < Arreglo.length; b++){
                        datosEntradas += "-1,";
                    }
                }
            }
        }
        for (int x = palabra.length() ; x < maxlenght ; x++){
            for (int a = 0; a < Arreglo.length; a++){
                datosEntradas += "-1,";
            }
        }
        
        //Datos Salida
        for (int a = 0; a < palabras.length ; a++){
            if (palabra == palabras[a]){
                for (int b = 0; b < a; b++){
                    datosSalidas += "-1,";
                }
                datosSalidas += "1,";
                for (int b = a+1; b < palabras.length; b++){
                    datosSalidas += "-1,";
                }
            }
        }
        datosSalidas = datosSalidas.substring(0, datosSalidas.length() - 1);
        
        String separador = ",";
        String[] valores = (datosEntradas + datosSalidas).split(separador);
        
        
        int z = 0;
        for (String valor: valores) {
            z++;
            System.out.println(z + ": " + valor);
        }
        System.out.println( datosSalidas  );
        

        return datosEntradas + datosSalidas;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //almacena las palabras en un arreglo, las palabras las toma del archivo llamado palabras.csv que ya no contiene las tildes
    //FUNCION DOS
    public static String[] leer_Archivo_Arreglo(String nombreArchivo, int nPalabras) throws IOException {
        
        int cantidadPalabras = nPalabras;
        int i = 0;
        String cadena = "";
        String palabras="";
        String file = nombreArchivo;
        
        String[] arregloPalabras = new String[cantidadPalabras];
        
        new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
        try {
      
            
            
            while ((cadena = in.readLine()) != null) {
               arregloPalabras[i]=cadena;
               i = i + 1;
            }
            
            
            
        } catch (Exception e) {

        } finally {
            in.close();
        }
        return arregloPalabras;
        
         
    }
}
