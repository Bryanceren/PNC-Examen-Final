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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(schema = "public", name = "municipio")
public class Municipio {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmun;

	@NotNull(message = "El campo nombre de municipio no puede quedar vacio")
	@Column(name = "nombre")
	private String nombremun;

	@Column(name = "estado")
	private Boolean estadomun;
	
	@JsonIgnore 
	@JoinColumn(name = "departamento_fk")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Departamento deptomun;

	
	public Municipio() {
	}

	public Integer getIdmun() {
		return idmun;
	}

	public void setIdmun(Integer idmun) {
		this.idmun = idmun;
	}

	public String getNombremun() {
		return nombremun;
	}

	public void setNombremun(String nombremun) {
		this.nombremun = nombremun;
	}

	public Boolean getEstadomun() {
		return estadomun;
	}

	public void setEstadomun(Boolean estadomun) {
		this.estadomun = estadomun;
	}

	public Departamento getDeptomun() {
		return deptomun;
	}

	public void setDeptomun(Departamento deptomun) {
		this.deptomun = deptomun;
	}

	

	
}
