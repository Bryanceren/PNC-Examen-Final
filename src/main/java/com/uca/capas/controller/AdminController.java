package com.uca.capas.controller;


import java.util.List;

import javax.validation.Valid;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.EstudianteMateria;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Municipio;
import com.uca.capas.service.CentroEscolarService;

import com.uca.capas.service.Materia.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController
{
    @Autowired
    private CentroEscolarService centroEscolarService;

	@Autowired
	private MateriaService materiaService;

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
	public ModelAndView MateriaTable(@RequestParam(defaultValue = "false") Boolean exito)
	{
		ModelAndView mav = new ModelAndView();
		if(exito){
			mav.addObject("exito", exito);
		}
		mav.setViewName("/Materias/materias");
		return mav;
	}

	@RequestMapping("/nueva-materia")
	public ModelAndView MateriaForm()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("materia", new Materia());
		mav.setViewName("/Materias/nueva-materia");
		return mav;
	}

	@RequestMapping(value="/editar-materia", method = RequestMethod.GET)
	public ModelAndView MateriaEditForm(@RequestParam Integer id)
	{
		ModelAndView mav = new ModelAndView();
		Materia materia = materiaService.findOne(id);
		mav.addObject("materia", materia);
		mav.setViewName("/Materias/nueva-materia");
		return mav;
	}

	@RequestMapping("/guardar-materia")
	public ModelAndView saveMateria(@Valid @ModelAttribute Materia materia, BindingResult result)
	{
		ModelAndView mav = new ModelAndView();

		System.out.println(result);

		if(result.hasErrors())
		{
			mav.setViewName("/Materias/nueva-materia");
			return mav;
		}

		materiaService.saveMateria(materia);
		mav.addObject("exito", true);
		mav.setViewName("redirect:/materias");

		return mav;

	}

}
