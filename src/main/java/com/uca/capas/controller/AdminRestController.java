package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Materia;
import com.uca.capas.dto.TableDTO;

import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.Materia.MateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Secured("ROLE_ADMIN")
@RestController
public class AdminRestController {
	@Autowired
	private CentroEscolarService centroEscolarService;

	@Autowired
	private MateriaService materiaService;

	// Este metodo es por seguridad, mas pensado para las peticiones post que devuelven datos
	// Verifica si tengo o no tengo permiso de acceder a esos datos
	private boolean hasRole(String role)
	{
		SecurityContext context = SecurityContextHolder.getContext();
		if(context == null) {
			return false;
		}

		Authentication auth = context.getAuthentication();
		if(auth == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		return authorities.contains(new SimpleGrantedAuthority(role));

	}

	// Materias
	@RequestMapping(path="/get-materias", method=RequestMethod.GET)
	public TableDTO obtenerMaterias(@RequestParam Integer draw,
								  	@RequestParam Integer start, @RequestParam Integer length,
								  	@RequestParam(value="search[value]", required = false) String search)
	{
		Page<Materia> materias = materiaService.findAll(PageRequest.of(start/length, length, Sort.by(Sort.Direction.ASC, "idMateria")));

		List<String[]> data = new ArrayList<>();

		for(Materia u : materias)
		{
			data.add(new String[] {
				u.getIdMateria().toString(),
				u.getIdMateria().toString(),
				u.getNombre(),
				u.getDescripcion(),
				u.getEstado() == true ? "Activo" : "Inactivo"
			});
		}

		TableDTO dataTable = new TableDTO();
		dataTable.setData(data);
		dataTable.setDraw(draw);
		dataTable.setRecordsFiltered((int) materiaService.count());
		dataTable.setRecordsTotal((int) materiaService.count());

		return dataTable;
	}

	//Centros escolares
	@RequestMapping(path="/get-centros", method=RequestMethod.GET)
	public TableDTO obtenerCentros(@RequestParam Integer draw,
								  	@RequestParam Integer start, @RequestParam Integer length,
								  	@RequestParam(value="search[value]", required = false) String search)
	{
		Page<CentroEscolar> centros = centroEscolarService.findAll(PageRequest.of(start/length, length, Sort.by(Sort.Direction.ASC, "idcen")));

		List<String[]> data = new ArrayList<>();

		for(CentroEscolar c : centros)
		{
			data.add(new String[] {
				c.getIdcen().toString(),
				c.getIdcen().toString(),
				c.getNombrecen(),
				c.getDescripcioncen(),
				c.getEstadocen() == true ? "Activo" : "Inactivo",
				c.getMunicipiocen().getNombremun()
			});
		}

		TableDTO dataTable = new TableDTO();
		dataTable.setData(data);
		dataTable.setDraw(draw);
		dataTable.setRecordsFiltered((int) materiaService.count());
		dataTable.setRecordsTotal((int) materiaService.count());

		return dataTable;
	}
}