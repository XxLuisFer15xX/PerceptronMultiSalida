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

  private int[][] bias;
  private int[][] pesos_bias;
  private int[][][] pesos_xi;
  private int[][] tabla_verdad;
  private int[][] OUT;
  private int teta;
  private int filas;
  private int yj;
  private int xi;
  private int[][][] cambio_pesos_xi;
  private  int columnas;
  
   public Funcion(int[][] bias, int[][] pesos_bias, int[][][] pesos_xi, int[][] tabla_verdad, int[][] OUT, int teta, int[][][] cambio_pesos_xi, int filas, int yj, int xi,int columnas) {
        this.bias = bias;
        this.pesos_bias = pesos_bias;
        this.pesos_xi = pesos_xi;
        this.tabla_verdad = tabla_verdad;
        this.OUT = OUT;
        this.teta = teta;
        this.cambio_pesos_xi = cambio_pesos_xi;
        this.filas = filas;
        this.yj = yj;
        this.xi = xi;
        this.columnas = columnas;
    }

    /**
     * @return the bias
     */
    public int[][] getBias() {
        return bias;
    }

    /**
     * @param bias the bias to set
     */
    public void setBias(int[][] bias) {
        this.bias = bias;
    }

    /**
     * @return the pesos_bias
     */
    public int[][] getPesos_bias() {
        return pesos_bias;
    }

    /**
     * @param pesos_bias the pesos_bias to set
     */
    public void setPesos_bias(int[][] pesos_bias) {
        this.pesos_bias = pesos_bias;
    }

    /**
     * @return the pesos_xi
     */
    public int[][][] getPesos_xi() {
        return pesos_xi;
    }

    /**
     * @param pesos_xi the pesos_xi to set
     */
    public void setPesos_xi(int[][][] pesos_xi) {
        this.pesos_xi = pesos_xi;
    }

    /**
     * @return the tabla_verdad
     */
    public int[][] getTabla_verdad() {
        return tabla_verdad;
    }

    /**
     * @param tabla_verdad the tabla_verdad to set
     */
    public void setTabla_verdad(int[][] tabla_verdad) {
        this.tabla_verdad = tabla_verdad;
    }

    /**
     * @return the OUT
     */
    public int[][] getOUT() {
        return OUT;
    }

    /**
     * @param OUT the OUT to set
     */
    public void setOUT(int[][] OUT) {
        this.OUT = OUT;
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
     * @return the filas
     */
    public int getFilas() {
        return filas;
    }

    /**
     * @param filas the filas to set
     */
    public void setFilas(int filas) {
        this.filas = filas;
    }

    /**
     * @return the yj
     */
    public int getYj() {
        return yj;
    }

    /**
     * @param yj the yj to set
     */
    public void setYj(int yj) {
        this.yj = yj;
    }

    /**
     * @return the xi
     */
    public int getXi() {
        return xi;
    }

    /**
     * @param xi the xi to set
     */
    public void setXi(int xi) {
        this.xi = xi;
    }


    /**
     * @return the cambio_pesos_xi
     */
    public int[][][] getCambio_pesos_xi() {
        return cambio_pesos_xi;
    }

    /**
     * @param cambio_pesos_xi the cambio_pesos_xi to set
     */
    public void setCambio_pesos_xi(int[][][] cambio_pesos_xi) {
        this.cambio_pesos_xi = cambio_pesos_xi;
    }

    /**
     * @return the columnas
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * @param columnas the columnas to set
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    
            
   public void funcion(){    
       
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
