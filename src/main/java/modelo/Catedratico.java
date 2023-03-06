package modelo;

public class Catedratico {
    private String RFC;
    private String nombre;

    public Catedratico(){}

    public Catedratico(String RFC) {
        this.RFC = RFC;
    }

    public Catedratico(String RFC, String nombre) {
        this.RFC = RFC;
        this.nombre = nombre;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Catedratico{" +
                "RFC='" + RFC + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
