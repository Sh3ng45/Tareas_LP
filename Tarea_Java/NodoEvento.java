public class NodoEvento extends Nodo{
    private String descripcion;
    private String alternativa1;
    private String alternativa2; 
    private Item resultado1;
    private Item resultado2; 

    //Eventos

    //Evento 1:
    String evento_1 = "Entras a una sala donde encuentras a dos sobrevivientes, una científica y un guardia."+
    "\nAl parecer lograron refugiarse de las criaturas, pero ambos se han infectado y pronto se convertiran."+
    "\nDurante tu camino encontraste una vacuna antivirica y debes usarla para salvar a uno de ellos."+
    "\nComo solo tienes una vacuna, debes matar al otro sobreviviente antes de que se convierta."+
    "\nQuien eligas te dara una recompensa por salvar su vida. ¿A quien salvarás?";
    String cientifica = "Salvar a la científica";
    String guardia = "Salvar al guardia";
    Item Stim_experimental = new Item("Stim experimental de batalla", 0, 60, 
    30, 0, 12);
    Item Casco_y_granadas = new Item("Casco antidisturbios y granadas", 0, 0, 
    0, 12, 18);

    //Evento 2:
    String evento_2 = "Encuentras una pequeña armeria. Lamentablemente está vacia a excepcion de dos "+
    "\ncontenedores que requieren una tarjeta de desbloqueo. Durante tu camino encontraste una tarjeta "+
    "\nde este tipo. Estas solo permiten un desbloqueo y despues quedan inutilizables."+
    "\nPuedes desbloquear un contenedor pero no sabes del contenido de cada uno. Lo que si es seguro es "+
    "\nque no estan vacios pues ambos tienen una luz verde que indica que hay un objeto dentro."+
    "\n¿Que contenedor abriras?";
    String izquierda = "El contenedor de la izquierda";
    String derecha = "El contenedor de la derecha";
    Item Kit_mejora_pistola = new Item("Kit de mejora para la pistola", 0, 0, 
    0, 8, 0);
    Item Escudo_antidisturbios = new Item("Escudo Antidisturbios", 0, 0, 
    0, 1, 10);

    //Evento 3:
    String evento_3 = "Entras a una sala de desarrollo de stims experimentales. Encuentras una maquina de"+
    "\ncreación con un stim en ultima fase. La maquina pide seleccionar una muestra de ingrediente para"+
    "\ncompletar el stim. Hay dos opciones, una muestra de V150 y otra de A300H; la primera dice que fortalece"+
    "\nla regeneracion celular y el sistema inmunológico y la otra dice que crea una gran resistencia al dolor"+
    "\ny un aumento de adrenalina."+
    "\n¿Que muestra eliges mezclar?";
    String V150 = "V150";
    String A300H = "A300H";
    Item Stim_vitalidad = new Item("Stim de vitalidad aumentada", 0, 50, 
    30, 0, 0);
    Item Stim_Defensa = new Item("Stim de defensa aumentada", 0, 0, 
    0, 0, 15);

    //Evento 4:
    String evento_4 = "Encuentras una impresora 3D especial de piezas y refuerzos. Al parecer solo queda filamento"+
    "\npara una impresión. Tienes dos opciones para elegir. La primera es un kit de accesorios de arma que"+
    "\nincluye un cañon largo, compensador y empuñadura, y la segunda opción es un Kit de proteccion coporal que"+
    "\nincluye mangas antimordidas y canilleras reforzadas"+
    "\n¿Que prefieres imprimir?";
    String Mejora_armas = "kit de accesorios de arma";
    String Kit_proteccion = "Kit de proteccion coporal";
    Item Kit_mejora_arma = new Item("Kit de accesorios de arma", 0, 0, 
    0, 15, 0);
    Item Kit_proteccion_corporal = new Item("Kit de protección corporal", 0, 0, 
    0, 0, 15);

    //Getters y setters
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlternativa1() {
        return alternativa1;
    }
    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }
    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public Item getResultado1() {
        return resultado1;
    }
    public void setResultado1(Item resultado1) {
        this.resultado1 = resultado1;
    }

    public Item getResultado2() {
        return resultado2;
    }
    public void setResultado2(Item resultado2) {
        this.resultado2 = resultado2;
    }

    //Constructor
    public NodoEvento() {
        this.tipo = "NodoEvento";
        int evento_random = (int) (Math.random() * 4);
        if(evento_random == 0){
            this.descripcion = evento_1;
            this.alternativa1 = cientifica;
            this.alternativa2 = guardia;
            this.resultado1 = Stim_experimental;
            this.resultado2 = Casco_y_granadas;
        }
        else if(evento_random == 1){
            this.descripcion = evento_2;
            this.alternativa1 = izquierda;
            this.alternativa2 = derecha;
            this.resultado1 = Kit_mejora_pistola;
            this.resultado2 = Escudo_antidisturbios;
        }
        else if(evento_random == 2){
            this.descripcion = evento_3;
            this.alternativa1 = V150;
            this.alternativa2 = A300H;
            this.resultado1 = Stim_vitalidad;
            this.resultado2 = Stim_Defensa;
        }
        else{
            this.descripcion = evento_4;
            this.alternativa1 = Mejora_armas;
            this.alternativa2 = Kit_proteccion;
            this.resultado1 = Kit_mejora_arma;
            this.resultado2 = Kit_proteccion_corporal;
        }
    }
    /**
    * Crea un evento seleccionando aleatoriamente uno preestablecido en la clase
    *
    * @param : No tiene parametros
    *
    * @return : No tiene retorno
    */

    //Metodo
    @Override
    public void interactuar(Jugador jugador){
        int desicion;
        boolean flag = true;
        System.out.println("Evento de desición");
        System.out.println(descripcion);
        System.out.println("Debes tomar una desición:");
        System.out.println("1. "+alternativa1);
        System.out.println("2. "+alternativa2);
        while(flag){
            System.out.print("Digite el numero de la alternativa escogida: ");
            desicion = Scan.scanner.nextInt();
            if(desicion == 1){resultado1.aplicar(jugador); flag = false;}
            else if(desicion == 2){resultado2.aplicar(jugador); flag = false;}
            else{System.out.println("Digito invalido");}
        }
    }
    /**
    * Le presenta el evento al jugador y le hace elegir una de las dos opciones que este tiene;
    * Luego de que el jugador elija, aplica el item de recompensa correspondiente a la opcion elegida
    *
    * @param a : Parametro Jugador para interactuar con este
    *
    * @return : No tiene retorno
    */
}