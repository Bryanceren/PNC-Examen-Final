package com.uca.capas.controller;

import java.util.List;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.service.CentroEscolarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CentroEscolarRest {
	
	@Autowired
	private CentroEscolarService centroEscolarService;
	
	@RequestMapping(path="/centros", method=RequestMethod.GET)
	public List<CentroEscolar> findAll(){
		return centroEscolarService.findAll();
	}
    @RequestMapping(value = "/centros/{id_centro}", method = RequestMethod.GET)
	public CentroEscolar find(@PathVariable("id") Integer id){
		return centroEscolarService.findOne(id);
	}

}