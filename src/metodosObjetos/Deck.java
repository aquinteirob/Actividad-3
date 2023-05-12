package metodosObjetos;

import metodosCRUD.Basicos;
import metodosCRUD.GestionesCRUD;

import java.util.ArrayList;

public class Deck {
    private String deckName;
    private ArrayList<Carta> mazo = new ArrayList<Carta>();

    /**
     * Constructor de la clase Deck, requerido para poder almacenar de manera mixma Objetos de tipo Unidad y tipo Spell
     * @param deckName nombre por el que se identifica la colección de cartas
     */
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

    /**
     * Añade objetos de tipo Unidad o Spell a la lista mazo, aplicando polimorfismo para cumplir con el requisito de la lista donde se almacenan y el parámetro
     * @param unidad Objeto de tipo Unidad o Hechizo al que se le aplica polimorfismo para poder pasar cualquiera de los dos y almacenarlos en una lista conjunta
     */
    public void addCard(Carta unidad) {
        mazo.add(unidad);
    }

}

