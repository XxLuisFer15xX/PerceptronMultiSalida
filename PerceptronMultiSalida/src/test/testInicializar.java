/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Scanner;
import perceptronmultisalida.Entrenamiento;
import perceptronmultisalida.Funcion;
import perceptronmultisalida.Inicializar;
import perceptronmultisalida.Perceptron;
import perceptronmultisalida.Resultado;
import perceptronmultisalida.TablaEntrenamiento;

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
        int numeroFilas;
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
        
        numeroFilas = Inicializar.leerFilasCsv(nombreDocumento,
                vectorEntrada,
                vectorSalida,
                numeroEntradas,
                numeroSalidas
        );
        if (numeroFilas == -1){
            System.out.println("Error al leer el documento, los datos no coinciden con las entras y salidas especificadas");
        }
        
        System.out.println("Defina la taza de aprendisaje alfa");
        alfa = teclado.nextInt();;
        System.out.println("Defina el Umbral teta");
        teta = teclado.nextInt();;
        
        
        
        System.out.println("");
        System.out.println(vectorEntrada);
        System.out.println(vectorSalida);
        System.out.println("Filas " + numeroFilas);        
        System.out.println("\n");
        
        
        
        // Instancia Tabla_Verdad
        TablaEntrenamiento tabla_verdad = new TablaEntrenamiento(
                numeroEntradas,
                numeroSalidas,
                numeroFilas,
                new int[numeroFilas][numeroEntradas],
                new int[numeroFilas][numeroSalidas],
                new int[numeroFilas][numeroSalidas]
        );
        
        // Instancia Perceptron
        Perceptron perceptron1 = new Perceptron(
                alfa,
                teta,
                numeroEntradas,
                numeroSalidas,
                numeroFilas,
                new int[numeroFilas][numeroEntradas][numeroSalidas],
                new int[numeroFilas][numeroSalidas],
                new int[numeroFilas][numeroEntradas][numeroSalidas],
                new int[numeroFilas][numeroSalidas],
                new int[numeroFilas][numeroSalidas],
                new int[numeroFilas][numeroSalidas]
        );
        
        System.out.println("Inicializar Tabla_Verdad");
        Inicializar.InicializarTablaEntrenamiento(tabla_verdad, vectorEntrada, vectorSalida);
        System.out.println(tabla_verdad.getTablaEntradas()[6][1]);
        System.out.println(tabla_verdad.getTablaTarget()[6][0]);
        System.out.println(tabla_verdad.getTablaBias()[6][0]);
        System.out.println("");
        
        System.out.println("Inicializar Perceptron");
        Inicializar.InicializarPerceptron(perceptron1);
        System.out.println(perceptron1.getW()[6][2][1]);
        System.out.println(perceptron1.getWb()[6][1]);
        System.out.println(perceptron1.getWChange()[6][2][1]);
        System.out.println(perceptron1.getWbChange()[6][1]);
        System.out.println(perceptron1.getY_inj()[6][1]);
        System.out.println(perceptron1.getYj()[6][1]);
        System.out.println("");
        
        
        Entrenamiento.Entrenar(
                perceptron1,
                tabla_verdad,
                numeroFilas,
                numeroEntradas,
                numeroSalidas,
                alfa,
                teta
        );
        System.out.println();
        
        
        Resultado.MostrarTablaEntradas(tabla_verdad, numeroFilas, numeroEntradas);
        Resultado.MostrarTablaTarget(tabla_verdad, numeroFilas, numeroSalidas);
        Resultado.MostrarTablaBias(tabla_verdad, numeroFilas, numeroSalidas);
        System.out.println("");
        Resultado.MostrarPerceptronAtributos(perceptron1);
        Resultado.MostrarPerceptronWeight(perceptron1, numeroFilas, numeroEntradas, numeroSalidas);
        Resultado.MostrarPerceptronWeightChange(perceptron1, numeroFilas, numeroEntradas, numeroSalidas);
        Resultado.MostrarPerceptronFuncion(perceptron1, numeroFilas, numeroSalidas);
        
        /*
        //Funcion.y_inj(perceptron1, tabla_verdad, numeroFilas, numeroEntradas, numeroSalidas, 0, 1);
        //Funcion.yj(perceptron1, numeroFilas, numeroSalidas, 0, 1, teta);
        
        
        */
        
        /*
        // Mostrar Tablas
	for ( int i = 0 ; i < numeroFilas ; i++ ){
	    System.out.print("f"+i+"  ");
	    for ( int j = 0 ; j < numeroSalidas ; j++ ){
	        System.out.print("y"+j+" ");
	    }
	    System.out.println();
	    System.out.println("Pesos:" );
	    for ( int k = 0 ; k < numeroEntradas ; k++ ){
	        System.out.print("x" + k + ": ");
	        for ( int j = 0 ; j < numeroSalidas ; j++ ){
	            System.out.print( perceptron1.getW()[i][k][j] + "  ");
	        }
	        System.out.println();
	    }
	    
	    System.out.println();
            System.out.println();
	}
        */
    }
}
