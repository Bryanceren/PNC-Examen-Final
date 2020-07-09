package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(schema = "public", name = "estudiante_materia")
public class EstudianteMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_fk")
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_fk")
    private Materia materia;

    @NotNull(message = "El campo año no puede quedar vacio")
    @Min(value = 2005, message = "El año debe ser mayor o igual a 2005")
    @Column(name = "year")
    private Integer anio;

    @NotEmpty(message = "El campo ciclo no puede quedar vacio")
    @Column(name = "ciclo")
    @Range(min = 01, max = 03, message = "El ciclo puede ser 01, 02 o 03")
    private String ciclo;

    @NotNull(message = "El campo nota no puede quedar vacio")
    @Column(name = "nota")
    @Range(min = 0, max = 10, message = "La nota debe de estar entre 0.0 y 10.0")
    private Float nota;

    public EstudianteMateria(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public String getNotaDelegate() {
        if (this.nota < 6) {
            return "Reprobado";
        } else {
            return "Aprobado";
        }
    }
    
}