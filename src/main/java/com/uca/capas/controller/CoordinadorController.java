package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.EstudianteMateria;
import com.uca.capas.domain.Materia;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.Materia.MateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Secured("ROLE_USER")
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
        mav.addObject("estudianteMateria", new EstudianteMateria());
        mav.addObject("materias", materias);
		mav.addObject("estudiantes", e);
		mav.setViewName("agregar-materia-cursada");
		return mav;
    }

    @RequestMapping("/guardarNota")
    public ModelAndView guardarNota(@Valid @ModelAttribute EstudianteMateria estudianteMateria, BindingResult result) {
        ModelAndView mav = new ModelAndView();  
        if (result.hasErrors()) {
            List<Materia> materias = null;
            Estudiante e = estudianteService.findOne(estudianteMateria.getEstudiante().getIdEstudiante());
        try {
            materias = materiaService.findAllMaterias();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
            mav.addObject("materias", materias);
            mav.addObject("estudiantes", e);
            mav.setViewName("agregar-materia-cursada");
            return mav;
        } else {
            estudianteService.saveEstu(estudianteMateria);
            mav.addObject("exito", true);
            mav.setViewName("materias-cursadas");
        }
        return mav;

    }

    @RequestMapping("/editar")
	public ModelAndView MateriaEdit(@RequestParam Integer id, @RequestParam Integer id2)
	{
		ModelAndView mav = new ModelAndView();
        EstudianteMateria e = estudianteService.findOnes(id2);
        Estudiante es = estudianteService.findOne(id);
        List<Materia> materias = null;
        try {
            materias = materiaService.findAllMaterias();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        mav.addObject("materias", materias);
        mav.addObject("estudianteMateria", e);
        mav.addObject("estudiantes", es);
		mav.setViewName("agregar-materia-cursada");
		return mav;
	}
    
}