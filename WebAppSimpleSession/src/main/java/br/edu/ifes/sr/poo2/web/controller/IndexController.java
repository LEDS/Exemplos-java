package br.edu.ifes.sr.poo2.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifes.sr.poo2.web.model.Usuario;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private Usuario usuarioSessao;
	
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
	public String addUsuario(@ModelAttribute Usuario usuario, ModelMap modelMap) {
		
		if (usuario.getLogin().equals("LEDS") && usuario.getSenha().equals("1234"))
		{
			usuarioSessao.setLogin(usuario.getLogin());
			usuarioSessao.setSenha(usuario.getSenha());
			usuarioSessao.setNome("JEDI");
			
			modelMap.addAttribute("usuario", usuarioSessao); 
			
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
