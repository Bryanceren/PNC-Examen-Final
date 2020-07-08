package com.uca.capas.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
