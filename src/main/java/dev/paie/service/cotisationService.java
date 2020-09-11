package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@Service
public class cotisationService {

	private CotisationRepository cotRepo;

	public cotisationService(CotisationRepository cotRepo) {
		super();
		this.cotRepo = cotRepo;
	}

	
	public List<Cotisation> readAll(){
		return cotRepo.findAll();
	}
	
}
