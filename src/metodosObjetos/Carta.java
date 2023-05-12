package metodosObjetos;

public class Carta {
    protected String nombre;
    protected int coste;

    /**
     * Constructor de la clase carta
     * @param nombre es el nombre que tendrá el objeto
     * @param coste  es el precio de utilizacion que tiene el objeto
     */
    public Carta(String nombre, int coste) {
        this.nombre = nombre;
        this.coste = coste;
    }

    /**
     * Obtiene el atributo nombre
     * @return cadena de caracteres que representa el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del objeto ya creado
     * @param nombre nombre anterior del objeto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene al atributo coste
     * @return numero entero que representa el coste de utilización
     */
    public int getCoste() {
        return coste;
    }

    /**
     * Modifica el coste de un objeto ya existente
     * @param coste numero entero que representa el nuevo coste
     */
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
