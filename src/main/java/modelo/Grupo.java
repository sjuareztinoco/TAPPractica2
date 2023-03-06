package modelo;

import java.util.Arrays;

public class Grupo {
    private String clave;
    private Materia materia;
    private Catedratico catedratico;
    private int hora;
    private int salon;
    public Alumno[] alumnos;

    public Grupo(){

    }
    public Grupo(String clave){
        this.clave = clave;
    }
    public Grupo(String clave, Materia materia, Catedratico catedratico, int hora, int salon, Alumno[] alumnos) {
        this.clave = clave;
        this.materia = materia;
        this.catedratico = catedratico;
        this.hora = hora;
        this.salon = salon;
        this.alumnos = alumnos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Catedratico getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(Catedratico catedratico) {
        this.catedratico = catedratico;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getSalon() {
        return salon;
    }

    public void setSalon(int salon) {
        this.salon = salon;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public String toString(){
        return "Grupo{" +
                "clave=" + clave +
                ", materia='" + materia +
                ", catedrático='"+catedratico +
                ", hora='" +hora+
                ", salon='" +salon+
                ", alumnos='"+ Arrays.toString(alumnos) + '\'' +
                '}';
    }
}
