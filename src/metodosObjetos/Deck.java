package metodosObjetos;

import java.util.ArrayList;

public class Deck {
    private String deckName;
    private ArrayList<Carta> mazo = new ArrayList<Carta>();

    public Deck(String deckName) {
        this.deckName = deckName;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deckName='" + deckName + '\'' +
                ", mazo=" + mazo +
                '}';
    }


    public void addCard(Carta unidad) {
        mazo.add(unidad);
    }
}

