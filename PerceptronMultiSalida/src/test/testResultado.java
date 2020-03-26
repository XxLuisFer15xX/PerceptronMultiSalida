/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import static java.lang.Math.pow;
  import perceptronmultisalida.Resultado;
/**
 *
 * @author Luis Fernando
 */
public class testResultado {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numeroEntradas = 3;
	
	int numeroSalidas = 2;
	int filas = (int) pow(2, numeroEntradas); 
	int columnas = numeroEntradas;
	int tabla_verdad[][]= new int[filas][columnas];
        
        
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

	// Arreglo Target
	int target[][] = new int[filas][numeroSalidas];
	
  
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
        
        
          Resultado resultado = new Resultado( pesos_bias, pesos_xi, OUT, yj,target, NET,  xi,cambio_pesos_bias, cambio_pesos_xi, filas);
        
        resultado.resultado();
        
  
    }
}
