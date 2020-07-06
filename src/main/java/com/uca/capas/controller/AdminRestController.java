package com.uca.capas.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminRestController {
	@Autowired
	private CentroEscolarService centroEscolarService;

	@Autowired
	private MateriaService materiaService;



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