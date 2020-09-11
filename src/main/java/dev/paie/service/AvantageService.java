package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.Avantage;
import dev.paie.repository.AvantageRepository;

@Service
public class AvantageService {

	private AvantageRepository advRepo;

	public AvantageService(AvantageRepository advRepo) {
		super();
		this.advRepo = advRepo;
	}
	
	public List<Avantage> readAll(){
		return advRepo.findAll();
	}
	
}
