/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import static java.lang.Math.pow;
  import perceptronmultisalida.Funcion;

/**
 *
 * @author Luis Fernando
 */
public class testFuncion {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int teta = 0;
	
        
        // Definir entradas
	int numeroEntradas = 3;
	
	// Definir salidas
	int numeroSalidas = 2;
        
        // <=====[Inicializar tabla de la verdad]=====>
	// Arreglo tabla de la verdad
	int filas = (int) pow(2, numeroEntradas); 
	int columnas = numeroEntradas;
	int tabla_verdad[][]= new int[filas][columnas];
        
        // Paso 3
	// LLenar Tabla de la Verdad
	for ( int j = 0 ; j < columnas ; j++ ){
	    
	    int veces = (int)pow( 2, ((columnas-j) -1) );
	    int exponente = 0;
	    
	    for ( int i = 0 ; i < filas ; i++ ){
	        
	        for ( int x = 1 ; x <= veces ; x++){
	            tabla_verdad[i][j] = (int)pow(-1, exponente);
	            i++;
	        }
	        i--;
	        exponente++;
	    }
	}
        
         // <=====[Inicializar NET, OUT, Pesos y Bias]=====>
	// Arreglo NET, OUT y Bias
	int NET[][] = new int[filas][numeroSalidas];
	int OUT[][] = new int[filas][numeroSalidas];
	int bias[][] = new int[filas][numeroSalidas];
	int pesos_bias[][] = new int[filas][numeroSalidas];
	int cambio_pesos_bias[][] = new int[filas][numeroSalidas];
        
        for ( int j = 0 ; j < numeroSalidas ; j++ ){
	    for ( int i = 0 ; i < filas ; i++ ){
	        NET[i][j] = 0;
	        OUT[i][j] = 0;
	        bias[i][j] = 1;
	        pesos_bias[i][j] = 0;
	        cambio_pesos_bias[i][j] = 0;
	    }
	}
        
        
        // Arreglo Pesos
	int xi = numeroEntradas;
	int yj = numeroSalidas;
	
	int pesos_xi[][][] = new int[filas][xi][yj];
	int cambio_pesos_xi[][][] = new int[filas][xi][yj];
	
	for ( int i = 0 ; i < filas ; i++ ){
	    for ( int k = 0 ; k < xi ; k++ ){
	        for ( int j = 0 ; j < yj ; j++ ){
	            pesos_xi[i][k][j] = 0;
	            cambio_pesos_xi[i][k][j] = 0;
	        }
	    }
	}
        
        
        
        Funcion funcion = new Funcion(bias, pesos_bias, pesos_xi, tabla_verdad, OUT, teta, cambio_pesos_xi, filas, yj, xi,columnas);
        
        funcion.funcion();
 
        
    }
}
