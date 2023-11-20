public class Personaje {
    //Atributos
    private String nombre;
    private Integer dinero;
    private Integer hp_actual;
    private Integer hp_total;
    private Integer danio;
    private Integer defensa;

    //Constructor
    public Personaje(String nombre, Integer dinero, Integer hp_actual, Integer hp_total, Integer danio,
        Integer defensa) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.hp_actual = hp_actual;
        this.hp_total = hp_total;
        this.danio = danio;
        this.defensa = defensa;
    }
    /**
    * Crea un personaje con los parametros especificados
    *
    * @param nombre : Nombre que tendrá el personaje
    * @param dinero : Dinero con el que parte el personaje
    * @param hp_actual : Hp del personaje
    * @param hp_total : Hp total del personaje
    * @param danio : Puntos de daño que inflinge el personaje
    * @param defensa : Puntos de defensa del personaje para contrarrestar daño
    *
    * @return : No tiene retorno
    */

    //Setters & Getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDinero() {
        return dinero;
    }
    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public Integer getHp_actual() {
        return hp_actual;
    }
    public void setHp_actual(Integer hp_actual) {
        this.hp_actual = hp_actual;
    }

    public Integer getHp_total() {
        return hp_total;
    }
    public void setHp_total(Integer hp_total) {
        this.hp_total = hp_total;
    }

    public Integer getDanio() {
        return danio;
    }
    public void setDanio(Integer danio) {
        this.danio = danio;
    }

    public Integer getDefensa() {
        return defensa;
    }
    public void setDefensa(Integer defensa) {
        this.defensa = defensa;
    }

    //Metodos
    public void combate(Personaje Personaje){
        boolean flag = true;
        int comienzo = (int) (Math.random() * 2);
        while(flag){
            if(comienzo == 0){
                if(this.danio - Personaje.defensa > 0){
                    Personaje.setHp_actual(Personaje.hp_actual - (this.danio - Personaje.defensa));
                    System.out.println(Personaje.nombre + " a perdido " + (this.danio - Personaje.defensa) 
                    + " puntos de vida");
                }
                else{
                    System.out.println(Personaje.nombre + " a perdido 0 puntos de vida");
                }
                if(Personaje.hp_actual > 0){
                    if(Personaje.danio - this.defensa > 0){
                        this.setHp_actual(this.hp_actual - (Personaje.danio - this.defensa));
                        System.out.println("Haz perdido " + (Personaje.danio - this.defensa) 
                        + " puntos de vida");
                    }
                    else{
                        System.out.println("Haz perdido 0 puntos de vida");
                    }
                }
            }
            else if(comienzo == 1){
                if(Personaje.danio - this.defensa > 0){
                    this.setHp_actual(this.hp_actual - (Personaje.danio - this.defensa));
                    System.out.println("Haz perdido " + (Personaje.danio - this.defensa) 
                    + " puntos de vida");
                }
                else{
                    System.out.println("Haz perdido 0 puntos de vida");
                }
                if(this.hp_actual > 0){
                    if(this.danio - Personaje.defensa > 0){
                        Personaje.setHp_actual(Personaje.hp_actual - (this.danio - Personaje.defensa));
                        System.out.println(Personaje.nombre + " a perdido " + (this.danio - Personaje.defensa) 
                        + " puntos de vida");
                    }
                    else{
                        System.out.println(Personaje.nombre + " a perdido 0 puntos de vida");
                    }
                }
            }
            if(Personaje.hp_actual <= 0 || this.hp_actual <= 0){
                flag = false;
            }
        }
    }
    /**
    * Efectúa el combate entre el jugador y un enemigo
    *
    * @param Personaje : Personaje con el que se enfrenta el Jugador
    *
    * @return : No tiene retorno
    */
    
    public void recuperar_hp(Integer recuperar){
        this.hp_actual += recuperar;
        if(this.hp_actual > this.hp_total){
            this.hp_actual = this.hp_total;
        }
    }
    /**
    * Metodo de uso exclusivo en Jugador con el cual dado un parametro recuperar, lo suma al hp_actual del Jugador;
    * Si esta suma resulta mayor a hp_total, hp_actual se ajusta a hp_total.
    *
    * @param recuperar : Cantidad de hp que recupera el Jugador
    *
    * @return : No tiene retorno
    */

    public void aumentar_hp_total(Integer aumentar_hp){
        this.hp_total += aumentar_hp;
    }
    /**
    * Metodo de uso exclusivo en Jugador que aumenta el hp_total de este
    *
    * @param aumentar_hp : Cantidad de hp_total a aumentar 
    *
    * @return : No tiene retorno
    */

    public void aumentar_danio(Integer aumentar_danio){
        this.danio += aumentar_danio;
    }
    /**
    * Metodo de uso exclusivo en Jugador que aumenta el daño de este
    *
    * @param aumentar_danio : Cantidad de daño a aumentar
    *
    * @return : No tiene retorno
    */

    public void aumentar_defensa(Integer aumentar_defensa){
        this.defensa += aumentar_defensa;
    }
    /**
    * Metodo de uso exclusivo en Jugador que aumenta la defensa de este
    *
    * @param aumentar_defensa : Cantidad de defensa a aumentar
    *
    * @return : No tiene retorno
    */
}