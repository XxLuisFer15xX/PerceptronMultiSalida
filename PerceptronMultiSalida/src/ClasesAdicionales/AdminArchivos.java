/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesAdicionales;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Arkoses_as
 */
public class AdminArchivos {
    public static void escribir(
            String nombreArchivo,
            String contenido
    ) {
        File f;
        f = new File(nombreArchivo);
        //Escritura
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
             //Escribimos en el fichero
            bw.write(contenido);
            //Guardamos los cambios del fichero
            bw.flush();
           
            //PrintWriter wr = new PrintWriter(w);
            //wr.write("Primera línea");//escribimos en el archivo
           // wr.append(" ...continua"); //concatenamos en el archivo sin borrar lo existente
            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            //wr.append("mas contenido");
            //wr.close();
            bw.close();
        } catch (IOException e) {
        };
    }
    
    public static void agregarDatos(
            String nombreArchivo,
            String contenido
    ) {
        String datos = "";
        try {
            FileReader input = new FileReader(nombreArchivo);
            int c =0;
            c = input.read();
            while (c != -1) {
                //System.out.println(c+"  "+(char)c);
                datos += Character.toString((char)c);
                c = input.read();
            }
            input.close();
        } catch (IOException ex) {
            System.out.println("Error "+ex.getMessage());
        }
        if (datos.length() > 0){
            datos += "\n";
        }
        
        File f;
        f = new File(nombreArchivo);
        //Escritura
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
             //Escribimos en el fichero
            bw.write(datos + contenido);
            //Guardamos los cambios del fichero
            bw.flush();
           
            //PrintWriter wr = new PrintWriter(w);
            //wr.write("Primera línea");//escribimos en el archivo
           // wr.append(" ...continua"); //concatenamos en el archivo sin borrar lo existente
            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            //wr.append("mas contenido");
            //wr.close();
            bw.close();
        } catch (IOException e) {
        };
    }

    public static void lectura(
            String nombreArchivo
    ) {
        try {
            FileReader input = new FileReader(nombreArchivo);
            int c =0;
            while (c != -1) {
                c = input.read();
                //System.out.println(c+"  "+(char)c);
                System.out.print((char)c);
            }
            input.close();
        } catch (IOException ex) {
            System.out.println("Error "+ex.getMessage());
        }
    }
}
