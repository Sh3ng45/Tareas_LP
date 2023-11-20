import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import GraphGenerator.*;

public class Mapa {
    //Atributos
    private Integer profundidad; 
    private NodoInicial nodo_inicial; 
    private Nodo nodo_actual;
    private List<Nodo> all_nodos = new ArrayList<Nodo>();

    //Constructor
    public Mapa(Integer profundidad) {
        this.profundidad = profundidad;
        SortedSet<Edge> edges = GraphGenerator.Generar(profundidad);
        this.nodo_inicial = new NodoInicial();
        this.nodo_actual = nodo_inicial;
        int cont = 0;
        all_nodos.add(nodo_inicial);
        while(cont < edges.last().x){
            double determinar_nodo = Math.random();
            if(determinar_nodo < 0.6){ 
                NodoCombate NodoCombate = new NodoCombate();
                all_nodos.add(NodoCombate);
            }
            else if(determinar_nodo < 0.9){
                NodoEvento NodoEvento = new NodoEvento();
                all_nodos.add(NodoEvento);
            }
            else{
                NodoTienda NodoTienda = new NodoTienda();
                all_nodos.add(NodoTienda);
            }
            cont++;
        }
        NodoJefeFinal jefe = new NodoJefeFinal();
        all_nodos.add(jefe);
        for (Edge e : edges) {
            all_nodos.get(e.x).siguientes_nodos.add(all_nodos.get(e.y));
            all_nodos.get(e.x).id = e.x;
        }
        all_nodos.get(edges.last().y).id = edges.last().y;       
    }
    /**
    * Dada una profundidad, crea el Mapa del juego junto con todos sus nodos
    *
    * @param profundidad : Cantidad de pisos que tiene el mapa
    *
    * @return : No tiene retorno
    */

    //Getters y Setters
    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }
    public Integer getProfundidad() {
        return profundidad;
    }

    public NodoInicial getNodo_inicial() {
        return nodo_inicial;
    }
    public void setNodo_inicial(NodoInicial nodo_inicial) {
        this.nodo_inicial = nodo_inicial;
    }

    public Nodo getNodo_actual() {
        return nodo_actual;
    }
    public void setNodo_actual(Nodo nodo_actual) {
        this.nodo_actual = nodo_actual;
    }

    public List<Nodo> getAll_nodos() {
        return all_nodos;
    }

    //Metodos
    public void verMapa(){
        SortedSet<Edge> mapa = GraphGenerator.Generar(profundidad);
        System.out.println("Mostrando Mapa:" + "\n" + "\n****************");
        for (Edge m : mapa) {
            System.out.printf("*  (%d) -> (%d)  *\n", m.x, m.y);
        }
        System.out.println("******************\n");
        System.out.println("Te encuentras en el nodo "+nodo_actual.id);
    }
    /**
    * Muestra el mapa al jugador y el nodo en el que se encuentra actualmente
    *
    * @param : No tiene parametros
    *
    * @return : No tiene retorno
    */

    public void avanzar(Jugador Jugador){
        int opcion;
        boolean flag = true;
        System.out.println("\nPuedes avanzar al Nodo: ");
        for (Nodo siguiente : nodo_actual.siguientes_nodos) {
            System.out.println("("+siguiente.id+") :  " + siguiente.tipo);
        }
        System.out.print("Selecciona el Nodo al que quieres avanzar digitando su número: ");
        while(flag){
            opcion = Scan.scanner.nextInt();
            if(opcion < nodo_actual.siguientes_nodos.get(0).id || opcion > nodo_actual.siguientes_nodos.get(nodo_actual.siguientes_nodos.size() - 1).id){
                System.out.println("El numero digitado no es valido para un nodo alcanzable."+
                "\nPor favor digite un numero de nodo valido");
            }
            else{
                nodo_actual = all_nodos.get(opcion);
                nodo_actual.interactuar(Jugador);
                flag = false;
            }
        }
    }
    /**
    * Le muestra al Jugador los nodos a los que puede avanzar y lo hace elegir uno de ellos, ademas una vez
    * elegido el nodo lo hace avanzar a ese nodo e interactuar con el
    *
    * @param Jugador : Parametro Jugador para hacerlo avanzar
    *
    * @return : No tiene retorno
    */
}