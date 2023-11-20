Nombre: Vicente Henríquez 
ROL: 202051507-7

Para correr el programa se deben utilizar los siguientes comandos de makefile:
-make compile: compila todos los archivos .java
-make ejecutar: ejecuta los archivos compilados
-make clean: limpia todos los archivos .class
Por lo que primero se debe usar el comando "make compile", y luego "make ejecutar"

Consideraciones:
-agregué un atributo nombre_item a la clase Item para poder utilizar de mejor manera los nombres 
de los items y poder mostrarlos por pantalla con espacios.

-agregué un atributo tipo a los Nodos para facilitar el mostrar el tipo de nodo al que se quiere 
avanzar en el mapa.

-cree funciones exclusivas para aplicar estadisticas de items al jugador, para de esta forma poder 
usar los setters predeterminados de la clase personaje en los demas personajes

-los items y enemigos estan preestablecidos