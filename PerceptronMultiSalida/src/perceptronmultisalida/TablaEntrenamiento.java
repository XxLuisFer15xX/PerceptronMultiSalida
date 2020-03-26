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
public class TablaEntrenamiento {
    // <==={Atributos Basicos}===>
    private int nFilas; // Numero de Filas
    private int nX; // Numero de entradas xi
    private int nY; // Numero de neuronas yj
    
    // <==={Atributos Entrada}===>
    private int[][] tablaEntradas; // [nFilas][nX] - Tabla de entradas xi 
    private int[][] tablaBias; // [nFilas][nY] - Tabla de entradas bias 
    
    // <==={Atributos Target}===>
    private int[][] tablaTarget; // [nFilas][nY] - Tabla de entradas xi 
    
    public TablaEntrenamiento(
            int nEntradas,
            int nSalidas,
            int nFilas,
            int[][] tablaEntradas,
            int[][] tablaBias,
            int[][] tablaTarget
    ){
        this.nX = nEntradas;
        this.nY = nSalidas;
        this.nFilas = nFilas;
        this.tablaEntradas = tablaEntradas;
        this.tablaBias = tablaBias;
        this.tablaTarget = tablaTarget;
        
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
     * @return the tablaBias
     */
    public int[][] getTablaBias() {
        return tablaBias;
    }

    /**
     * @param tablaBias the tablaBias to set
     */
    public void setTablaBias(int[][] tablaBias) {
        this.tablaBias = tablaBias;
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
