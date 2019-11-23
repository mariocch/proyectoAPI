package com.fime.proyectoapi;

public class Estudiante {

    String carrera;
    String nombre;
    String matricula;

    public Estudiante() {

    }

    public Estudiante(String carrera, String nombre, String matricula) {
        this.carrera = carrera;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
