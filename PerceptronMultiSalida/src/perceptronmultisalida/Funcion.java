/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmultisalida;

/**
 *
 * @author Luis Fernando
 */
public class Funcion {
    // Funcion Activacion
    // <====={Funcion para y_inj}=====>
    public static void y_inj(
            Perceptron p,
            TablaEntrenamiento t,
            int nFilas,
            int nEntradas,
            int nSalidas,
            int fila,
            int salida
    ){
        int net = 0;
        if (fila == 0){
            net = p.getWb()[nFilas-1][salida] * t.getTablaBias()[fila][salida];
        }else{
            net = p.getWb()[fila-1][salida] * t.getTablaBias()[fila][salida];
        }
        for ( int k = 0 ; k < nEntradas ; k++ ){
            if (fila == 0){
                net += ( p.getW()[nFilas-1][k][salida] * t.getTablaEntradas()[fila][k] );
            }else{
                net += ( p.getW()[fila-1][k][salida] * t.getTablaEntradas()[fila][k] );
            }
        }
        p.setY_inj(net, fila, salida);
    }
    
    // <====={Funcion para yj}=====>
    public static void yj(
            Perceptron p,
            int nFilas,
            int nSalidas,
            int fila,
            int salida,
            int teta
    ){
        
        int net = p.getY_inj()[fila][salida];
        int out = 0;
        if (net > teta){
            out = 1;
        } else if (   (-1)*teta <= net   &&   net <= teta   ){
            out = 0;
        }else if ( net < (-1)*teta ){
            out = -1;
        }
        p.setYj(out, fila, salida);
    }
}
