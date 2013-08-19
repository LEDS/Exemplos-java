package br.sr.edu.ifes.leds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends AbstractController {

	@Autowired
	private UsuarioService service;

	// Retornando a quantidade de usuarios
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Long> count() {

		try {

			Long count = service.count();
			return new ResponseEntity<Long>(count, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Long>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Adicionando um usuario
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@RequestBody Usuario usuario) {
		try {

				service.save(usuario);
				
				return new ResponseEntity<String>(usuario.getId().toString(),
						HttpStatus.OK);
			

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	// Retornando um usuario;
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Usuario> get(@PathVariable Long id) {
		try {

			Usuario usuario = service.get(id);

			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
