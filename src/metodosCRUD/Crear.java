package metodosCRUD;

import metodosObjetos.Carta;
import metodosObjetos.Deck;
import metodosObjetos.Spell;
import metodosObjetos.Unidad;

public class Crear {
    public static Carta Crea(Carta carta) {
        int eleccion = 1;
        int vida;
        int poder;
        Carta nuevaCarta = null;
        System.out.println("¿ Desea crear una unidad (1) o un hechizo (2) ?");
        if (eleccion == 1) {
            System.out.println("Introduzca la vida de la carta: ");
            System.out.println("Introduzca el poder de la carta: ");
            nuevaCarta = new Unidad("pendiente", 2, 4, 1, "null");
        }
        return nuevaCarta;
    }

    public static Deck Crea(Unidad unidad, Spell hechizo) {
        Deck baraja = null;
        return baraja;
    }
}
