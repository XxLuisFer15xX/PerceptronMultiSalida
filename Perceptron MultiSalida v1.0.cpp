//Perceptron Simple
#include<iostream>
#include<cmath>
using namespace std;

int main() {
    // <=====[Definir la estructura del perceptron]=====>
	bool condicionParada = true;
	int respuesta = 2;
	int teta = 0;
	int alfa = 1;
	
	// Definir entradas
	int numeroEntradas = 3;
	
	// Definir salidas
	int numeroSalidas = 2;
	
	
	
	
	
	// <=====[Inicializar tabla de la verdad]=====>
	// Arreglo tabla de la verdad
	int filas = pow(2, numeroEntradas);
	int columnas = numeroEntradas;
	int tabla_verdad [filas][columnas];
	
	// Paso 3
	// LLenar Tabla de la Verdad
	for ( int j = 0 ; j < columnas ; j++ ){
	    
	    int veces = pow( 2, ((columnas-j) -1) );
	    int exponente = 0;
	    
	    for ( int i = 0 ; i < filas ; i++ ){
	        
	        for ( int x = 1 ; x <= veces ; x++){
	            tabla_verdad[i][j] = pow(-1, exponente);
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
	int target [filas][numeroSalidas];
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
	int NET [filas][numeroSalidas];
	int OUT [filas][numeroSalidas];
	int bias [filas][numeroSalidas];
	int pesos_bias [filas][numeroSalidas];
	int cambio_pesos_bias [filas][numeroSalidas];
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
	
	int pesos_xi [filas][xi][yj];
	int cambio_pesos_xi [filas][xi][yj];
	
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
		
		cout << "Desea salir 1.Si 2.No";
		cin >> respuesta;
		cout << endl;
		if (respuesta == 1){
			condicionParada = false;
		}
		cout << endl << contador << "/";
		cout << filas * ((xi*yj) + yj) << endl;
		if ( (  filas * ((xi*yj) + yj)  ) == contador ){
		    cout << "No hay cambios" << endl;
		    condicionParada = false;
		}else{
		    cout << "Si hay cambios" << endl;
		}
		cout << endl;
	}
	
	
	
	
	
	// Mostrar Tablas
	for ( int i = 0 ; i < filas ; i++ ){
	    cout << "f" << i << "  ";
	    for ( int j = 0 ; j < yj ; j++ ){
	        cout << "y" << j << " ";
	    }
	    cout << endl;
	    cout << "NET " ;
	    for ( int j = 0 ; j < yj ; j++ ){
	        cout << NET[i][j] << "  ";
	    }
	    cout << endl << "OUT " ;
	    for ( int j = 0 ; j < yj ; j++ ){
	        cout << OUT[i][j] << "  ";
	    }
	    cout << endl << "Tj: " ;
	    for ( int j = 0 ; j < yj ; j++ ){
	        cout << target[i][j] << "  ";
	    }
	    
	    cout << endl << "Pesos:" << endl;
	    for ( int k = 0 ; k < xi ; k++ ){
	        cout << "x" << k << ": ";
	        for ( int j = 0 ; j < yj ; j++ ){
	            cout << pesos_xi[i][k][j] << "  ";
	        }
	        cout << endl;
	    }
	    cout << "Bj: " ;
	    for ( int j = 0 ; j < yj ; j++ ){
	        cout << pesos_bias[i][j] << "  ";
	    }
	    
	    cout << endl << "Cambio Pesos:" << endl;
	    for ( int k = 0 ; k < xi ; k++ ){
	        cout << "x" << k << ": ";
	        for ( int j = 0 ; j < yj ; j++ ){
	            cout << cambio_pesos_xi[i][k][j] << "  ";
	        }
	        cout << endl;
	    }
	    cout << "Bj: " ;
	    for ( int j = 0 ; j < yj ; j++ ){
	        cout << cambio_pesos_bias[i][j] << "  ";
	    }
	    cout << endl << endl;
	}
	
	
	
	
	
	
	// Prueba de los pesos
	int Y_inj = 0;
    int Yj = 0;
    
    cout << endl << "Y_inj = (bj) + Sumatoria(xi*wij)" << endl;
	for ( int j = 0 ; j < yj ; j++ ){
	    // Encabezado
	    cout << endl << "Y_in" << j+1 << " = (b" << j+1 << ") + Sumatoria(xi*wi" << j+1 << ")\t\t\t\tt"<< j+1 << endl;
	    
        for ( int i = 0 ; i < filas ; i++ ){
            
            Y_inj = bias[i][j] * pesos_bias[i][j];
            cout << "Y_in" << j+1 << " = "
            << "(" << bias[i][j] << ")"
            << "(" << pesos_bias[i][j] << ")"
            << " + [" ;
            
            Y_inj += tabla_verdad[i][0] * pesos_xi[i][0][j];
            cout << " (" << tabla_verdad[i][0] << ")"
            << "(" << pesos_xi[i][0][j] << ")";
            for ( int k = 1 ; k < xi ; k++ ){
                Y_inj += tabla_verdad[i][k] * pesos_xi[i][k][j];
                cout << " + (" << tabla_verdad[i][k] << ")"
                << "(" << pesos_xi[i][k][j] << ")";
            }
            cout << " ] = " << Y_inj;
            
            
            cout << "\t\t " << "t" << j+1 << " = ";
            if (Y_inj > teta){
	            Yj = 1;
            } else if (   (-1)*teta <= Y_inj   &&   Y_inj <= teta   ){
                Yj = 0;
            }else if ( Y_inj < (-1)*teta ){
                Yj = -1;
            }
            cout << Yj;
            cout << endl << endl;
        }
        cout << endl;
	}
	return 0;
}
