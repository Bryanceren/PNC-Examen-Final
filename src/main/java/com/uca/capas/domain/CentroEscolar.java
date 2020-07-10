package com.uca.capas.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "public", name = "centro_escolar")
public class CentroEscolar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idcen;

	@NotEmpty(message = "El campo nombre de centro no puede quedar vacio")
	@Column(name = "nombre")
	private String nombrecen;
	
	@NotEmpty(message = "El campo descripcion de centro no puede quedar vacio")
	@Column(name = "descripcion")
	private String descripcioncen;

	@Column(name = "estado")
	private Boolean estadocen;

	@Transient
	private Departamento departamento;
	
	@JsonIgnore 
	@JoinColumn(name = "municipio_fk")
	@NotNull(message = "Campo Obligatorio")
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Municipio municipiocen;
	
	public CentroEscolar() {
	}

	public Integer getIdcen() {
		return idcen;
	}

	public void setIdcen(Integer idcen) {
		this.idcen = idcen;
	}

	public String getNombrecen() {
		return nombrecen;
	}

	public void setNombrecen(String nombrecen) {
		this.nombrecen = nombrecen;
	}

	public String getDescripcioncen() {
		return descripcioncen;
	}

	public void setDescripcioncen(String descripcioncen) {
		this.descripcioncen = descripcioncen;
	}

	public Boolean getEstadocen() {
		return estadocen;
	}

	public void setEstadocen(Boolean estadocen) {
		this.estadocen = estadocen;
	}

	public Municipio getMunicipiocen() {
		return municipiocen;
	}

	public void setMunicipiocen(Municipio municipiocen) {
		this.municipiocen = municipiocen;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
