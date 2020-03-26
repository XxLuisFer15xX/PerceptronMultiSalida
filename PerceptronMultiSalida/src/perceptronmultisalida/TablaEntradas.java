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
public class TablaEntradas {
    // <==={Atributos Basicos}===>
    private int nFilas; // Numero de Filas
    private int nX; // Numero de entradas xi
    private int nY; // Numero de neuronas yj
    
    // <==={Atributos Entrada}===>
    private int tablaEntradas[][] = new int[nFilas][nX]; // Tabla de entradas xi
    
    // <==={Atributos Target}===>
    private int tablaTarget[][] = new int[nFilas][nY]; // Tabla de entradas xi
    
    public TablaEntradas(int nEntradas, int nSalidas, int nFilas){
        this.nX = nEntradas;
        this.nY = nSalidas;
        this.nFilas = nFilas;
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
     * @return the tablaEntradas
     */
    public int[][] getTablaEntradas() {
        return tablaEntradas;
    }

    /**
     * @param tablaEntradas the tablaEntradas to set
     */
    public void setTablaEntradas(int[][] tablaEntradas) {
        this.tablaEntradas = tablaEntradas;
    }

    /**
     * @return the tablaTarget
     */
    public int[][] getTablaTarget() {
        return tablaTarget;
    }

    /**
     * @param tablaTarget the tablaTarget to set
     */
    public void setTablaTarget(int[][] tablaTarget) {
        this.tablaTarget = tablaTarget;
    }
}
