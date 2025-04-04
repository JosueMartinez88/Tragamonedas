

//Martínez Vera Josué Aldair
//Solís Contreras Darian Giselle

package Tragamonedas.com.app.mvc.modelo;

//Importamos la libreria swing junto con todas sus clases y métodos
import javax.swing.*;
//Importamos la libreria awt junto con todas sus clases y métodos
import java.awt.*;
//Importamos la libreria util de clase Random para usarlo para las vueltas aleatorias de la ruleta
import java.util.Random;

//Esta es la clase Modelo en el que se buscan los conceptos o implementaciones
public class Modelo {
    
    //Instanciamos el objeto imagenes de la clase ImageIcon y va a ser una matriz
    private ImageIcon [][] imagenes;
    //Instanciamos el objeto rand de la clase Random
    Random rand = new Random();
    //Declaramos 2 variables para la funcion random
    public int aleatorio,aux;
    //Creamos una arreglo que nos guarde los nombres de cada imagen
    private String[] simbolos = {"Cereza", "Limon", "Naranja", "Campana", "Bar", "Siete"};
    
    //Creamos el método constructor
    public Modelo(){
        //Decimos que nuestra matriz va a tener 6 filas y 3 columnas
        imagenes = new ImageIcon[6][3];
        //Agregamos el método "agregar_imagenes" que creamos más abajo
        agregar_imagenes();
        
        
    }
    
    //Este método es para agregar imagenes
    public void agregar_imagenes(){
        //Decimos en este ciclo que van a haber 6 filas
        for(int i = 0; i < 6; i++){
            //Decimos en este ciclo que van a haber 3 columnas
            for(int j = 0; j < 3; j++){
                //Agregamos las imagenes, aquí deben de poner la ruta de sus imagenes, en este caso esta es la mia y si ven se van recorriendo
                imagenes[i][j] = new ImageIcon("C:/Users/jjvsj/OneDrive/Documentos/NetBeansProjects/Tragamonedas/src/main/java/Tragamonedas/com/app/imagenes/"+simbolos[i]+".jpg");
            }
        }       
    }
    
    //Este metodo es para obtener la columa y su parametro indica cual columna va a ser
    public ImageIcon[] getColumna(int i){
        //Aqui colocamos cuantas columnas van a haber
        if (i >= 0 && i < 3) {
            //Aqui creamos una "columna completa" la cual nos va a almacenar los 6 símbolos de la columna
            ImageIcon[] columna_completa = new ImageIcon[6]; 
            //Este ciclo es para referirnos a la fila
            for (int j = 0; j < 6; j++) {
                //Acá buscamos a acceder unicamente a la fila de la columna "i"
                columna_completa[j] = imagenes[j][i]; 
            }
            //Nos va a retornar la columna entera
            return columna_completa;
        } 
        else {
            // Maneja el caso donde el índice no es válido
            System.out.println("Índice de columna fuera de rango.");
            return new ImageIcon[0]; //Devolver un arreglo vacío si el índice es incorrecto.
        }
    }
    
    //Este método es para crear un número aleatorio que son las vueltas que va a tener cada columna
    public int num_random(){
        //Al auxiliar le vamos a dar un número aleatorio desde 30 a 50
        aux = rand.nextInt(30)+20;
        //Decimos que el aleatorio va a tomar el valor del auxiliar
        aleatorio = aux;
        //Retornamos el aleatorio
        return aleatorio;
    }
    
    
}
