public class NodoJefeFinal extends Nodo{
    private Personaje jefe; 

    //Jefe
    Personaje Tyrant_TX = new Personaje("Tyrant T-X", 5000, 100, 100, 
    30, 20);

    //Constructor
    public NodoJefeFinal() {
        this.tipo = "NodoJefeFinal";
        this.jefe = Tyrant_TX;
    }
    /**
    * Crea el nodo del jefe final
    *
    * @param : No tiene parametros
    *
    * @return : No tiene retorno
    */

    //Metodo
    @Override
    public void interactuar(Jugador Jugador){
        Jugador.combate(jefe);
        if(Jugador.getHp_actual() > 0){
            this.tipo = "JefeMuerto";
            System.out.println("Haz derrotado al Tyrant!!");
            System.out.println("Felicidades, haz ganado el juego");
        }
        else if(jefe.getHp_actual() > 0){
            System.out.println("Haz muerto");
        }
    }
    /**
    * Hace efectivo el combate entre el Jugador y el jefe final con el llamado al metodo combate.
    * Ademas informa al jugador el resultado del combate y si es que este gana, lo felicita por ganar el juego
    *
    * @param Jugador : Parametro Jugador para interactuar con este
    *
    * @return : No tiene retorno
    */
}