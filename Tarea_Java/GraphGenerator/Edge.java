package GraphGenerator;

public class Edge implements Comparable<Edge> {
    public final Integer x;
    public final Integer y;

    public Edge(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    /**
    * Crea un edge
    *
    * @param : No tiene parametros
    *
    * @return : No tiene retorno
    */

    public int compareTo(Edge e) {
        int first = this.x.compareTo(e.x);
        int second = this.y.compareTo(e.y);
        return first != 0 ? first : second;
    }
    /**
    * Compara que edge es primero y cual segundo en el orden
    *
    * @param e : Parametro edge para efectuar comparación
    *
    * @return int : Retorna entero
    */

}
