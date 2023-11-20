import java.util.ArrayList;
import java.util.List;

public abstract class Nodo {
    //Atributos
    protected Integer id;
    protected String tipo;
    protected List<Nodo> siguientes_nodos = new ArrayList<Nodo>();

    //Setter y Getter id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //Metodos
    public abstract void interactuar(Jugador Jugador); //abstract
    /**
    * Funcion hereditaria a los diferentes tipos de nodos
    *
    * @param Jugador : Parametro Jugador para interactuar con este
    *
    * @return : No tiene retorno
    */

    public void agregarNodo(Nodo Nodo){
        siguientes_nodos.add(Nodo);
    }
    /**
    * Agrega los nodos alcanzables por el nodo actual a su lista de siguientes_nodos
    *
    * @param Nodo : Nodo a agregar a la lista de siguientes_nodos
    *
    * @return : No tiene retorno
    */
}