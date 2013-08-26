package br.edu.ifes.sr.poo2.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifes.sr.poo2.web.model.Local;
import br.edu.ifes.sr.poo2.web.model.Usuario;
import br.edu.ifes.sr.poo2.web.model.form.UsuarioForm;

@Controller
@RequestMapping("/")
@SessionScoped
public class IndexController {

	public List<Local> locais;

	public IndexController() {
		locais = new ArrayList<Local>();

		Local local = new Local();
		local.setNome("LEDS");

		Local local2 = new Local();
		local2.setNome("IFES");

		Local local3 = new Local();
		local3.setNome("SALA DE AULA");

		locais.add(local);
		locais.add(local2);
		locais.add(local3);
	}

	@RequestMapping(value = "/isWorking", method = RequestMethod.GET)
	@ResponseBody
	public String isWorking() {

		return "is Working";
	}
	@RequestMapping(value = "/locais", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Local>> getLocais(@RequestBody String login) {

		List<Local> localTemp = null;

		try {

			if (login.equals("JEDI")) {
				localTemp = locais;
			}
			else{
				localTemp = new ArrayList<Local>();
				
				Local local = new Local();
				local.setNome("NenhumLocal");
				localTemp.add(local);
			}

			return new ResponseEntity<List<Local>>(localTemp, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Local>>(localTemp,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loadForm(ModelMap model) {

		preProc(model);

		return "index";
	}

	private void preProc(ModelMap model) {
		UsuarioForm usuarioForm = new UsuarioForm();

		model.addAttribute("MensagemInicial", "Bem vindo JEDI!");

		model.addAttribute("usuario", usuarioForm);
	}

	@RequestMapping(value = "/autenticarUsuario", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute UsuarioForm usuarioForm,
			ModelMap model) {

		// Validando o usuario
		if (usuarioForm.getLogin().equals("JEDI")
				&& usuarioForm.getSenha().equals("1234")
				&& usuarioForm.getLocal().equals("LEDS")) {
			// Usuario
			Usuario usuario = new Usuario();

			usuario.setNome("Yoda");
			usuario.setLogin("JEDI");
			usuario.setSenha("1234");
			usuario.setLocais(locais);

			model.addAttribute("usuario", usuario);

			return "result";
		}
		return "redirect:/Mensagem/ErrorLogin";

	}

	@RequestMapping(value = "/Mensagem/{mensagem}", method = RequestMethod.GET)
	public String loadForm(ModelMap model, @PathVariable String mensagem) {

		preProc(model);
		if (mensagem.equals("ErrorLogin")) {
			model.addAttribute("mensagem", "Usuario Invalido");
		}

		return "index";
	}

}
