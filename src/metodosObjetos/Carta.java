package metodosObjetos;

public class Carta {
    protected String nombre;
    protected int coste;

    public Carta(String nombre, int coste) {
        this.nombre = nombre;
        this.coste = coste;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", coste=" + coste +
                '}';
    }
}
