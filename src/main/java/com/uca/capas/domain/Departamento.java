package com.uca.capas.domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(schema = "store", name = "departamento")
public class Departamento {
	enum estado_tabla {
		ACTIVO,
		INACTIVO,
	  }

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_depto;

	@NotNull(message = "El campo nombre de departamento no puede quedar vacio")
	@Column(name = "nombre")
	private String nombre_depto;

	@Column(name = "estado")
	private estado_tabla estado_depto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
	private List<Municipio> municipios_depto;

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

	public estado_tabla getEstado_depto() {
		return estado_depto;
	}

	public void setEstado_depto(estado_tabla estado_depto) {
		this.estado_depto = estado_depto;
	}

	public Departamento() {
	}

	
}
