package com.uca.capas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EstudianteDTO {
    
    private String nombres, apellidos, ciclo;

    @JsonIgnore
    private String codigo;

    private Integer anio;

    private Float nota;

    private String materiaNom;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public String getMateriaNom() {
        return materiaNom;
    }

    public void setMateriaNom(String materiaNom) {
        this.materiaNom = materiaNom;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}