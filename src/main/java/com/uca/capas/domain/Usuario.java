package com.uca.capas.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(schema = "public", name = "usuario")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "Campo Obligatorio")
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty(message = "Campo Obligatorio")
    @Column(name = "apellido")
    private String apellido;

    @NotEmpty(message = "Campo Obligatorio")
    @Column(name = "username", unique = true)
    private String username;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "Campo Obligatorio")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @NotEmpty(message = "Campo Obligatorio")
    @Column(name = "direccion")
    private String direccion;

    @NotEmpty(message = "Campo Obligatorio")
    @Column(name = "password")
    private String password;

    @Transient
    @NotEmpty(message = "Campo Obligatorio")
    private String confirmation_password;

    @NotEmpty(message = "Campo Obligatorio")
    @Column(name = "role")
    private String role;

    @Column(name = "municipio_fk")
    private Integer municipio;

    @Column(name = "estado")
    private Boolean estado = false;

    public Usuario() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getConfirmation_password() {
        return confirmation_password;
    }

    public void setConfirmation_password(String confirmation_password) {
        this.confirmation_password = confirmation_password;
    }

    public Integer getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
