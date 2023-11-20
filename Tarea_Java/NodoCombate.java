import java.util.ArrayList;
import java.util.List;

public class NodoCombate extends Nodo{
    //Atributos
    private Personaje enemigo;
    private List<Personaje> personajes = new ArrayList<Personaje>();

    //Enemigos
    Personaje Zombie = new Personaje("Zombie", 50, 10, 10, 
    3, 1);

    Personaje Crimson_Head = new Personaje("Crimson Head", 100, 18, 18, 
    5, 1);

    Personaje Perro_infectado = new Personaje("Perro infectado", 40, 8, 8, 
    2, 0);

    Personaje Oso_infectado = new Personaje("Oso infectado", 150, 25, 25, 
    5, 3);

    Personaje BOW_Aternos = new Personaje("B.O.W Aternos", 200, 25, 25, 
    8, 4);

    Personaje BOW_Executioner = new Personaje("B.O.W Executioner", 250, 30, 30, 
    10, 4);

    Personaje Hunter = new Personaje("Hunter", 150, 30, 30, 
    7, 7);

    Personaje Regenerador = new Personaje("Regenerador", 250, 40, 40, 
    6, 9);

    Personaje Parasito_G = new Personaje("Parasito G adulto", 150, 15, 15, 
    6, 3);

    Personaje Licker = new Personaje("Licker", 120, 20, 20, 
    7, 1);

    Personaje Verdugo = new Personaje("Verdugo", 300, 45, 45, 
    10, 5);

    Personaje Yawn = new Personaje("Yawn", 400, 50, 50, 
    15, 10);
    
    //Constructor
    public NodoCombate() {
        this.tipo = "NodoCombate";
        if(personajes.isEmpty()){listaPersonajes(personajes);}
        int random = (int) (Math.random() * 12);
        this.enemigo = personajes.get(random);
    }
    /**
    * Crea un nodo de combate seleccionando aleatoriamente uno de los enemigos preestablecidos
    *
    * @param : No tiene parametros
    *
    * @return : No tiene retorno
    */

    //Metodos
    public void listaPersonajes(List<Personaje> personajes){
        personajes.add(Zombie);
        personajes.add(Crimson_Head);
        personajes.add(Perro_infectado);
        personajes.add(Oso_infectado);
        personajes.add(BOW_Aternos);
        personajes.add(BOW_Executioner);
        personajes.add(Hunter);
        personajes.add(Regenerador);
        personajes.add(Parasito_G);
        personajes.add(Licker);
        personajes.add(Verdugo);
        personajes.add(Yawn);
    }
    /**
    * Guarda todos los personajes preestablecidos en una lista de personajes para su posterior seleccion en
    * la creacion del nodo combate
    *
    * @param personajes : Lista que guarda todos los personajes preestablecidos
    *
    * @return : No tiene retorno
    */

    @Override
    public void interactuar(Jugador Jugador){
        Jugador.combate(enemigo);
        if(Jugador.getHp_actual() > 0){
            System.out.println("Haz ganado el combate!!");
            Jugador.setDinero(Jugador.getDinero()+enemigo.getDinero());
            System.out.println("Obtuviste $"+enemigo.getDinero()+" de "+enemigo.getNombre());
        }
        else if(enemigo.getHp_actual() > 0){
            System.out.println("Haz muerto");
        }
    }
    /**
    * Hace efectivo el combate entre el Jugador y el enemigo con el llamado del respectivo metodo combate
    * Ademas informa el resultado del combate al Jugador y si es que este gana, el dinero conseguido del enemigo
    *
    * @param Jugador : Parametro Jugador para interactuar con este
    *
    * @return : No tiene retorno
    */
}