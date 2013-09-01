package br.edu.ifes.sr.poo2.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifes.sr.poo2.web.model.Usuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private Usuario usuarioSessao;
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(ModelMap model) {
		
		model.addAttribute("usuario", usuarioSessao); 
		return "usuario";
	}
	
	

	
	

}
