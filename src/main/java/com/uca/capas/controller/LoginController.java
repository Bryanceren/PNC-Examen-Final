package com.uca.capas.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error,
                        @RequestParam(value="logout", required = false) String logout,
                        Model model, Principal principal)
    {
        if(principal != null)
        {
            return "redirect:/";
        }

        if(error != null)
        {
            model.addAttribute("error", "Nombre de usuario o contraseña incorrecta");
        }

        if(logout != null)
        {
            model.addAttribute("success", "Haz cerrado sesión con exito");
        }

        return "login";
    }

    @RequestMapping("/register")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }
}
