public class NodoInicial extends Nodo {
    @Override
    public void interactuar(Jugador jugador){
        System.out.println("\nBienvenido a NEST 3, un spin-off fan del universo de Resident Evil."+
        "\nEn este juego tomas el control de un agente especial de la BSAA, enviado a investigar los rumores sobre"+
        "\nla existencia de NEST 3, el tercer homologo de los laboratorios subterraneos NEST de Racoon City, con"+
        "\nla particularidad de que este se encontraria en Alaska y que estaria bajo el control de una celula"+
        "\nbioterrorista que llego al lugar años despues de la caida de Umbrella. Las fuentes de la BSAA sugieren"+
        "\nque esta celula ha estado experimentando con diversos virus, obtenidos a traves del mercado negro."+
        "\n\nEres enviado, junto con un equipo, al lugar que dicen las coordenadas de inteligencia, una antigua"+
        "\nresidencia para altos ejecutivos de umbrella. Sin embargo al llegar, tú y tu equipo son emboscados por"+
        "\nuna horda de infectados, que parecen ser lo que queda de la celula bioterrorista. Todo tu equipo muere"+
        "\ny tú te ves obligado a escapar, pero el unico camino es bajar a NEST 3. Al bajar la comunicación con el"+
        "\ncuartel general se corta, por lo que no puedes pedir refuerzos. Ahora solo te queda intentar sobrevivir"+
        "\na las multiples amenazas que acechan en el laboratorio y encontrar una salida alternativa."+
        "\n\nInstrucciones de progreso:"+
        "\nAl inicio, comienzas solo con una pistola y sin proteccion corporal, por lo que para aumentar tus"+
        "\nestadisticas deberas conseguir mas armas que aumenten tu daño en combate y proteccion corporal que"+
        "\naumente tu defensa. Ademas deberas conseguir items de curación para recuperar tu hp perdido en el"+
        "\ncombate y tambien items de aumento de hp para hacer frente a enemigos mas fuertes. Esto lo puedes"+
        "\nconseguir comprando en los nodos tienda con el dinero que vas obteniendo al derrotar enemigos."+
        "\nTambien puedes conseguir items especiales de mejora de estadisticas en los nodos evento."+
        "\n\nInstrucciones de juego:"+
        "\nDurante el juego tienes cuatro opciones a realizar:"+
        "\n1- Ver el mapa, lo cual te mostrará el mapa entero y te indicara tu posición actual"+
        "\n2- Ver tu estado actual, lo cual te mostrará tus estadisticas actuales"+
        "\n3- Ver tus items, lo cual te mostrara todos tus items junto con sus estadisticas"+
        "\n4- Avanzar, lo cual te hará avanzar al siguiente nodo e interactuar con el"+
        "\nImportante: Mientras estes en un combate, comprando en una tienda o en un evento, no podras"+
        "\nrealizar ninguna de estas acciones hasta terminar");
    }
    /**
    * Inicio del Juego. Le muestra al Jugador la historia del juego, las instrucciones de progreso
    * y las instrucciones de juego
    *
    * @param Jugador : Parametro Jugador para interactuar con este
    *
    * @return : No tiene retorno
    */
}