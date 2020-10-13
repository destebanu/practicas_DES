package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorFormulario {
	
	@RequestMapping(value="/formulario", method=RequestMethod.GET)
	public String form_get() {

		return "formulario";
	}

	@RequestMapping(value="/formulario", method=RequestMethod.POST)
	public String form_post(Model modelo,
			@RequestParam String nombre, String apell1, String apell2,
			String email, String fenac, String contrasena, String gender,
			String direcc, String nivest, String art1, String art2,
			String art3, String art4, String art5) {
		
		modelo.addAttribute("nombre_form", nombre);
		modelo.addAttribute("apell1_form", apell1);
		modelo.addAttribute("apell2_form", apell2);
		modelo.addAttribute("email_form", email);
		modelo.addAttribute("fenac_form", fenac);
		modelo.addAttribute("contrasena_form", contrasena);
		modelo.addAttribute("sexo_form", gender);
		modelo.addAttribute("direccion_form", direcc);
		modelo.addAttribute("nivest_form", nivest);
		modelo.addAttribute("musica_form", art1);
		modelo.addAttribute("deportes_form", art2);
		modelo.addAttribute("cine_form", art3);
		modelo.addAttribute("libros_form", art4);
		modelo.addAttribute("ciencia_form", art5);

		
		return "datosFormulario";
}
}