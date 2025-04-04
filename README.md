¿Qué es este programa?

Este programa es una sencilla simulación de una maquina tragamonedas o tragaperras de un casino, mencionamos que es sencilla ya que esta cuenta solo con la función girar y el como
se van recorriendo las imágenes, por lo que no cuenta con funciones como ingresar dinero, ganancias, dinero actual, etc. Solo es como una simulación de la función del tragamonedas

Instrucciones de Uso
1. Es importante que veas el anuncio importante que encontrarás después de estás instrucciónes
2. Primero debes de entrar a donde dice com/app y tendras 2 opciones, imagenes o mvc, en imagenes vas a encontrar los simbolos ocupados para el tragamonedas, mientras que en mvc vas
   a encontrar las clases de modelo que tiene la lógica, visión que tiene la interfaz y controlador la cual gestiona la interacción del usuario y actua en base a esta y ejecutar
   que simplemente es la clase main para ejecutarlo
3. Vas a descargarlo todo en .zip y (desde la parte principal) lo vas a implementar en tu proyecto que quieras ocuparlo pegando todo a las clases junto con paquetes
4. Vas a entrar a la clase llamada "Modelo" que se encuentra en el paquete Modelo, y vas a buscar el método llamado "agregar_imagenes" y en vez de la ruta puesta lo que vas a ingresar
   va ser la ruta TUYA en donde se encuentran las imagenes, solo es cambiar de ruta (si deseas mas información mira la parte "Seguimiento del paso 4" que se encuentra en otro apartado.
5. Una vez que hayas hecho todo esto vas a poder usarla como si fuera tuya, ¡Felicidades!

Seguimiento del paso 4

Si te encuentras aquí probablemente sea porque no sepas como integrarlo, aqui estan los pasos:
1. Cuando ya tengas descargado todo vas a ir dentro del archivo a la parte llamada "imagenes"
2. Tendrás que seleccionar una imagen y le vas a dar click derecho
3. Posteriormente vas a darle a la opción "copiar como ruta de acceso"
4. Vas a ir al codigo de la clase llamada "Modelo" que se encuentra en el paquete Modelo, y vas a buscar el método llamado "agregar_imagenes" y vas a borrar solo lo primero (que se encuentra
   en los paréntesis)
5. Vas a pegar tu ruta. Ejemplo "C:\Users\jjvsj\OneDrive\Documentos\NetBeansProjects\Tragamonedas\src\main\java\Tragamonedas\com\app\imagenes\Bar.jpg"
6. Vas a borrar la parte "Bar.jpg" ya que esta ya estará concatenada (se verá que dice:   +simbolos[i]+".jpg"
7. Por el momento tendria que quedar asi: "C:\Users\jjvsj\OneDrive\Documentos\NetBeansProjects\Tragamonedas\src\main\java\Tragamonedas\com\app\imagenes\"
8. Ahora vas a ver los slash inversos (\), lo que harás a continuación va a ser cambiarlos por (/)
9. Ahora deberia de verse así:

   antes: "C:\Users\jjvsj\OneDrive\Documentos\NetBeansProjects\Tragamonedas\src\main\java\Tragamonedas\com\app\imagenes\"

   después: "C:/Users/jjvsj/OneDrive/Documentos/NetBeansProjects/Tragamonedas/src/main/java/Tragamonedas/com/app/imagenes/"
11. Una vez hecho esto ya podras ir al paso 5, ¡Bien hecho!
