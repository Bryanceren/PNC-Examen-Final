package com.uca.capas.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(schema = "public", name = "centro_escolar")
public class CentroEscolar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idcen;

	@NotNull(message = "El campo nombre de centro no puede quedar vacio")
	@Column(name = "nombre")
	private String nombrecen;
	
	@NotNull(message = "El campo descripcion de centro no puede quedar vacio")
	@Column(name = "descripcion")
	private String descripcioncen;

	@Column(name = "estado")
	private Boolean estadocen;
	
	@JoinColumn(name = "municipio_fk")
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

	
	

	
	


}
