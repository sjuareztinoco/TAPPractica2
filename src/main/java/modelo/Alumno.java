package modelo;

public class Alumno {
    private int numControl;
    private String nombre;
    private Especialidad especialidad;

    public Alumno(){}

    public Alumno(int numControl){
        this.numControl = numControl;
    }

    public Alumno(int numControl, String nombre, Especialidad especialidad) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numControl=" + numControl +
                ", nombre='" + nombre + '\'' +
                ", especialidad=" + especialidad+
                '}';
    }
}