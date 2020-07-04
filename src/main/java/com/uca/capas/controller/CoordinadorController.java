package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.EstudianteMateria;
import com.uca.capas.domain.Materia;
import com.uca.capas.dto.EstudianteDTO;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoordinadorController {

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    MateriaService materiaService;

    @RequestMapping("/materias-cursadas")
    public ModelAndView indexMaterias() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("materias-cursadas");

        return mav;
    }

    @RequestMapping("/buscarEstudianteModal")
	public ModelAndView buscarEstModal(@RequestParam Integer codigo) {
		ModelAndView mav = new ModelAndView();
        Estudiante e = estudianteService.findOne(codigo);
        List<Materia> materias = null;
        try {
            materias = materiaService.findAllMaterias();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        mav.addObject("estumat", new EstudianteMateria());
        mav.addObject("materias", materias);
		mav.addObject("estudiantes", e);
		mav.setViewName("agregar-materia-cursada");
		return mav;
    }

    //buscar estudiante materias-cursadas
    @RequestMapping("/buscarEstudiante")
    public ModelAndView buscarEstu(@RequestParam Integer codigo) {
        ModelAndView mav = new ModelAndView();
        List<EstudianteDTO> estudiantes = estudianteService.getEstudianteMateriaCodigo(codigo);
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("materias-cursadas");

        return mav;
    }

    @RequestMapping("/guardarNota")
    public ModelAndView guardarNota(@Valid @ModelAttribute EstudianteMateria estumat) {
        ModelAndView mav = new ModelAndView();  
        materiaService.save(estumat);
        mav.setViewName("materias-cursadas");

        return mav;

    }
    
}