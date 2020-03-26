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
public class Entrenamiento {
    
   private int[][] NET;
   private int[][] bias;
   private int[][] pesos_bias;
   private int[][][] pesos_xi;
   private int[][] tabla_verdad;
   private int[][] OUT;
   private int teta;
   private int[][] target;
   private int alfa;
   private int[][] cambio_pesos_bias;
   private int[][][] cambio_pesos_xi;
   private int filas;
   private int yj;
   private int xi;

    public Entrenamiento(int[][] NET, int[][] bias, int[][] pesos_bias, int[][][] pesos_xi, int[][] tabla_verdad, int[][] OUT, int teta, int[][] target, int alfa, int[][] cambio_pesos_bias, int[][][] cambio_pesos_xi, int filas, int yj, int xi) {
        this.NET = NET;
        this.bias = bias;
        this.pesos_bias = pesos_bias;
        this.pesos_xi = pesos_xi;
        this.tabla_verdad = tabla_verdad;
        this.OUT = OUT;
        this.teta = teta;
        this.target = target;
        this.alfa = alfa;
        this.cambio_pesos_bias = cambio_pesos_bias;
        this.cambio_pesos_xi = cambio_pesos_xi;
        this.filas = filas;
        this.yj = yj;
        this.xi = xi;
    }

    public int[][] getNET() {
        return NET;
    }

    public void setNET(int[][] NET) {
        this.NET = NET;
    }

    public int[][] getBias() {
        return bias;
    }

    public void setBias(int[][] bias) {
        this.bias = bias;
    }

    public int[][] getPesos_bias() {
        return pesos_bias;
    }

    public void setPesos_bias(int[][] pesos_bias) {
        this.pesos_bias = pesos_bias;
    }

    public int[][][] getPesos_xi() {
        return pesos_xi;
    }

    public void setPesos_xi(int[][][] pesos_xi) {
        this.pesos_xi = pesos_xi;
    }

    public int[][] getTabla_verdad() {
        return tabla_verdad;
    }

    public void setTabla_verdad(int[][] tabla_verdad) {
        this.tabla_verdad = tabla_verdad;
    }

    public int[][] getOUT() {
        return OUT;
    }

    public void setOUT(int[][] OUT) {
        this.OUT = OUT;
    }

    public int getTeta() {
        return teta;
    }

    public void setTeta(int teta) {
        this.teta = teta;
    }

    public int[][] getTarget() {
        return target;
    }

    public void setTarget(int[][] target) {
        this.target = target;
    }

    public int getAlfa() {
        return alfa;
    }

    public void setAlfa(int alfa) {
        this.alfa = alfa;
    }

    public int[][] getCambio_pesos_bias() {
        return cambio_pesos_bias;
    }

    public void setCambio_pesos_bias(int[][] cambio_pesos_bias) {
        this.cambio_pesos_bias = cambio_pesos_bias;
    }

    public int[][][] getCambio_pesos_xi() {
        return cambio_pesos_xi;
    }

