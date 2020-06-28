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
@Table(schema = "store", name = "centro_escolar")
public class CentroEscolar {
	enum estado_tabla {
		ACTIVO,
		INACTIVO,
	  }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id_centro;

	@NotNull(message = "El campo nombre de centro no puede quedar vacio")
	@Column(name = "nombre")
	private String nombre_centro;
	
	@NotNull(message = "El campo descripcion de centro no puede quedar vacio")
	@Column(name = "descripcion")
	private String descripcion_centro;

	@Column(name = "municipio")
	private Municipio estado_centro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "municipio_fk")
	private Municipio municipio_centro;

	
	
	
	
}
