/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmultisalida;

import static java.lang.Math.pow;

/**
 *
 * @author Luis Fernando
 */
public class PerceptronMultiSalida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean condicionParada = true;
       
        int respuesta = 2;
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
        
        
        
        // Paso 1
	// Perceptron Simple
	while (condicionParada){
	    int contador = 0;
	    
	    // Paso 2
	    // Asignar Pesos
	    for ( int i = 0 ; i < filas ; i++ ){
	        for ( int j = 0 ; j < yj ; j++ ){
	            // Paso 4
	            // NET
	            if (i == 0){
	                NET[i][j] = pesos_bias[filas-1][j] * bias[i][j];
	            }else{
	                NET[i][j] = pesos_bias[i-1][j] * bias[i][j];
	            }
	            for ( int k = 0 ; k < xi ; k++ ){
	                if (i == 0){
	                    NET[i][j] = NET[i][j] + ( pesos_xi[filas-1][k][j] * tabla_verdad[i][k] );
	                }else{
	                    NET[i][j] = NET[i][j] + ( pesos_xi[i-1][k][j] * tabla_verdad[i][k] );
	                }
	            }
	            // OUT
	            if (NET[i][j] > teta){
	                OUT[i][j] = 1;
	            } else if (   (-1)*teta <= NET[i][j]   &&   NET[i][j] <= teta   ){
	                OUT[i][j] = 0;
	            }else if ( NET[i][j] < (-1)*teta ){
	                OUT[i][j] = -1;
	            }
	            //cout << NET[i][j] << " " << OUT[i][j] << endl;
	            
	            
	            
	            
	            
	            // Paso 5
	            if( target[i][j] != OUT[i][j] ){
	                if (i == 0 ){
	                    for ( int k = 0 ; k < xi ; k++ ){
	                        pesos_xi[i][k][j] = pesos_xi[filas-1][k][j] + (alfa * target[i][j] * tabla_verdad[i][k]);
	                        cambio_pesos_xi[i][k][j] = (alfa * target[i][j] * tabla_verdad[i][k]);
	                    }
	                    pesos_bias[i][j] = pesos_bias[filas-1][j] + (alfa * target[i][j]);
	                    cambio_pesos_bias[i][j] = (alfa * target[i][j]);
	                }else{
	                    for ( int k = 0 ; k < xi ; k++ ){
	                        pesos_xi[i][k][j] = pesos_xi[i-1][k][j] + (alfa * target[i][j] * tabla_verdad[i][k]);
	                        cambio_pesos_xi[i][k][j] = (alfa * target[i][j] * tabla_verdad[i][k]);
	                    }
	                    pesos_bias[i][j] = pesos_bias[i-1][j] + (alfa * target[i][j]);
	                    cambio_pesos_bias[i][j] = (alfa * target[i][j]);
	                }
	            }else{
	                if (i == 0 ){
	                    for ( int k = 0 ; k < xi ; k++ ){
	                        pesos_xi[i][k][j] = pesos_xi[filas-1][k][j];
	                        cambio_pesos_xi[i][k][j] = 0;
	                        contador++;
	                    }
	                    pesos_bias[i][j] = pesos_bias[filas-1][j];
	                    cambio_pesos_bias[i][j] = 0;
	                    contador++;
	                }else{
	                    for ( int k = 0 ; k < xi ; k++ ){
	                        pesos_xi[i][k][j] = pesos_xi[i-1][k][j];
	                        cambio_pesos_xi[i][k][j] = 0;
	                        contador++;
	                    }
	                    pesos_bias[i][j] = pesos_bias[i-1][j];
	                    cambio_pesos_bias[i][j] = 0;
	                    contador++;
	                }
	            }
	        }
	    }
		
		System.out.println("Desea salir 1.Si 2.No");
		System.out.println(respuesta);
		System.out.println("");
		if (respuesta == 1){
			condicionParada = false;
		}
                
                System.out.println("");
                System.out.println(contador+" "+"/");
		System.out.println(filas * ((xi*yj) + yj));
		if ( (  filas * ((xi*yj) + yj)  ) == contador ){
		    System.out.println("No hay cambios");
		    condicionParada = false;
		}else{
		    System.out.println("Si hay cambios");
		}
		System.out.println(""); 
	}
        
        // Mostrar Tablas
	for ( int i = 0 ; i < filas ; i++ ){
	    System.out.println("f"+i+"  ");
	    for ( int j = 0 ; j < yj ; j++ ){
	        System.out.println("y"+j+" ");
	    }
	    System.out.println();
	    System.out.println("NET ");
	    for ( int j = 0 ; j < yj ; j++ ){
	        System.out.println(NET[i][j]+"  ");
	    }
            System.out.println();
	    System.out.println("OUT ") ;
	    for ( int j = 0 ; j < yj ; j++ ){
	        System.out.println(OUT[i][j]+"  ");
	    }
            System.out.println();
	    System.out.println("Tj: " );
	    for ( int j = 0 ; j < yj ; j++ ){
	        System.out.println(target[i][j] + "  ");
	    }
	    System.out.println();
	    System.out.println("Pesos:" );
	    for ( int k = 0 ; k < xi ; k++ ){
	        System.out.println("x" + k + ": ");
	        for ( int j = 0 ; j < yj ; j++ ){
	            System.out.println( pesos_xi[i][k][j] + "  ");
	        }
	        System.out.println();
	    }
	    System.out.println("Bj: " );
	    for ( int j = 0 ; j < yj ; j++ ){
	        System.out.println(pesos_bias[i][j] + "  ");
	    }
	    System.out.println();
	    System.out.println("Cambio Pesos:");
	    for ( int k = 0 ; k < xi ; k++ ){
	        System.out.println("x" + k + ": ");
	        for ( int j = 0 ; j < yj ; j++ ){
	            System.out.println(cambio_pesos_xi[i][k][j] + "  ");
	        }
	        System.out.println();
	    }
	    System.out.println("Bj: " );
	    for ( int j = 0 ; j < yj ; j++ ){
	        System.out.println(cambio_pesos_bias[i][j] + "  ");
	    }
	    System.out.println();
            System.out.println();
	}
        
        // Prueba de los pesos
	int Y_inj = 0;
    int Yj = 0;
    
    System.out.println();
    System.out.println("Y_inj = (bj) + Sumatoria(xi*wij)");
	for ( int j = 0 ; j < yj ; j++ ){
	    // Encabezado
            System.out.println();
	    System.out.println("Y_in" + j+1 + " = (b" + j+1 + ") + Sumatoria(xi*wi" + j+1 + ")\t\t\t\tt"+ j+1);
	    
        for ( int i = 0 ; i < filas ; i++ ){
            
            Y_inj = bias[i][j] * pesos_bias[i][j];
            System.out.println("Y_in" + j+1 + " = "
            + "(" + bias[i][j] + ")"
            + "(" + pesos_bias[i][j] + ")"
            + " + [") ;
            
            Y_inj += tabla_verdad[i][0] * pesos_xi[i][0][j];
            System.out.println(" (" + tabla_verdad[i][0] + ")"
            + "(" + pesos_xi[i][0][j] + ")");
            for ( int k = 1 ; k < xi ; k++ ){
                Y_inj += tabla_verdad[i][k] * pesos_xi[i][k][j];
                System.out.println(" + (" + tabla_verdad[i][k] + ")"
                + "(" + pesos_xi[i][k][j] + ")");
            }
            System.out.println(" ] = " + Y_inj);
            
            
            System.out.println( "\t\t " + "t" + j+1 + " = ");
            if (Y_inj > teta){
	            Yj = 1;
            } else if (   (-1)*teta <= Y_inj   &&   Y_inj <= teta   ){
                Yj = 0;
            }else if ( Y_inj < (-1)*teta ){
                Yj = -1;
            }
            System.out.println(Yj);
            System.out.println();
            System.out.println();
        }
        System.out.println();
	}
	
        
    }
    
}
