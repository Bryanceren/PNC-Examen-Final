package com.uca.capas.controller;


import java.util.List;

import javax.validation.Valid;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Municipio;
import com.uca.capas.service.CentroEscolarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController
{
    @Autowired
    private CentroEscolarService centroEscolarService;

    //Centro Escolar

    @RequestMapping("/centros-escolares")
    public ModelAndView CETable()
	{
        ModelAndView mav = new ModelAndView();
        mav.setViewName("centros-escolares");
        return mav;
    }

	@RequestMapping("/nuevo-centro-escolar")
	public ModelAndView CEForm()
	{
		ModelAndView mav = new ModelAndView();
		List<CentroEscolar> municipios = null;
		try {
			municipios = centroEscolarService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("municipios",municipios);
		mav.addObject("CentroEscolar", new CentroEscolar());
        mav.setViewName("nuevo-centro-escolar");
		return mav;
	}
	
	@RequestMapping(value="/guardar-centro-escolar", method = RequestMethod.POST)
	public ModelAndView saveCentroEscolar(@Valid @ModelAttribute("CentroEscolar") CentroEscolar c, BindingResult r)
	{
		ModelAndView mav = new ModelAndView();
		List<CentroEscolar> municipios2 = null;
		try {
			municipios2 = centroEscolarService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("municipios",municipios2);
		mav.addObject("CentroEscolar", new CentroEscolar());
		if(r.hasErrors()) {
			mav.addObject("resultado", 0);
			mav.setViewName("nuevo-centro-escolar");
		}
		else {
			Integer key = null;
			if(c.getIdcen() == null) {
				mav.addObject("resultado", 1);
				key = centroEscolarService.insertCentroEscolarAutoId(c);
			}
			else {
				mav.addObject("resultado", 1);
				centroEscolarService.updateCentroEscolar(c);
			}
			mav.addObject("resultado", key);
			mav.setViewName("centros-escolares");
		}
		
		return mav;
	}


	// Materias

	@RequestMapping("/materias")
	public ModelAndView MateriaTable()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/Materias/materias");
		return mav;
	}

	@RequestMapping("/nueva-materia")
	public ModelAndView MateriaForm()
	{
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/Materias/nueva-materia");
		return mav;
	}
}
