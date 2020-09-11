package dev.paie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.ProfilRemuRepository;

@Service
public class ProfilRemunerationService {

	private ProfilRemuRepository profilRemuRepo;
	private cotisationService cotServ;
	private AvantageService aventServ;
	

	


	public ProfilRemunerationService(ProfilRemuRepository profilRemuRepo, cotisationService cotServ,
			AvantageService aventServ) {
		super();
		this.profilRemuRepo = profilRemuRepo;
		this.cotServ = cotServ;
		this.aventServ = aventServ;
	}





	//	lecture
	public List<ProfilRemuneration> readAll() {
		return profilRemuRepo.findAll();
	}





	public Optional<ProfilRemuneration> readById(int id) {
		return profilRemuRepo.findById(id);
	}
	
}
