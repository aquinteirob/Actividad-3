import metodosObjetos.Carta;
import metodosObjetos.Deck;
import metodosObjetos.Spell;
import metodosObjetos.Unidad;

public class Main {
    public static void main(String[] args) {
        Carta unidad1 = new Unidad("unidad 1", 3, 2, 1, "null");
        Carta hechizo1 = new Spell("hechizo 1", 2, "efecto hechizo 1");
        Deck mazo1 = new Deck("mazo 1");
        mazo1.addCard(unidad1);
        mazo1.addCard(hechizo1);
        Deck mazo2 = new Deck("mazo 2");
        for (int i = 0; i < 3; i++) {
            mazo2.addCard(unidad1);
            mazo2.addCard(hechizo1);
            System.out.println(mazo2.toString());
            System.out.println((i + 1) + " añadido" + "\n");
        }
        System.out.println(mazo2.toString());
    }
}