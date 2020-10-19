package co.com.app.palindroma.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.app.palindroma.app.proceso.ProcesoPalindromo;

@Controller
public class PalindromaController {
	
	@Autowired
	private ProcesoPalindromo procesopalindromo;
	
	@RequestMapping(value="/palindroma", method=RequestMethod.GET)
	public String obtener(Model model) {
			model.addAttribute("titulo", "Buscar Palindroma");
			//if (procesopalindromo.getPalindromo() == "") {
				model.addAttribute("cadenaPalindromo", procesopalindromo.getPalindromo());
			//}
			//else {
			//	model.addAttribute("cadenaPalindromo", procesopalindromo.getPalindromo());
			//}
		return "buscarpalindroma";
	}
	
	@RequestMapping(value="/palindroma", method=RequestMethod.POST)
	public String buscar(@RequestBody String texto) {
			procesopalindromo.Buscar(texto);

		return "redirect:/palindroma";
	}
}
