package metodosCRUD;

import metodosObjetos.Carta;
import metodosObjetos.Deck;
import metodosObjetos.Spell;
import metodosObjetos.Unidad;

public class Crear {
    public static Carta Crea(Carta carta) {
        int eleccion;
        String nombre;
        int vida;
        int poder;
        int coste;
        String habilidad;
        String efecto;
        Carta nuevaCarta = null;
        do {
            eleccion = basicos.numericos("¿ Desea crear una unidad (1) o un hechizo (2) ?");
        } while (eleccion != 1 || eleccion != 2);
        if (eleccion == 1) {
            nombre = basicos.caracteres("Introduzca el nombre de la nueva unidad: ");
            coste = basicos.numericos("Introduzca el coste de la unidad: ");
            vida = basicos.numericos("Introduzca la vida de la unidad: ");
            poder = basicos.numericos("Introduzca el poder de la unidad: ");
            habilidad = basicos.caracteres("Introduzca la habilidad de la unidad, si no tiene ninguna escriba null ");
            nuevaCarta = new Unidad(nombre, coste, vida, poder, habilidad);
        } else {
            nombre = basicos.caracteres("Introduzca el nombre del nuevo hechizo: ");
            coste = basicos.numericos("Introduzca el coste del nuevo hechizo: ");
            efecto = basicos.caracteres("Introduzca el efecto: ");
            nuevaCarta = new Spell(nombre, coste, efecto);
        }
        return nuevaCarta;
    }

    public static Deck Crea(Unidad unidad, Spell hechizo) {
        Deck baraja = null;
        return baraja;
    }
}
