package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;


@Service
public class EntrepriseService {

	private EntrepriseRepository entrepriseRepo;

	public EntrepriseService(EntrepriseRepository entrepriseRepo) {
		this.entrepriseRepo = entrepriseRepo;
	}
	
	
	
//	lecture
	public List<Entreprise> readAll() {
		return entrepriseRepo.findAll();
	}
	
	
	
	
}
