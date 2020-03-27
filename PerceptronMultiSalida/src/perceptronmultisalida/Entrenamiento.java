/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmultisalida;

import java.util.Scanner;

/**
 *
 * @author Luis Fernando
 */
public class Entrenamiento {
    
    public static void Entrenar(
            Perceptron p,
            TablaEntrenamiento t,
            int nFilas,
            int nEntradas,
            int nSalidas,
            int alfa,
            int teta
    ){
        boolean condicionParada = true;
        int respuesta = 2;
        Scanner teclado = new Scanner(System.in);
        // Paso 1
        // Perceptron Simple
        while (condicionParada){
            int contador = 0;	    
            // Paso 2
            // Asignar Pesos
            for ( int i = 0 ; i < nFilas ; i++ ){
                for ( int j = 0 ; j < nSalidas ; j++ ){
                    // Paso 4
                    Funcion.y_inj(p, t, nFilas, nEntradas, nSalidas, i, j);
                    Funcion.yj(p, nFilas, nSalidas, i, j, teta);
                    
                    // Paso 5
                    if( t.getTablaTarget()[i][j] != p.getYj()[i][j] ){
                        if (i == 0 ){
                            for ( int k = 0 ; k < nSalidas ; k++ ){
                                p.setW(  p.getW()[nFilas-1][k][j] + (alfa * t.getTablaTarget()[i][j] * t.getTablaEntradas()[i][k])  ,i,k,j);
                                p.setWChange(  (alfa * t.getTablaTarget()[i][j] * t.getTablaEntradas()[i][k])  ,i,k,j);
                            }                            
                            p.setWb(  p.getWb()[nFilas-1][j] + (alfa * t.getTablaTarget()[i][j])  ,i,j);
                        }else{
                            for ( int k = 0 ; k < nSalidas ; k++ ){
                                p.setW(  p.getW()[i-1][k][j] + (alfa * t.getTablaTarget()[i][j] * t.getTablaEntradas()[i][k])  ,i,k,j);
                                p.setWChange(  (alfa * t.getTablaTarget()[i][j] * t.getTablaEntradas()[i][k])  ,i,k,j);
                            }
                            p.setWb(  p.getWb()[i-1][j] + (alfa * t.getTablaTarget()[i][j])  ,i,j);
                        }
                        p.setWbChange(  (alfa * t.getTablaTarget()[i][j])  ,i,j);
                    }else{
                        if (i == 0 ){
                            for ( int k = 0 ; k < nSalidas ; k++ ){
                                p.setW(  p.getW()[nFilas-1][k][j]  ,i,k,j);
                                p.setWChange(  0  ,i,k,j);
                                contador++;
                            }
                            p.setWb(  p.getWb()[nFilas-1][j]  ,i,j);
                            contador++;
                        }else{
                            for ( int k = 0 ; k < nSalidas ; k++ ){
                                p.setW(  p.getW()[i-1][k][j]  ,i,k,j);
                                p.setWChange(  0  ,i,k,j);
                                contador++;
                            }
                            p.setWb(  p.getWb()[i-1][j]  ,i,j);
                            contador++;
                        }
                        p.setWbChange(  0  ,i,j);
                    }
                }
            }
            System.out.println("Desea salir 1.Si 2.No");
            respuesta = teclado.nextInt();
            System.out.println("");
            if (respuesta == 1){
                condicionParada = false;
            }
            System.out.println("");
            System.out.println(contador+" "+"/");
            System.out.println(nFilas * ((nEntradas*nSalidas) + nSalidas));
            if ( (  nFilas * ((nEntradas*nSalidas) + nSalidas)  ) == contador ){
                System.out.println("No hay cambios");
                condicionParada = false;
            }else{
                System.out.println("Si hay cambios");
            }
            System.out.println(""); 
        }        
    }
}
