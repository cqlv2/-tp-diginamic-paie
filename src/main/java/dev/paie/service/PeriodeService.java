package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Periode;
import dev.paie.repository.PeriodeRepository;

@Service
public class PeriodeService {

	private PeriodeRepository periodeRepo;

	public PeriodeService(PeriodeRepository periodeRepo) {
		this.periodeRepo = periodeRepo;
	}
	
	public Optional<Periode> readById(int idPeriod) {
		return periodeRepo.findById(idPeriod);
	}
	
	
}
