package com.uca.capas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @RequestMapping("/centros-escolares")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("centros-escolares");
        return mav;
    }


}
