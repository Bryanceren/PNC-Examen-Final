package com.uca.capas.controller;

import java.util.List;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.dto.EstudianteDTO;
import com.uca.capas.service.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoordinadorController {

    @Autowired
    EstudianteService estudianteService;

    @RequestMapping("/materias-cursadas")
    public ModelAndView lolazo() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("estudiante", new Estudiante());
        mav.setViewName("materias-cursadas");

        return mav;
    }

    @RequestMapping("/buscarEstudiante")
	public ModelAndView buscarEst(@RequestParam Integer codigo) {
		ModelAndView mav = new ModelAndView();
		Estudiante e = estudianteService.findOne(codigo);
		mav.addObject("estudiante", e);
		mav.setViewName("materias-cursadas");
		return mav;
    }

    @RequestMapping("/buscarEstudianteModal")
	public ModelAndView buscarEstModal(@RequestParam Integer codigo) {
		ModelAndView mav = new ModelAndView();
		Estudiante e = estudianteService.findOne(codigo);
		mav.addObject("estudiante", e);
		mav.setViewName("agregar-materia-cursada");
		return mav;
    }
    
    //test criteria buscar por nombre de materia
    @RequestMapping("/getEstudiantesMaterias")
    public @ResponseBody List<EstudianteDTO> getEstuMateria(@RequestParam String nombre) {
        List<EstudianteDTO> estudiantes = estudianteService.getEstudianteMateria(nombre);

        return estudiantes;
    }
    
}