/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import ClasesAdicionales.Globals;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import perceptronmultisalida.Funcion;
/**
 *
 * @author Luis Fernando
 */
public class NewClass {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //hola
        Scanner teclado = new Scanner(System.in);
        
        
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
        /*
        for (int a = 0; a < 27; a++){
            System.out.println(Arreglo[a]);
        }
        */
        /*
        char caracter;
        caracter = teclado.next().charAt(0);
        System.out.println( "Ingreso la letra" + caracter);
        
        for (int a = 0; a < 27; a++){
            if (caracter == Arreglo[a]){
                    for (int b = 0; b < a; b++){
                    System.out.print("-1,");
                }
                System.out.print("1,");
                for (int b = a+1; b < 27; b++){
                    System.out.print("-1,");
                }
                System.out.println("");
            }
        }
        */
        
        int cantidadPalabras = 2;
        String [] palabras = new String[cantidadPalabras];
        palabras[0] = "de";
        
        palabras[1] = "la";/*
        palabras[2] = "enderman";
        palabras[3] = "juegos";
        palabras[4] = "minecraft";*/
        
        for (String palabra: palabras) {
            System.out.println(Funcion.mapaDatos(palabras, palabra, Arreglo, 23));
            System.out.println("");
        }
        
        /*
        String cadena = "hola";
        System.out.println();
        String datosSalidas = "";
        for (int a = 0; a < palabras.length ; a++){
            if (cadena == palabras[a]){
                for (int b = 0; b < a; b++){
                    datosSalidas += "-1,";
                }
                datosSalidas += "1,";
                for (int b = a+1; b < palabras.length; b++){
                    datosSalidas += "-1,";
                }
            }
        }
        System.out.println(datosSalidas);
        System.out.println (new File ("").getAbsolutePath ());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        String[] arregloPalabras = Funcion.leer_Archivo_Arreglo("Lista_de_Palabras2.csv", 1000);
        
        for (int i = 0; i < 1000; i++) {
            
            System.out.println(arregloPalabras[i]);
            
        }
        
        
        
        /*
        for (int x = 0; x < palabra.length() ; x++){
            for (int a = 0; a < 27; a++){
                if ( palabra.substring(x, x+1).charAt(0) == Arreglo[a]){
                    for (int b = 0; b < a; b++){
                        datosEntradas += "-1,";
                    }
                    datosEntradas += "1,";
                    for (int b = a+1; b < 27; b++){
                        datosEntradas += "-1,";
                    }
                }
            }
        }
        for (int x = palabra.length() ; x < 23 ; x++){
            for (int a = 0; a < 27; a++){
                datosEntradas += "-1,";
            }
        }
        datosEntradas += "\n";
        
        
        /*
        String separador = ",";
        String[] valores = datosEntradas.split(separador);
        int z = 0;
        for (String valor: valores) {
            z++;
            System.out.println(z + ": " + valor);
        }
        */
        
        
        
    }
}
