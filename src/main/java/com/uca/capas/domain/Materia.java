package com.uca.capas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(schema = "public", name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idMateria;

    @OneToMany(mappedBy = "materia")
    private List<EstudianteMateria> estumate;

    @NotNull(message = "El campo nombre de materia no puede quedar vacio")
    @Column(name = "nombre")
    private String nombre;

    @NotNull(message = "El campo descripcion de materia no puede quedar vacio")
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull(message = "El campo estado no puede quedar vacio")
    @Column(name = "estado")
    private Boolean estado;

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