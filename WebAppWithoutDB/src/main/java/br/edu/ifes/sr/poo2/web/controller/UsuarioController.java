package br.edu.ifes.sr.poo2.web.controller;

import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifes.sr.poo2.web.model.Usuario;

@Controller
@RequestMapping("/usuario")
@SessionScoped
public class UsuarioController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadForm(ModelMap model) {

		preProc(model);
		
		return "result";
	}
	
	private void preProc(ModelMap model)
	{
		Usuario usuario = new Usuario();
		
		usuario.setLogin("Result");
		usuario.setNome("Result");
		usuario.setSenha("Result");
		
		model.addAttribute("MensagemInicial", "Results");
		
		model.addAttribute("usuario", usuario);
	}
	
	
}
