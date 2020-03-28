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
        
        
        Inicializar.InicializarTablaEntrenamiento(tabla_verdad, vectorEntrada, vectorSalida);
        Inicializar.InicializarPerceptron(perceptron1);
        
        
        Entrenamiento.Entrenar(
                perceptron1,
                tabla_verdad,
                numeroFilas,
                numeroEntradas,
                numeroSalidas,
                alfa,
                teta
        );
        
        System.out.println("<===== {Informacion Basica del Perceptron} =====>");
        Resultado.MostrarPerceptronAtributos(perceptron1);
        
        System.out.println("<===== {Informacion de las Entradas} =====>");
        Resultado.MostrarTablaEntradas(tabla_verdad, numeroFilas, numeroEntradas);
        Resultado.MostrarTablaTarget(tabla_verdad, numeroFilas, numeroSalidas);
        Resultado.MostrarTablaBias(tabla_verdad, numeroFilas, numeroSalidas);
        System.out.println("");
        
        System.out.println("<===== {Informacion de los Pesos} =====>");
        Resultado.MostrarPerceptronWeight(perceptron1, numeroFilas, numeroEntradas, numeroSalidas);
        Resultado.MostrarPerceptronWeightChange(perceptron1, numeroFilas, numeroEntradas, numeroSalidas);
        
        System.out.println("<===== {Informacion de la Funcion de Activacion} =====>");
        Resultado.MostrarPerceptronFuncion(perceptron1, numeroFilas, numeroSalidas);
        
        System.out.println("");
        System.out.println("<===== {Ejecución del Perceptron} =====>");
        Funcion.Ejecutar(perceptron1, tabla_verdad, teta);
    }
}
