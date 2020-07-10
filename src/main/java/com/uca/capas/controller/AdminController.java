package com.uca.capas.controller;


import java.util.List;

import javax.validation.Valid;

import com.uca.capas.dao.CentroEscolarDAO;
import com.uca.capas.domain.*;
import com.uca.capas.service.CentroEscolarService;

import com.uca.capas.service.Departamento.DepartamentoService;
import com.uca.capas.service.Materia.MateriaService;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.Usuario.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Secured("ROLE_ADMIN")
@Controller
public class AdminController
{
    @Autowired
	private CentroEscolarService centroEscolarService;
	@Autowired
    private UsuarioService usuarioService;
	@Autowired
	private MateriaService materiaService;
	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private CentroEscolarDAO centroDao;


	//Centro Escolar
    @RequestMapping("/centros-escolares")
    public ModelAndView CETable(@RequestParam(defaultValue = "false") Boolean exito)
	{
        ModelAndView mav = new ModelAndView();
		if(exito){
			mav.addObject("exito", exito);
		}
        mav.setViewName("centros-escolares");
        return mav;
    }

	@RequestMapping("/nuevo-centro-escolar")
	public ModelAndView CEForm()
	{
		ModelAndView mav = new ModelAndView();

		List<Departamento> departamentos = null;

		try {
			departamentos = departamentoService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		mav.addObject("departamentos",departamentos);
		mav.addObject("centroEscolar", new CentroEscolar());
        mav.setViewName("nuevo-centro-escolar");
		return mav;
	}

	@RequestMapping(value="/editar-centro", method = RequestMethod.GET)
	public ModelAndView CentroEditForm(@RequestParam Integer id)
	{
		ModelAndView mav = new ModelAndView();
		CentroEscolar centro = centroEscolarService.findOne(id);
		Integer deptoId = municipioService.getDeptoByMunicipio(centro.getMunicipiocen().getIdmun());

		List<Departamento> departamentos = null;

		try {
			departamentos = departamentoService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		mav.addObject("departamentos",departamentos);

		mav.addObject("deptoId", deptoId);
		mav.addObject("centroEscolar", centro);
		mav.setViewName("nuevo-centro-escolar");
		return mav;
	}
	

	@RequestMapping(value="/guardar-centro-escolar", method = RequestMethod.POST)
	public ModelAndView saveCentroEscolar(@Valid @ModelAttribute("centroEscolar") CentroEscolar c, BindingResult r)
	{
		ModelAndView mav = new ModelAndView();

		if(r.hasErrors())
		{
			List<Departamento> departamentos = null;
			Integer deptoId = null;

			try {
				departamentos = departamentoService.findAll();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			if(c.getIdcen() != null){
				deptoId = municipioService.getDeptoByMunicipio(c.getMunicipiocen().getIdmun());
			}

			mav.addObject("deptoId",deptoId);
			mav.addObject("departamentos",departamentos);
			mav.setViewName("nuevo-centro-escolar");
			return mav;
		}

		if(c.getEstadocen()==null)
		{
			c.setEstadocen(false);
		}

		Integer key = null;

		if(c.getIdcen() == null)
		{
			key = centroEscolarService.insertCentroEscolarAutoId(c);
		}
		else
		{
			centroEscolarService.updateCentroEscolar(c);
		}

		mav.addObject("exito", true);
		mav.setViewName("redirect:/centros-escolares");

		return mav;
	}


	//Usuarios
	@RequestMapping("/usuarios")
    public ModelAndView UTable()
	{
        ModelAndView mav = new ModelAndView();
        mav.setViewName("usuarios");
        return mav;
	}
	
	@RequestMapping(value="/editar-usuario", method = RequestMethod.GET)
	public ModelAndView userEditForm(@RequestParam Integer id)
	{
		ModelAndView mav = new ModelAndView();
		Usuario usuario = usuarioService.findOne(id);
		mav.addObject("Usuario", usuario);
		mav.setViewName("usuarios-edit");
		return mav;
	}

	@RequestMapping(value="/guardar-usuario", method = RequestMethod.POST)
	public ModelAndView saveUser(@Valid @ModelAttribute("Usuario") Usuario u, BindingResult r)
	{
		ModelAndView mav = new ModelAndView();
		Integer key = null;
		mav.addObject("resultado", 1);
		usuarioService.updateUser(u);
		mav.addObject("resultado", key);
		mav.setViewName("redirect:/usuarios");

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
