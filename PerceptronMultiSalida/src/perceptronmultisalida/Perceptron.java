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
public class Perceptron {
    // <==={Atributos Basicos}===>
    private int alfa; // Taza de Aprendisaje
    private int teta;  // Umbral
    
    // <==={Atributos Pesos}===>
    private int w[][][]; // [nFilas][nX][nY] - Pesos xi 
    private int wb[][]; // [nFilas][nY] - Pesos bj
    
    // <==={Atributos Cambio Pesos}===>
    private int wChange[][][]; // [nFilas][nX][nY] - Cambio Pesos xi
    private int wbChange[][]; // [nFilas][nY] - Cambio Pesos bj
    
    // <==={Atributos Funcion de Activacion}===>
    private int y_inj[][]; // [nFilas][nY] - NET 
    private int yj[][]; // [nFilas][nY] - OUT 
    
    
    public Perceptron(
            int alfa,
            int teta,
            
            int w[][][],
            int wb[][],
            int wChange[][][],
            int wbChange[][],
            int y_inj[][],
            int yj[][]
    ){
        this.alfa = alfa;
        this.teta = teta;
        
        this.w = w;
        this.wb = wb;
        this.wChange = wChange;
        this.wbChange = wbChange;
        this.y_inj = y_inj;
        this.yj = yj;
    }

    /**
     * @return the alfa
     */
    public int getAlfa() {
        return alfa;
    }

    /**
     * @param alfa the alfa to set
     */
    public void setAlfa(int alfa) {
        this.alfa = alfa;
    }

    /**
     * @return the teta
     */
    public int getTeta() {
        return teta;
    }

    /**
     * @param teta the teta to set
     */
    public void setTeta(int teta) {
        this.teta = teta;
    }

    /**
     * @return the w
     */
    public int[][][] getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(int[][][] w) {
        this.w = w;
    }

    /**
     * @return the wb
     */
    public int[][] getWb() {
        return wb;
    }

    /**
     * @param wb the b to set
     */
    public void setWb(int[][] wb) {
        this.wb = wb;
    }

    /**
     * @return the wChange
     */
    public int[][][] getWChange() {
        return wChange;
    }

    /**
     * @param wChange the wChange to set
     */
    public void setWChange(int[][][] wChange) {
        this.wChange = wChange;
    }

    /**
     * @return the wbChange
     */
    public int[][] getWbChange() {
        return wbChange;
    }

    /**
     * @param wbChange the bChange to set
     */
    public void setWbChange(int[][] wbChange) {
        this.wbChange = wbChange;
    }

    /**
     * @return the y_inj
     */
    public int[][] getY_inj() {
        return y_inj;
    }

    /**
     * @param y_inj the y_inj to set
     */
    public void setY_inj(int[][] y_inj) {
        this.y_inj = y_inj;
    }

    /**
     * @return the yj
     */
    public int[][] getYj() {
        return yj;
    }

    /**
     * @param yj the yj to set
     */
    public void setYj(int[][] yj) {
        this.yj = yj;
    }

    
    
    
    // <====={Sobrecarga de Funciones}=====>
    // Sobrecarga de la funcion setY_inj
    public void setY_inj(int y_inj, int fila, int salida) {
        this.y_inj[fila][salida] = y_inj;
    }

    // Sobrecarga de la funcion setYj
    public void setYj(int yj, int fila, int salida) {
        this.yj[fila][salida] = yj;
    }
    
    // Sobrecarga de la funcion setW
    public void setW(int w, int fila, int entrada, int salida) {
        this.w[fila][entrada][salida] = w;
    }
    
    // Sobrecarga de la funcion setWChange
    public void setWChange(int wChange, int fila, int entrada, int salida) {
        this.wChange[fila][entrada][salida] = wChange;
    }
    
    // Sobrecarga de la funcion setWb
    public void setWb(int wb, int fila, int salida) {
        this.wb[fila][salida] = wb;
    }
    
    // Sobrecarga de la funcion setWbChange
    public void setWbChange(int wbChange, int fila, int salida) {
        this.wbChange[fila][salida] = wbChange;
    }
}
