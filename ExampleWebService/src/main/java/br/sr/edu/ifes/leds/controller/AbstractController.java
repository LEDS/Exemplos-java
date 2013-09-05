package br.sr.edu.ifes.leds.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractController   {

	@RequestMapping(value="/isWorking", method = RequestMethod.GET)
	public @ResponseBody String isWorking() {
		
		return "is Working";
		
	}
	
	@RequestMapping(value="/islist", method = RequestMethod.POST)
	public @ResponseBody String isWorking(@RequestBody List<String> lista) {
		
		return "is Working list";
		
	}

}
