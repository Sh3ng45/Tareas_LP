public class JavaQuest {
    public static void main(String[] args) {
        String nombre;
        Integer profundidad, opcion;
        boolean flag = true;

        System.out.print("Introduce el nombre de tu personaje: ");
        nombre = Scan.scanner.nextLine();
        Jugador Jugador = new Jugador(nombre, 500, 20, 20, 0, 1);

        System.out.print("\nDigita la profundidad que quieres que tenga el mapa: ");
        profundidad = Scan.scanner.nextInt();
        Mapa Map = new Mapa(profundidad);

        Map.getNodo_inicial().interactuar(Jugador);
        System.out.println("\nComienza el juego!");
        do {
            System.out.println("\n¿Que deseas hacer?");
            System.out.println("\n1. Ver Mapa"+
                                "\n2. Ver estado actual"+
                                "\n3. Ver Items equipados"+
                                "\n4. Avanzar");
            System.out.print("\nDigita el numero correspondiente a la opción que quieres hacer: ");
            opcion = Scan.scanner.nextInt();
            switch (opcion) {
                case 1:
                    Map.verMapa();
                    break;
                case 2:
                    Jugador.verEstado();
                    break;
                case 3:
                    Jugador.verItems();
                    break;
                case 4:
                    Map.avanzar(Jugador);
                    break;
                default:
                    System.out.println("El numero digitado no es una opción, por favor digita una opción valida");
                    break;
            }
            if(Jugador.getHp_actual() <= 0){
                flag = false;
            }
            else if(Map.getAll_nodos().get(Map.getAll_nodos().size() - 1).tipo == "JefeMuerto"){
                flag = false;
            }
        } while (flag);
    }
}