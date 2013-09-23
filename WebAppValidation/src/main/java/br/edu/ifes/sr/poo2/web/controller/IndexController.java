package br.edu.ifes.sr.poo2.web.controller;

import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifes.sr.poo2.web.model.Usuario;

@Controller
@RequestMapping("/")
@SessionScoped
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadForm(ModelMap model) {

		preProc(model);
		
		return "index";
	}
	
	private void preProc(ModelMap model)
	{
		Usuario usuario = new Usuario();
		
		model.addAttribute("MensagemInicial", "Bem vindo JEDI!");
		
		model.addAttribute("usuario", usuario);
	}

	@RequestMapping(value = "/autenticarUsuario", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute Usuario usuario,
			ModelMap model) {
		
		if (usuario.getLogin().equals("000.000.000-00") && usuario.getSenha().equals("12345"))
		{
			
			usuario.setNome("JEDI");
			model.addAttribute("usuario", usuario);
			
			return "result";	
		}
			return "redirect:/Mensagem/ErrorLogin";
		
	}
	
	@RequestMapping(value="/Mensagem/{mensagem}",method = RequestMethod.GET)
	public String loadForm(ModelMap model,@PathVariable String mensagem) {

		preProc(model);
		if (mensagem.equals("ErrorLogin"))
		{
			model.addAttribute("mensagem", "Usuario Invalido");	
		}
		
		return "index";
	}

}