    public void setCambio_pesos_xi(int[][][] cambio_pesos_xi) {
        this.cambio_pesos_xi = cambio_pesos_xi;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getYj() {
        return yj;
    }

    public void setYj(int yj) {
        this.yj = yj;
    }

    public int getXi() {
        return xi;
    }

    public void setXi(int xi) {
        this.xi = xi;
    }

    public void entrenamiento(){
        
        boolean condicionParada = true;
        int respuesta = 2;
        
        // Paso 1
	// Perceptron Simple
	while (condicionParada){
	    int contador = 0;
	    
	    // Paso 2
	    // Asignar Pesos
	    for ( int i = 0 ; i < this.filas ; i++ ){
	        for ( int j = 0 ; j < this.yj ; j++ ){
	            // Paso 4
	            // NET
	            if (i == 0){
	                this.NET[i][j] = this.pesos_bias[this.filas-1][j] * this.bias[i][j];
	            }else{
	                this.NET[i][j] = this.pesos_bias[i-1][j] * this.bias[i][j];
	            }
	            for ( int k = 0 ; k < this.xi ; k++ ){
	                if (i == 0){
	                    this.NET[i][j] = this.NET[i][j] + ( this.pesos_xi[this.filas-1][k][j] * this.tabla_verdad[i][k] );
	                }else{
	                    this.NET[i][j] = this.NET[i][j] + ( this.pesos_xi[i-1][k][j] * this.tabla_verdad[i][k] );
	                }
	            }
	            // OUT
	            if (this.NET[i][j] > this.teta){
	                this.OUT[i][j] = 1;
	            } else if (   (-1)*this.teta <= this.NET[i][j]   &&   this.NET[i][j] <= this.teta   ){
	                this.OUT[i][j] = 0;
	            }else if ( this.NET[i][j] < (-1)*this.teta ){
	                this.OUT[i][j] = -1;
	            }
	            //cout << NET[i][j] << " " << OUT[i][j] << endl;
	            
	            
	            
	            
	            
	            // Paso 5
	            if( this.target[i][j] != this.OUT[i][j] ){
	                if (i == 0 ){
	                    for ( int k = 0 ; k < this.xi ; k++ ){
	                        this.pesos_xi[i][k][j] = this.pesos_xi[this.filas-1][k][j] + (this.alfa * this.target[i][j] * this.tabla_verdad[i][k]);
	                        this.cambio_pesos_xi[i][k][j] = (this.alfa * this.target[i][j] * this.tabla_verdad[i][k]);
	                    }
	                    this.pesos_bias[i][j] = this.pesos_bias[this.filas-1][j] + (this.alfa * this.target[i][j]);
	                    this.cambio_pesos_bias[i][j] = (this.alfa * this.target[i][j]);
	                }else{
	                    for ( int k = 0 ; k < xi ; k++ ){
	                        this.pesos_xi[i][k][j] = this.pesos_xi[i-1][k][j] + (this.alfa * this.target[i][j] * this.tabla_verdad[i][k]);
	                        this.cambio_pesos_xi[i][k][j] = (this.alfa * this.target[i][j] * this.tabla_verdad[i][k]);
	                    }
	                    this.pesos_bias[i][j] = this.pesos_bias[i-1][j] + (this.alfa * this.target[i][j]);
	                    this.cambio_pesos_bias[i][j] = (this.alfa * this.target[i][j]);
	                }
	            }else{
	                if (i == 0 ){
	                    for ( int k = 0 ; k < this.xi ; k++ ){
	                        this.pesos_xi[i][k][j] = this.pesos_xi[this.filas-1][k][j];
	                        this.cambio_pesos_xi[i][k][j] = 0;
	                        contador++;
	                    }
	                    this.pesos_bias[i][j] = this.pesos_bias[this.filas-1][j];
	                    this.cambio_pesos_bias[i][j] = 0;
	                    contador++;
	                }else{
	                    for ( int k = 0 ; k < this.xi ; k++ ){
	                        this.pesos_xi[i][k][j] = this.pesos_xi[i-1][k][j];
	                        this.cambio_pesos_xi[i][k][j] = 0;
	                        contador++;
	                    }
	                    this.pesos_bias[i][j] = this.pesos_bias[i-1][j];
	                    this.cambio_pesos_bias[i][j] = 0;
	                    contador++;
	                }
	            }
	        }
	    }
		
		System.out.println("Desea salir 1.Si 2.No");
		System.out.println(respuesta);
		System.out.println("");
		if (respuesta == 1){
			condicionParada = false;
		}
                
                System.out.println("");
                System.out.println(contador+" "+"/");
		System.out.println(this.filas * ((this.xi*this.yj) + this.yj));
		if ( (  this.filas * ((this.xi*this.yj) + this.yj)  ) == contador ){
		    System.out.println("No hay cambios");
		    condicionParada = false;
		}else{
		    System.out.println("Si hay cambios");
		}
		System.out.println(""); 
	}
        
    }
    
}
