package com.uca.capas.controller;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class LoginController
{
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
        mav.addObject("usuario", new Usuario());
        mav.setViewName("register");
        return mav;
    }

    @RequestMapping("/crear-usuario")
    public ModelAndView saveMateria(@Valid @ModelAttribute Usuario usuario, BindingResult result)
    {
        ModelAndView mav = new ModelAndView();

        System.out.println(result);

        if(result.hasErrors())
        {
            mav.setViewName("register");
            return mav;
        }

        if(usuario.getPassword() != usuario.getConfirmation_password())
        {
            mav.addObject("password_error", "Las contraseña no coincide, por favor vuelva a colocar su contraseña");
            mav.setViewName("register");
            return mav;
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

//        usuarioService.save(usuario);
        mav.addObject("success", true);
        mav.setViewName("register");

        return mav;

    }
}
