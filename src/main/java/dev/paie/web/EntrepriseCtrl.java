package dev.paie.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Entreprise;
import dev.paie.service.EntrepriseService;

@RestController
@CrossOrigin
@RequestMapping("entreprise")
public class EntrepriseCtrl {

	
	private EntrepriseService entrepriseServ;

	public EntrepriseCtrl(EntrepriseService entrepriseServ) {
		this.entrepriseServ = entrepriseServ;
	}
	
	//lire tout
		@GetMapping
		public List<Entreprise> readAll(){
			return entrepriseServ.readAll();
		}
}
