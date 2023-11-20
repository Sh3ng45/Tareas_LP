import java.util.ArrayList;
import java.util.List;

public class Jugador extends Personaje {
    //Atributos
    private List<Item> items_aplicados = new ArrayList<Item>();

    //Constructor
    public Jugador(String nombre, Integer dinero, Integer hp_actual, Integer hp_total, Integer danio,
    Integer defensa){
        super(nombre, dinero, hp_actual, hp_total, danio, defensa);
        Item Pistola = new Item("Pistola", 0, 0, 0, 
        5, 0);
        Pistola.aplicar(this);
    }
    /**
    * Crea el objeto Jugador junto con sus estadisticas iniciales, ademas le confiere una pistola 
    * que inicia su daño en 5 puntos
    *
    * @param nombre : Nombre que tendrá el Jugador
    * @param dinero : Dinero con el que parte el jugador
    * @param hp_actual : Hp del Jugador
    * @param hp_total : Hp total del Jugador
    * @param danio : Puntos de daño que inflinge el Jugador
    * @param defensa : Puntos de defensa del Jugador para contrarrestar daño
    *
    * @return : No tiene retorno
    */

    //Getter y Setter

    public List<Item> getItems_aplicados() {
        return items_aplicados;
    }
    public void setItems_aplicados(List<Item> items_aplicados) {
        this.items_aplicados = items_aplicados;
    }

    //Metodos 
    public void verEstado(){
        System.out.println("Nombre del personaje: "+getNombre()+
        "\nDinero: $"+getDinero()+
        "\nhp actual: "+getHp_actual()+
        "\nhp total: "+getHp_total()+
        "\nDaño: "+getDanio()+
        "\nDefensa: "+getDefensa());
    }
    /**
    * Muestra al Jugador sus estadisticas actuales
    *
    * @param : No tiene parametros
    *
    * @return : No tiene retorno
    */

    public void agregarItem(Item item){
        items_aplicados.add(item);
    }
    /**
    * Agrega un item conseguido a la lista de items del Jugador
    *
    * @param item : item que se agregará a la lista de items del jugador
    *
    * @return : No tiene retorno
    */

    public void verItems(){
        System.out.println("Items adquiridos: ");
        for(Item item: items_aplicados){
            System.out.println("\n"+item.getNombre_item());
            System.out.println("Recupera "+item.getRecuperar_hp()+" puntos de hp");
            System.out.println("Aumenta "+item.getAumentar_hp_total()+" puntos del hp máximo");
            System.out.println("Aumenta "+item.getAumentar_danio()+" puntos de daño");
            System.out.println("Aumenta "+item.getAumentar_defensa()+" puntos de defensa");
        }
    }
    /**
    * Muestra al jugador los items que ha conseguido 
    *
    * @param : No tiene parametros
    *
    * @return : No tiene retorno
    */
}