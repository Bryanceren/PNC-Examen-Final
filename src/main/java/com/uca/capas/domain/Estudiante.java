package com.uca.capas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "public", name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idEstudiante;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteMateria> estumate;

    @NotNull(message = "El campo nombre de materia no puede quedar vacio")
    @Column(name = "nombre")
    private String nombre;

    @NotNull(message = "El campo apellido no puede quedar vacio")
    @Column(name = "apellido")
    private String apellido;

    @NotNull(message = "El campo carnet de minoridad no puede quedar vacio")
    @Column(name = "carnet_minoridad")
    private String carnetMinoridad;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    Date fechaNacimiento;

    @NotNull(message = "El campo direccion no puede quedar vacio")
    @Column(name = "direccion")
    private String direccion;

    @NotNull(message = "El telefono fijo no puede quedar vacio")
    @Column(name = "telefono_fijo")
    private String telefonoFijo;

    @NotNull(message = "El telefono movil no puede quedar vacio")
    @Column(name = "telefono_movil")
    private String telefonoMovil;

    @NotNull(message = "El telefono del padre no puede quedar vacio")
    @Column(name = "telefono_padre")
    private String telefonoPadre;

    @NotNull(message = "El telefono de la madre no puede quedar vacio")
    @Column(name = "telefono_madre")
    private String telefonoMadre;


    public Estudiante() {
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public String getCarnetMinoridad() {
        return carnetMinoridad;
    }

    public void setCarnetMinoridad(String carnetMinoridad) {
        this.carnetMinoridad = carnetMinoridad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoPadre() {
        return telefonoPadre;
    }

    public void setTelefonoPadre(String telefonoPadre) {
        this.telefonoPadre = telefonoPadre;
    }

    public String getTelefonoMadre() {
        return telefonoMadre;
    }

    public void setTelefonoMadre(String telefonoMadre) {
        this.telefonoMadre = telefonoMadre;
    }

    public List<EstudianteMateria> getEstumate() {
        return estumate;
    }

    public void setEstumate(List<EstudianteMateria> estumate) {
        this.estumate = estumate;
    }

    
}
