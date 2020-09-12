package dev.paie.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Entreprise;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.service.ProfilRemunerationService;

@RestController
@CrossOrigin
@RequestMapping("profil_remuneration")
public class profilRemuCtrl {

	
	private ProfilRemunerationService profilRemunerationService;

	public profilRemuCtrl(ProfilRemunerationService profilRemunerationService) {
		this.profilRemunerationService = profilRemunerationService;
	}
	
	//lire tout
		@GetMapping
		public List<ProfilRemuneration> readAll(){
			return profilRemunerationService.readAll();
		}
}
