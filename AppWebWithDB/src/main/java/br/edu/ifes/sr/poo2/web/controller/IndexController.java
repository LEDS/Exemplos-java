package br.edu.ifes.sr.poo2.web.controller;

import java.util.List;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.service.UsuarioService;

@Controller
@RequestMapping("/")
@SessionScoped
public class IndexController {

	@Autowired
	UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadForm(ModelMap model) {

		preProc(model);
		
		return "index";
	}
	
	private void preProc(ModelMap model)
	{
	
		Usuario usuario = new Usuario();
		
		model.addAttribute("MensagemInicial", "Cadastro de usuario");
		
		model.addAttribute("usuario", usuario);
	}

	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute Usuario usuario,
			ModelMap model) throws Exception {
		
		service.cadastrar(usuario.getEmail(), usuario.getSenha());
		
		List<Usuario> usuarios = service.getAll();
		
		model.addAttribute("usuarios", usuarios);
		
		return "result";
	}

}
