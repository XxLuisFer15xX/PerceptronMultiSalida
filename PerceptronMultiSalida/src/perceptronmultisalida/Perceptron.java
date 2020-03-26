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
    private int nX; // Numero de Entradas xi
    private int nY; // Nmero de Neuronas yj
    private int nFilas; // Lineas de Datos
    
    // <==={Atributos Pesos}===>
    private int w[][][] = new int[nFilas][nX][nY]; // Pesos xi
    private int b[][] = new int[nFilas][nY]; // Pesos bj
    
    // <==={Atributos Cambio Pesos}===>
    private int wChange[][][] = new int[nFilas][nX][nY]; // Cambio Pesos xi
    private int bChange[][] = new int[nFilas][nY]; // Cambio Pesos bj
    
    // <==={Atributos Funcion de Activacion}===>
    private int y_inj[][] = new int[nFilas][nY]; // NET
    private int yj[][] = new int[nFilas][nY]; // OUT
    
    
    public Perceptron(int alfa, int teta, int nEntradas, int nSalidas, int nFilas){
        this.alfa = alfa;
        this.teta = teta;
        this.nX = nEntradas;
        this.nY = nSalidas;
        this.nFilas = nFilas;
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
     * @return the nX
     */
    public int getnX() {
        return nX;
    }

    /**
     * @param nX the nX to set
     */
    public void setnX(int nX) {
        this.nX = nX;
    }

    /**
     * @return the nY
     */
    public int getnY() {
        return nY;
    }

    /**
     * @param nY the nY to set
     */
    public void setnY(int nY) {
        this.nY = nY;
    }

    /**
     * @return the nFilas
     */
    public int getnFilas() {
        return nFilas;
    }

    /**
     * @param nFilas the nFilas to set
     */
    public void setnFilas(int nFilas) {
        this.nFilas = nFilas;
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
     * @return the b
     */
    public int[][] getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(int[][] b) {
        this.b = b;
    }

    /**
     * @return the wChange
     */
    public int[][][] getwChange() {
        return wChange;
    }

    /**
     * @param wChange the wChange to set
     */
    public void setwChange(int[][][] wChange) {
        this.wChange = wChange;
    }

    /**
     * @return the bChange
     */
    public int[][] getbChange() {
        return bChange;
    }

    /**
     * @param bChange the bChange to set
     */
    public void setbChange(int[][] bChange) {
        this.bChange = bChange;
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
}
