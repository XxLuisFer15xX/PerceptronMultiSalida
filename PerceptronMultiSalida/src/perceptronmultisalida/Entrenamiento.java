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
    private int epocas;
    private int tasaAcriertos;
    private int tasaFallos;
    
    public static void Entrenar(
            Perceptron p,
            TablaEntrenamiento t
    ){
        int alfa = p.getAlfa();
        int nFilas = t.getnFilas();
        int nEntradas = t.getnX();
        int nSalidas = t.getnY();
        boolean condicionParada = true;
        int respuesta = 2;
        Scanner teclado = new Scanner(System.in);
        // Paso 1
        // Perceptron Simple
        
        int aciertos = 0;
        int epocas = 0;
        double tazaAciertos = 0;
        double tazaFallos = 0;
        boolean cambios = false;
        while (condicionParada){
            int contador = 0;
            epocas++;
            // Paso 2
            // Asignar Pesos
            for ( int i = 0 ; i < nFilas ; i++ ){
                cambios = false;
                for ( int j = 0 ; j < nSalidas ; j++ ){
                    // Paso 4
                    Funcion.y_inj(p, t, i, j);
                    Funcion.yj(p, t, i, j);
                    
                    // Paso 5
                    if( t.getTablaTarget()[i][j] != p.getYj()[i][j] ){
                        cambios = true;
                        if (i == 0 ){
                            for ( int k = 0 ; k < nEntradas ; k++ ){
                                p.setW(  p.getW()[nFilas-1][k][j] + (alfa * t.getTablaTarget()[i][j] * t.getTablaEntradas()[i][k])  ,i,k,j);
                                p.setWChange(  (alfa * t.getTablaTarget()[i][j] * t.getTablaEntradas()[i][k])  ,i,k,j);
                            }                            
                            p.setWb(  p.getWb()[nFilas-1][j] + (alfa * t.getTablaTarget()[i][j])  ,i,j);
                        }else{
                            for ( int k = 0 ; k < nEntradas ; k++ ){
                                p.setW(  p.getW()[i-1][k][j] + (alfa * t.getTablaTarget()[i][j] * t.getTablaEntradas()[i][k])  ,i,k,j);
                                p.setWChange(  (alfa * t.getTablaTarget()[i][j] * t.getTablaEntradas()[i][k])  ,i,k,j);
                            }
                            p.setWb(  p.getWb()[i-1][j] + (alfa * t.getTablaTarget()[i][j])  ,i,j);
                        }
                        p.setWbChange(  (alfa * t.getTablaTarget()[i][j])  ,i,j);
                    }else{
                        if (i == 0 ){
                            for ( int k = 0 ; k < nEntradas ; k++ ){
                                p.setW(  p.getW()[nFilas-1][k][j]  ,i,k,j);
                                p.setWChange(  0  ,i,k,j);
                                contador++;
                            }
                            p.setWb(  p.getWb()[nFilas-1][j]  ,i,j);
                            contador++;
                        }else{
                            for ( int k = 0 ; k < nEntradas ; k++ ){
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
                if (!cambios){
                    aciertos++;
                }
            }
            
            if ( (  nFilas * ((nEntradas*nSalidas) + nSalidas)  ) == contador ){
                condicionParada = false;
            }
            System.out.println("");
        }
        tazaAciertos = ( (double) aciertos / (epocas * nFilas) )*100;
        tazaFallos = ( (double)((epocas * nFilas) - aciertos) / (epocas * nFilas) )*100;
        System.out.println("<===== {Informacion del Entrenamiento} =====>");
        System.out.println("Epocas:" + epocas);
        System.out.println("Total de Pruebas:" + (epocas * nFilas) );
        System.out.println("Taza de Aciertos:" + tazaAciertos + "");
        System.out.println("Taza de Fallos:" + tazaFallos );
        System.out.println("");
    }
}