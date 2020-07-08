package com.uca.capas.dto;


public class ExpedienteDTO {
    private String nombre;
    private String apellido;
    private String materiasAprobadas;
    private String materiasReprobadas;
    private String promedio;

    public ExpedienteDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(String materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getMateriasReprobadas() {
        return materiasReprobadas;
    }

    public void setMateriasReprobadas(String materiasReprobadas) {
        this.materiasReprobadas = materiasReprobadas;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }
}
