package com.uca.capas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(schema = "public", name = "materia")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idMateria;

    @NotEmpty(message = "Campo obligatorio")
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty(message = "Campo obligatorio")
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull(message = "Campo obligatorio")
    @Column(name = "estado")
    private Boolean estado;

    @OneToMany(mappedBy = "materia")
    @JsonBackReference
    private List<EstudianteMateria> estumate;

    public Materia() { }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<EstudianteMateria> getEstumate() {
        return estumate;
    }

    public void setEstumate(List<EstudianteMateria> estumate) {
        this.estumate = estumate;
    }

}