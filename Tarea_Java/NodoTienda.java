import java.util.ArrayList;
import java.util.List;

public class NodoTienda extends Nodo {
    //Atributos
    private List<Item> inventario = new ArrayList<Item>();
    private List<Item> all_items = new ArrayList<Item>();

    //Items de tienda
    Item Spray_primeros_auxilios = new Item("Spray primeros auxilios", 200, 50, 
    10, 0, 0);

    Item Hierba_verde = new Item("Hierba verde", 50, 10, 0,
    0, 0);

    Item Hierba_amarilla = new Item("Hierba amarilla", 60, 0, 10, 
    0, 0);

    Item Stim_VA = new Item("Stim V+A", 100, 6, 12, 
    0, 1);

    Item Chaleco_MK1 = new Item("Chaleco MK1", 400, 0, 
    0, 0, 10);

    Item Chaleco_MK2 = new Item("Chaleco MK2", 500, 0, 
    0, 0, 15);

    Item Chaleco_MK3 = new Item("Chaleco MK3", 600, 0, 
    0, 0, 20);
    
    Item Cuchillo_de_defensa = new Item("Cuchillo de defensa", 100, 0, 
    0, 3, 0);

    Item Escopeta = new Item("Escopeta", 450, 0, 0, 
    8, 0);

    Item Fusil_de_asalto = new Item("Fusil de asalto", 300, 0, 
    0, 6, 0);

    Item Magnum = new Item("Magnum", 800, 0, 0, 
    14, 0);

    Item Lanzallamas = new Item("Lanzallamas", 600, 0, 0, 
    12, 0);

    Item MQH101_drone = new Item("MQH101 drone", 700, 0, 0, 
    7, 8);

    Item PRLH300_prototype = new Item("PRLH300 prototype", 1200, 0, 
    0, 20, 0);

    //Constructor
    public NodoTienda() {
        this.tipo = "NodoTienda";
        if(all_items.isEmpty()){listaItems(all_items);}
        int cont = 1;
        while(cont<=5){
            int random = (int) (Math.random() * 14);
            if(inventario.contains(all_items.get(random)) == false){
                inventario.add(all_items.get(random));
                cont++;
            }
        }
    }
    /**
    * Crea una tienda con una selección aleatoria de items preestablecidos 
    *
    * @param : No tiene parametros
    *
    * @return : No tiene retorno
    */

    //Metodos
    public void listaItems(List<Item> all_items){
        all_items.add(Spray_primeros_auxilios);
        all_items.add(Hierba_verde);
        all_items.add(Hierba_amarilla);
        all_items.add(Stim_VA);
        all_items.add(Chaleco_MK1);
        all_items.add(Chaleco_MK2);
        all_items.add(Chaleco_MK3);
        all_items.add(Cuchillo_de_defensa);
        all_items.add(Escopeta);
        all_items.add(Fusil_de_asalto);
        all_items.add(Magnum);
        all_items.add(Lanzallamas);
        all_items.add(MQH101_drone);
        all_items.add(PRLH300_prototype);
    }
    /**
    * Guarda todos los items preestablecidos en una lista para su posterior seleccion aleatoria en la creación 
    * de la tienda
    *
    * @param all_items : Lista usada para guardar todos los items
    *
    * @return : No tiene retorno
    */

    public void comprar(Integer integer, Jugador jugador){
        if (jugador.getDinero() >= inventario.get(integer).getPrecio()) {
            inventario.get(integer).aplicar(jugador);
            jugador.setDinero(jugador.getDinero()-inventario.get(integer).getPrecio());
        } else {
            System.out.println("No dispone del dinero suficiente para comprar este item");
        }
    }
    /**
    * Efectua la accion de comprar un item por parte del jugador, verificando que este disponga del 
    * dinero suficiente para la compra
    *
    * @param integer : Número del item que se quiere comprar 
    * @param jugador : Parametro jugador para comprobar su dinero y aplicar la compra
    *
    * @return : No tiene retorno
    */
    
    @Override
    public void interactuar(Jugador Jugador){
        int opcion;
        int desicion;
        boolean activo = true;
        do{
            int num = 1;
            System.out.println("\nDinero disponible: "+Jugador.getDinero());
            System.out.println("Items disponibles para comprar:");
            for(Item i_tienda: inventario){
                System.out.println(String.valueOf(num)+"."+" "+i_tienda.getNombre_item()+"   "+"precio: $"+i_tienda.getPrecio());
                num++;
            }
            System.out.print("\nDigite el numero del item que desea comprar: ");
            opcion = Scan.scanner.nextInt();
            if (opcion <= inventario.size() && opcion >= 0) {
                comprar(opcion-1, Jugador);
            } else {
                System.out.println("Error: El numero digitado no es valido");
            }
            System.out.println("¿Desea continuar comprando?"+
                                "\nDigite 0 para continuar"+
                                "\nDigite 1 para salir");
            desicion = Scan.scanner.nextInt();
            if(desicion == 1){
                activo = false;
            }
        }while(activo != false);
    }
    /**
    * Le muestra al jugador los items disponibles en la tienda y le permite seleccionar el item que desea comprar,
    * ademas muestra al jugador su dinero disponible para las compras
    *
    * @param Jugador : Parametro Jugador para interactuar con este
    *
    * @return : No tiene retorno
    */
}