package modelo;

public class Materia {
    private int id;
    private String nombre;

    public Materia(){

    }
    public Materia(int id){
        this.id = id;
    }
    public Materia(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    public String toString(){
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}