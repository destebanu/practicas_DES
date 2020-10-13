package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorIMC {

	@RequestMapping(value="/formulario", method=RequestMethod.GET)
	public String form_get() {

		return "formulario";
	}

	@RequestMapping(value="/formulario", method=RequestMethod.POST)
	public String form_post(Model modelo,
			@RequestParam double peso, double estatura, int edad,
			String sexo) {
		
		modelo.addAttribute("peso_form", peso);
		modelo.addAttribute("estatura_form", estatura);
		modelo.addAttribute("edad_form", edad);
		modelo.addAttribute("sexo_form", sexo);
		
		//Se calcula el índice de masa corporal
		double imc = peso/(estatura*estatura); 
		modelo.addAttribute("imc_form", imc);
		
		//Se calcula el porcentaje de grasa corporal
		int valSex=(sexo.equals("Mujer"))?0:1;
		System.out.println(sexo);
		double pgc= (1.2*imc)+(0.23*edad)-(10.8*valSex)-5.4;
		modelo.addAttribute("pgc_form", pgc);
		
		String resultado;
		
		if (valSex == 1) {
			if (pgc > 2 && pgc < 5)
				resultado = "Grasa esencial";
			else if (pgc > 6 && pgc < 13)
				resultado = "Atletas";
			else if (pgc > 14 && pgc < 17)
				resultado = "Fitness";
			else if (pgc > 18 && pgc < 24)
				resultado = "Aceptable";
			else resultado = "Obesidad";
		}
		else {
			if (pgc > 10 && pgc < 13)
				resultado = "Grasa esencial";
			else if (pgc > 14 && pgc < 20)
				resultado = "Atletas";
			else if (pgc > 21 && pgc < 24)
				resultado = "Fitness";
			else if (pgc > 25 && pgc < 31)
				resultado = "Aceptable";
			else resultado = "Obesidad";
		}
		
		modelo.addAttribute("resultado_form", resultado);
		
		return "datosFormulario";
}
}
