/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmultisalida;

/**
 *
 * @author Mariela Martinez
 */
public class Resultado {
    // Mostrar TablaEntrenamiento
    // <==={Atributos Entradas}===>
    public static boolean MostrarTablaEntradas(TablaEntrenamiento t){
        System.out.print("xi");
        for ( int k = 0 ; k < t.getnX() ; k++ ){
            System.out.print("\tx" + (k+1) );
        }
        System.out.println("");
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            System.out.print("f"+ (i+1) +":\t");
	    for ( int k = 0 ; k < t.getnX() ; k++ ){
                System.out.print(t.getTablaEntradas()[i][k] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        return false;
    }
    // <==={Atributos Entradas}===>
    public static boolean MostrarTablaTarget(TablaEntrenamiento t){
        System.out.print("tj");
        for ( int j = 0 ; j < t.getnY() ; j++ ){
            System.out.print("\tt" + (j+1) );
        }
        System.out.println("");
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            System.out.print("f"+ (i+1) +":\t");
	    for ( int j = 0 ; j < t.getnY() ; j++ ){
                System.out.print(t.getTablaTarget()[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        return false;
    }
    
    public static boolean MostrarTablaBias(TablaEntrenamiento t){
        System.out.print("bj");
        for ( int j = 0 ; j < t.getnY() ; j++ ){
            System.out.print("\tb" + (j+1) );
        }
        System.out.println("");
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            System.out.print("f"+ (i+1) +":\t");
	    for ( int j = 0 ; j < t.getnY() ; j++ ){
                System.out.print(t.getTablaBias()[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        return false;
    }
    
    
    
    
    
    // Mostrar Perceptron
    // <==={Atributos Basicos}===>
    public static boolean MostrarPerceptronAtributos(Perceptron p, TablaEntrenamiento t){
        System.out.println("Taza de aprendisaje alfa: " + p.getAlfa());
        System.out.println("Umbral teta: " + p.getTeta());
        System.out.println("Numero de Entradas xi: " + t.getnX());
        System.out.println("Numero de Neuronas: " + t.getnY());
        System.out.println("Lineas de datos: " + t.getnFilas());
        System.out.println("");
        return false;
    }
    
    
    
    // <==={Atributos Pesos}===>
    public static boolean MostrarPerceptronWeight(Perceptron p, TablaEntrenamiento t){
        // Pesos xi
        System.out.print("wij");
        for ( int k = 0 ; k < t.getnX() ; k++ ){
            for ( int j = 0 ; j < t.getnY() ; j++ ){
                System.out.print("\tw" + (k+1) + "" + (j+1) );
            }
        }
        System.out.println("");
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            System.out.print("f"+ (i+1) +":\t");
	    for ( int k = 0 ; k < t.getnX() ; k++ ){
                for ( int j = 0 ; j < t.getnY() ; j++ ){
                    System.out.print(p.getW()[i][k][j] + "\t");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        
        
        
        // Pesos bj
        System.out.print("wbj");
        for ( int j = 0 ; j < t.getnY() ; j++ ){
            System.out.print("\twb" + (j+1) );
        }
        System.out.println("");
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            System.out.print("f"+ (i+1) +":\t");
	    for ( int j = 0 ; j < t.getnY() ; j++ ){
                System.out.print(p.getWb()[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        return false;
    }
    
    
    
    // <==={Atributos Cambio Pesos}===>
    public static boolean MostrarPerceptronWeightChange(Perceptron p, TablaEntrenamiento t){
        // Cambio Pesos xi
        System.out.print("wijChange");
        for ( int k = 0 ; k < t.getnX() ; k++ ){
            for ( int j = 0 ; j < t.getnY() ; j++ ){
                System.out.print("\tw" + (k+1) + "" + (j+1) );
            }
        }
        System.out.println("");
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            System.out.print("f"+ (i+1) +":\t\t");
	    for ( int k = 0 ; k < t.getnX() ; k++ ){
                for ( int j = 0 ; j < t.getnY() ; j++ ){
                    System.out.print(p.getWChange()[i][k][j] + "\t");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        
        
        
        // Cambio Pesos bj
        System.out.print("wbjChange");
        for ( int j = 0 ; j < t.getnY() ; j++ ){
            System.out.print("\twb" + (j+1) );
        }
        System.out.println("");
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            System.out.print("f"+ (i+1) +":\t\t");
	    for ( int j = 0 ; j < t.getnY() ; j++ ){
                System.out.print(p.getWbChange()[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        return false;
    }
    
    
    
    // <==={Atributos Funcion de Activacion}===>
    public static boolean MostrarPerceptronFuncion(Perceptron p, TablaEntrenamiento t){
        // NET
        System.out.print("Y_inj");
        for ( int j = 0 ; j < t.getnY() ; j++ ){
            System.out.print("\tY_in" + (j+1) );
        }
        System.out.println("");
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            System.out.print("f"+ (i+1) +":\t");
	    for ( int j = 0 ; j < t.getnY() ; j++ ){
                System.out.print(p.getY_inj()[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        
        // OUT
        System.out.print("Yj");
        for ( int j = 0 ; j < t.getnY() ; j++ ){
            System.out.print("\tY" + (j+1) );
        }
        System.out.println("");
        
        for ( int i = 0 ; i < t.getnFilas() ; i++ ){
            System.out.print("f"+ (i+1) +":\t");
	    for ( int j = 0 ; j < t.getnY() ; j++ ){
                System.out.print(p.getYj()[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        return false;
    }
}

