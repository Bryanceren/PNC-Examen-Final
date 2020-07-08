package com.uca.capas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "usuario")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "El campo nombre de materia no puede quedar vacio")
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty(message = "El campo apellido no puede quedar vacio")
    @Column(name = "username", unique = true)
    private String username;

    @NotEmpty(message = "El campo apellido no puede quedar vacio")
    @Column(name = "password")
    private String password;

    @NotEmpty(message = "El campo apellido no puede quedar vacio")
    @Column(name = "role")
    private String role;

    @NotNull(message = "Campo obligatorio")
    @Column(name = "estado")
    private Boolean estado;

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
