/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Scanner;
import perceptronmultisalida.Inicializar;
import perceptronmultisalida.TablaEntradas;

/**
 *
 * @author Luis Fernando
 */
public class testInicializar {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> vectorEntrada = new ArrayList<>();
        ArrayList<ArrayList<Integer>> vectorSalida = new ArrayList<>();
        
        
        
        Scanner teclado = new Scanner(System.in);
        int numeroEntradas;
        int numeroSalidas;
        int alfa;
        int teta;
        String nombreDocumento = "";
        
        
        System.out.println("Defina la cantidad de entradas xi: ");
        numeroEntradas = teclado.nextInt();
        System.out.println("Defina la cantidad de neuronas yj");
        numeroSalidas = teclado.nextInt();;
        System.out.println("Especifique el nombre del documento que contiene las entradas");
        nombreDocumento = teclado.next();
        nombreDocumento += ".csv";
        
        boolean leerDocumento = Inicializar.leerCsv(nombreDocumento, vectorEntrada, vectorSalida, numeroEntradas, numeroSalidas);
        if (leerDocumento){
            System.out.println("Error al leer el documento, los datos no coinciden con las entras y salidas especificadas");
        }
        
        System.out.println("");
        System.out.println(vectorEntrada);
        System.out.println(vectorSalida);
        
        
        //TablaEntradas tabla_verdad = new TablaEntradas(,,);
        
        
        
        /*
        System.out.println("Defina la taza de aprendisaje alfa");
        alfa = teclado.nextInt();;
        System.out.println("Defina el Umbral teta");
        teta = teclado.nextInt();;
        */
        
    }
}
