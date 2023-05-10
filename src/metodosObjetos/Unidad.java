package metodosObjetos;

import metodosCRUD.Basicos;

import java.util.ArrayList;

public class Unidad extends Carta {
    private int vida;
    private int poder;
    private String habilidad;

    public Unidad(String nombre, int coste, int vida, int poder, String habilidad) {
        super(nombre, coste);
        this.vida = vida;
        this.poder = poder;
        this.habilidad = habilidad;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "nombre='" + nombre + '\'' +
                ", coste=" + coste +
                "vida=" + vida +
                ", poder=" + poder +
                ", habilidad='" + habilidad +
                '}';
    }
}
