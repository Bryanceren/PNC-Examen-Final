package com.uca.capas.domain;


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


@Entity
@Table(schema = "store", name = "municipio")
public class Municipio {
	enum estado_tabla {
		ACTIVO,
		INACTIVO,
	  }

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_mun;

	@NotNull(message = "El campo nombre de municipio no puede quedar vacio")
	@Column(name = "nombre")
	private String nombre_mun;

	@Column(name = "estado")
	private estado_tabla estado_mun;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamento_fk")
	private Departamento departamento_mun;

	public Integer getId_mun() {
		return id_mun;
	}

	public void setId_mun(Integer id_mun) {
		this.id_mun = id_mun;
	}

	public String getNombre_mun() {
		return nombre_mun;
	}

	public void setNombre_mun(String nombre_mun) {
		this.nombre_mun = nombre_mun;
	}

	public estado_tabla getEstado_mun() {
		return estado_mun;
	}

	public void setEstado_mun(estado_tabla estado_mun) {
		this.estado_mun = estado_mun;
	}

	public Departamento getDepartamento_mun() {
		return departamento_mun;
	}

	public void setDepartamento_mun(Departamento departamento_mun) {
		this.departamento_mun = departamento_mun;
	}

	public Municipio() {
	}

	

	
}
