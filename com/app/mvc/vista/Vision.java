

//Martínez Vera Josué Aldair
//Solís Contreras Darian Giselle
package Tragamonedas.com.app.mvc.vista;

//Importamos la clase modelo
import Tragamonedas.com.app.mvc.modelo.*;
//Importamos la clase controlador
import Tragamonedas.com.app.mvc.controlador.*;
//Importamos la libreria swing junto con todas sus clases y métodos
import javax.swing.*;
//Importamos la libreria awt junto con todas sus clases y métodos
import java.awt.*;

//Esta es la clase visión, la que se le va a mostrar a los usuarios y es extensión de JFrame
public class Vision extends JFrame{
    //Instanciamos un objeto etiquetas de la clase Label
    private JLabel [][] etiquetas;
    //Instanciamos un panel que es el que tendrá los simbolos
    private JPanel panel_imagen;
    Modelo modelo = new Modelo();
    
    public Vision(int alto, int largo, String titulo) {
        this.setSize(alto, largo); //Establece el tamaño de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Configura la operación de cierre
        this.setLocationRelativeTo(null); //Centra la ventana en la pantalla
        this.setTitle("Juego tragamonedas"); //Establece el título de la ventana
        this.setLayout(new GridLayout(3, 2)); //Configura el diseño de la ventana principal
        Ventana_inicio(); //Carga los componentes de la ventana
        this.setVisible(true); //Hace visible la ventana
        
    }
    
    //Esta es la ventana principal
    private void Ventana_inicio(){
        //Mandamos a llamar el método información
        informacion();
        //Mandamos a llamar el método imagenes
        imagenes();
        //Mandamos a llamar al método boton_girar
        boton_girar();
    }
    
    //Este metodo solo nos dice que como se llama la máquina
    private void informacion(){
        //Creamos un panel para este metodo
        JPanel información = new JPanel();
        //Le decimos que solo consta de una fila y una columna
        información.setLayout(new GridLayout(1, 1));
        //Le ponemos un nombre y lo centramos, pero instanciamos una etiqueta llamada maquina de la clase JLabel
        JLabel maquina = new JLabel("Maquina Tragaperras",SwingConstants.CENTER);
        //Agregamos la etiqueta llamada máquina a nuestro panel
        información.add(maquina);
        //Agregamos el panel "información" a la ventana principal
        this.add(información);
    }
    
    //Este método es para añadir las imagenes a la ventana
    private void imagenes(){
        //Declaramos una variable llamada "contador" y lo inicializamos en 0 
        int contador = 0;
        //Instanciamos un objeto etiqueta de al clase JLabel que va a ser una matriz con 6 filas y 3 columnas
        etiquetas = new JLabel[6][3];
        //Creamos un panel para las imagenes, la cual es 3x3 (3 filas, 3 columnas)
        panel_imagen = new JPanel(new GridLayout(3,3));
        //Este for recorre las filas
        for(int i = 0; i < 6; i++){
            //Este for recorre las columnas
            for (int j = 0; j < 3; j++){
                //Dependiendo la fila y columna hacemos que este vacia, se queda vacia ya que en este espacio
                //vamos a colocar la etiqueta
                etiquetas[i][j] = new JLabel("");
                //Usamos una condicional la cual dice que si contador es llega a 8 va a entrar y de ahi para
                if(contador < 9){
                    //A cada etiqueta la vamos a añadira al panel, justo ponemos que cuando llegue a 8 pare 
                    //para que solo nos almacene en el panel 9 imagenes y no las 18, 9 estan visibles y 9 escondidas
                    panel_imagen.add(etiquetas[i][j]);
                }
                //El contador aumenta uno
                contador++;
            }
        }
        //Mandamos a llamar el método "Actualizar_imagen" que hicimos debajo
        actualizar_imagen();
        //A la ventana principal añadimos el panel
        this.add(panel_imagen);
    }
    
    //Creamos un método que va a actualizar la imagen
    private void actualizar_imagen(){
        //Ciclo para recorrer columnas
        for(int i = 0; i < 3; i++){
            //Intanciamos un objeto llamado imagenes columna de la clase ImageIcon y va a agarrar los datos
            //del metodo getColumna de la clase modelo
            ImageIcon[] imagenes_columna = modelo.getColumna(i);
            //Ciclo para recorrer filas
            for (int j = 0; j < 6; j++){
                //Agregamos la imagen a un fila y una columna de acuerdo a la columna que se encuentra
                etiquetas[j][i].setIcon(imagenes_columna[j]);
            }
        }
    }
    
    //Este método boton_girar es para el boton
    private void boton_girar(){
        //Creamos un panel específico para el boton
        JPanel panel_boton = new JPanel();
        //Instanciamos el objeto boton de la clase JButton y en el boton va a decir "Girar"
        JButton boton = new JButton("Girar");
        //Usamos este método para que el programa lea cuando el usuario le da click
        boton.addActionListener(e ->{
            //Cuando el usuario le de click va a ir al metodo girar que hicimos abajo
            girar();
        });
        //Añadimos al panel el boton
        panel_boton.add(boton);
        //Añadimos a la ventana el panel
        this.add(panel_boton);
    }
    
    //Creamos un método llamado girar
    private void girar(){
        //Instanciamos obejtos de diferentes hilos y a cada uno le vamos a colocar las filas y las columnas a las que
        //Pertenecen con un JLabel, también su otro parámetro es el modelo y la columna en la que se encuentra
        Hilo_1 columna_1 = new Hilo_1(new JLabel[]{etiquetas[0][0], etiquetas[1][0], etiquetas[2][0],etiquetas[3][0], etiquetas[4][0], etiquetas[5][0]},modelo,0);
        Hilo_2 columna_2 = new Hilo_2(new JLabel[]{etiquetas[0][1], etiquetas[1][1], etiquetas[2][1],etiquetas[3][1], etiquetas[4][1], etiquetas[5][1]}, modelo, 1);
        Hilo_3 columna_3 = new Hilo_3(new JLabel[]{etiquetas[0][2], etiquetas[1][2], etiquetas[2][2],etiquetas[3][2], etiquetas[4][2], etiquetas[5][2]}, modelo, 2);
        //Decimos que el hilo llamado "Columna_1" empiece a trabajar con el método start
        columna_1.start();
        //Decimos que el hilo llamado "Columna_2" empiece a trabajar con el método start aunque el otro esté trabajando
        columna_2.start();
        //Decimos que el hilo llamado "Columna_2" empiece a trabajar con el método start aunque el otro esté trabajando
        columna_3.start();
    }
}
