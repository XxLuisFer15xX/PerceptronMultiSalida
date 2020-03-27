/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static java.lang.Math.pow;
import perceptronmultisalida.Entrenamiento;

/**
 *
 * @author Luis Fernando
 */
public class testEntrenamiento {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int teta = 0;
	int alfa = 1;
        
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
        
        // Mostrar Tabla
	/*
	for ( int i = 0 ; i < filas ; i++ ){
	    for ( int j = 0 ; j < numeroSalidas ; j++ ){
	        cout << cambio_pesos_bias[i][j] << " ";
	    }
	    cout << endl;
	}
	cout << endl << endl;
	*/
        
        // Paso 0
	// <=====[Inicializar Target]=====>
	// Arreglo Target
	int target[][] = new int[filas][numeroSalidas];
	/*
	for ( int j = 0 ; j < numeroSalidas ; j++ ){
	    cout << "Ingrese: " << filas << " filas para la columna: " << j << endl;
	    for ( int i = 0 ; i < filas ; i++ ){
	        cout << "Fila " << i << " : ";
	        cin >> target[i][j];
	    }
	    cout << endl;
	}
	*/
        
        target[0][0] = 1;
	target[1][0] = -1;
	target[2][0] = 1;
	target[3][0] = -1;
	
	target[4][0] = 1;
	target[5][0] = -1;
	target[6][0] = 1;
	target[7][0] = -1;
	
	target[0][1] = 1;
	target[1][1] = 1;
	target[2][1] = 1;
	target[3][1] = 1;
	
	target[4][1] = -1;
	target[5][1] = -1;
	target[6][1] = -1;
	target[7][1] = -1;
        
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
        
        
    }
}
