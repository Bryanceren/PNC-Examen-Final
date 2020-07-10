package com.uca.capas.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Secured("ROLE_USER")
@Controller
public class ExpedienteController {

    @GetMapping("/expediente")
    public ModelAndView expedientForm()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("expediente-alumno/expediente");
        return mav;
    }
    @GetMapping("/nuevo-expediente")
    public ModelAndView nuevoExpediente()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("expediente-alumno/nuevo-expediente");
        return mav;
    }
    @GetMapping("/editar-expediente")
    public ModelAndView modificarExpediente(@RequestParam("id") String id)
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("idEstudiante",id);
        mav.setViewName("expediente-alumno/editar-expediente");
        return mav;
    }
}
