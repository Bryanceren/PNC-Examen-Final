package com.uca.capas.domain;

<<<<<<< HEAD
=======
import org.springframework.format.annotation.DateTimeFormat;
>>>>>>> rama-dona
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
<<<<<<< HEAD

import org.springframework.format.annotation.DateTimeFormat;

=======
>>>>>>> rama-dona
import javax.validation.constraints.Size;
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
    @JsonBackReference
    private List<EstudianteMateria> estumate;

    @NotBlank(message = "nombres no puede quedar vacio")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "apellidos no puede quedar vacio")
    @Column(name = "apellido")
    private String apellido;

    @Size(min = 9,max = 9,message = "carnet-minoridad debe ser de 9 caracteres")
    @NotBlank(message = "carnet-minoridad no puede quedar vacio")
    @Column(name = "carnet_minoridad")
    private String carnetMinoridad;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "fecha-nacimiento no puede quedar vacio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_nacimiento")
    Date fechaNacimiento;

    @NotBlank(message = "direccion no puede quedar vacio")
    @Column(name = "direccion")
    private String direccion;

    @Size(min = 9,max = 9, message = "telefono-fijo debe ser de 9 caracteres")
    @NotBlank(message = "telefono-fijo no puede quedar vacio")
    @Column(name = "telefono_fijo")
    private String telefonoFijo;

    @Size(min = 9,max = 9,message = "telefono-movil debe ser de 9 caracteres")
    @NotBlank(message = "telefono-movil no puede quedar vacio")
    @Column(name = "telefono_movil")
    private String telefonoMovil;

    @NotBlank(message = "nombre-padre no puede quedar vacio")
    @Column(name = "nombre_padre")
    private String nombrePadre;

    @NotBlank(message = "nombre-madre no puede quedar vacio")
    @Column(name = "nombre_madre")
    private String nombreMadre;

    @NotNull(message = "centro no puede quedar vacio")
    @Column(name = "centro_fk")
    private Integer centroFk;


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

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public List<EstudianteMateria> getEstumate() {
        return estumate;
    }

    public void setEstumate(List<EstudianteMateria> estumate) {
        this.estumate = estumate;
    }

    public Integer getCentroFk() {
        return centroFk;
    }

    public void setCentroFk(Integer centroFk) {
        this.centroFk = centroFk;
    }
}
