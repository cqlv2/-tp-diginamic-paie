package dev.paie.service;

import java.util.List;
import java.util.Optional;

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



	public Optional<Entreprise> readById(int id) {
		return entrepriseRepo.findById(id);
	}
	
	
	
	
}
