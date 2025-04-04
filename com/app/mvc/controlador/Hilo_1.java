
//Martínez Vera Josué Aldair
//Solís Contreras Darian Giselle

package Tragamonedas.com.app.mvc.controlador;
//Importamos la clase modelo
import Tragamonedas.com.app.mvc.modelo.*;
//Importamos libreria swing
import javax.swing.*;
//Estas librerias de a continuación son para poder usar el try_catch
import java.util.logging.Level;
import java.util.logging.Logger;

//Creamos un hilo el cual corresponde a la primera columna, y heredará metodos de la clase Thread
public class Hilo_1 extends Thread {
    //Instanciamos la clase Modelo
    Modelo modelo;
    //Creamos un arreglo el cual va a guardar los elementos de la columna
    JLabel[] etiquetas;
    //Creamos una variable para indicar la columna a la que se refiere
    public int columna;
    
    //Hacemos un método constructos que nos diga las etiquetas que va a tener, la clase y la columna que va a agarrar
    public Hilo_1(JLabel[] etiquetas, Modelo modelo, int columna) {
        this.etiquetas = etiquetas; //Nos dice cuales etiquetas estarán en la columna
        this.modelo = modelo; //Instanciamos el modelo
        this.columna = columna; //Indica la columna
    }
    
    //Método run de la clase Threads que heredamos
    public void run(){
        //Este ciclo es para que recorra varias veces cada imagen hasta que llegue al num random
        for(int i = 0; i <= modelo.num_random(); i++){
            //Este try-catch es para hacer uso del método sleep de threads
            try {
                //Vamos a crear iconos de imagenes en base a la columna, es como volverlas a crear o poner y recorrerlas
                ImageIcon[] columnas_vistas = modelo.getColumna(columna);
                //Creamos ese ciclo para que nos guarde las 6 imagenes pertenecientes a la columna
                for(int j = 0; j < 6; j++){
                    //De acuerdo a cada indice de la variable etiquetas le vamos a colocar una imagen distinta
                    etiquetas[j].setIcon(columnas_vistas[(j+i)%6]);
                }
                //Decimos que cada que recorra una imagen va a esperar 90 milisegundos
                Thread.sleep(90);
            } catch (InterruptedException ex) {
                //Ya esta es la excepción que creamos para poder ocupar el metodo sleep
                Logger.getLogger(Hilo_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
