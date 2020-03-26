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
public class Resultado {
  private int[][] pesos_bias;
  private int[][][] pesos_xi;
  private int[][] OUT;
  private int yj;
  private int[][] target;
  private int[][] NET;
  private int xi;
  private int[][] cambio_pesos_bias;
  private int[][][] cambio_pesos_xi;
  private int filas;

  public Resultado( int[][] pesos_bias, int[][][] pesos_xi, int[][] OUT, int yj, int[][] target, int[][] NET, int xi,int[][] cambio_pesos_bias,int[][][] cambio_pesos_xi,int filas) {
       
        this.pesos_bias = pesos_bias;
        this.pesos_xi = pesos_xi;
        this.OUT = OUT;
        this.yj = yj;
        this.target = target;
        this.NET = NET;
        this.xi = xi;
        this.cambio_pesos_bias = cambio_pesos_bias;
        this.cambio_pesos_xi = cambio_pesos_xi;
        this.filas = filas;
        
        
       
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
     * @return the target
     */
    public int[][] getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(int[][] target) {
        this.target = target;
    }

    /**
     * @return the NET
     */
    public int[][] getNET() {
        return NET;
    }

    /**
     * @param NET the NET to set
     */
    public void setNET(int[][] NET) {
        this.NET = NET;
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
     * @return the cambio_pesos_bias
     */
    public int[][] getCambio_pesos_bias() {
        return cambio_pesos_bias;
    }

    /**
     * @param cambio_pesos_bias the cambio_pesos_bias to set
     */
    public void setCambio_pesos_bias(int[][] cambio_pesos_bias) {
        this.cambio_pesos_bias = cambio_pesos_bias;
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
    
    
    public void resultado(){   
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
    
   
 }

}
