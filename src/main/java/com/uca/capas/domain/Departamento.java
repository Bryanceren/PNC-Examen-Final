package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(schema = "public", name = "departamento")
public class Departamento {


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_depto;

	@NotNull(message = "El campo nombre de departamento no puede quedar vacio")
	@Column(name = "nombre")
	private String nombre_depto;

	@Column(name = "estado")
	private Boolean estado_depto;
	

	public Integer getId_depto() {
		return id_depto;
	}

	public void setId_depto(Integer id_depto) {
		this.id_depto = id_depto;
	}

	public String getNombre_depto() {
		return nombre_depto;
	}

	public void setNombre_depto(String nombre_depto) {
		this.nombre_depto = nombre_depto;
	}

	public Boolean getEstado_depto() {
		return estado_depto;
	}

	public void setEstado_depto(Boolean estado_depto) {
		this.estado_depto = estado_depto;
	}

	public Departamento() {
	}

	
}
