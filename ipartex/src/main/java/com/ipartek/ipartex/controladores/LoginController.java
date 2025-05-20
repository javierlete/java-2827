package com.ipartek.ipartex.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.ipartex.entidades.Usuario;
import com.ipartek.ipartex.servicios.AnonimoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LoginController {
	private final AnonimoService anonimoService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registro")
	public String registroGet(Usuario usuario) {
		return "registro";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid Usuario usuario, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "registro";
		}
		
		anonimoService.registrarUsuario(usuario);
		
		return "redirect:/";
	}
}
