public class Item {
    //Atributos
    private String nombre_item;
    private Integer precio; 
    private Integer recuperar_hp;
    private Integer aumentar_hp_total;
    private Integer aumentar_danio;
    private Integer aumentar_defensa;
    
    //Constructor
    public Item(String nombre_item, Integer precio, Integer recuperar_hp, Integer aumentar_hp_total,
            Integer aumentar_danio, Integer aumentar_defensa) {
        this.nombre_item = nombre_item;
        this.precio = precio;
        this.recuperar_hp = recuperar_hp;
        this.aumentar_hp_total = aumentar_hp_total;
        this.aumentar_danio = aumentar_danio;
        this.aumentar_defensa = aumentar_defensa;
    }
    /**
    * Crea un item con su nombre y estadisticas de mejora
    *
    * @param nombre_item : Nombre del item
    * @param precio : Precio del item en la tienda
    * @param recuperar_hp : Cantidad de hp que recupera al jugador
    * @param aumentar_hp_total : Cantidad de hp_total que aumenta al jugador
    * @param aumentar_danio : Cantidad de daño que aumenta al jugador
    * @param aumentar_defensa : Cantidad de defensa que aumenta al jugador
    *
    * @return : No tiene retorno
    */

    //Getters
    public String getNombre_item() {
        return nombre_item;
    }
    public void setNombre_item(String nombre_item) {
        this.nombre_item = nombre_item;
    }
    public Integer getPrecio() {
        return precio;
    }
    public Integer getRecuperar_hp() {
        return recuperar_hp;
    }
    public Integer getAumentar_hp_total() {
        return aumentar_hp_total;
    }
    public Integer getAumentar_danio() {
        return aumentar_danio;
    }
    public Integer getAumentar_defensa() {
        return aumentar_defensa;
    }

    //Metodos
    public void aplicar(Jugador Jugador){
        System.out.println("Haz conseguido "+this.getNombre_item());
        Jugador.getItems_aplicados().add(this);
        Jugador.aumentar_hp_total(this.aumentar_hp_total);
        Jugador.recuperar_hp(this.recuperar_hp);
        Jugador.aumentar_danio(this.aumentar_danio);
        Jugador.aumentar_defensa(this.aumentar_defensa);
    }
    /**
    * Muestra al jugador el nombre del item conseguido y aplica sus estadisticas
    *
    * @param Jugador : Parametro Jugador usado para aplicar estadisticas a este
    *
    * @return : No tiene retorno
    */
}