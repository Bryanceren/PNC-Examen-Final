package com.uca.capas.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante_materia_resultado_final")
public class Expediente {
    @Id
    private String nombre;
    private String apellido;
    @Column(name = "materias_aprobadas")
    private Integer materiasAprobadas;
    @Column(name = "materias_reprobadas")
    private Integer materiasReprobadas;
    private Double promedio;

    public Expediente() { }

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

    public Integer getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(Integer materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public Integer getMateriasReprobadas() {
        return materiasReprobadas;
    }

    public void setMateriasReprobadas(Integer materiasReprobadas) {
        this.materiasReprobadas = materiasReprobadas;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
}
