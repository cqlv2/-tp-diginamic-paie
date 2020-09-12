package dev.paie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.repository.BulletinSalaireRepository;

@Service
public class BulletinSalaireService {

	private BulletinSalaireRepository bsRepo;
	private RemunerationEmployeService remEmpServ;
	private PeriodeService periodeServ;
	
	
	
	
	
	public BulletinSalaireService(BulletinSalaireRepository bsRepo, RemunerationEmployeService remEmpServ,
			PeriodeService periodeServ) {
		super();
		this.bsRepo = bsRepo;
		this.remEmpServ = remEmpServ;
		this.periodeServ = periodeServ;
	}





	public List<BulletinSalaire> readAll() {
		return bsRepo.findAll();
	}





	public Optional<BulletinSalaire> readById(Integer id) {
		return bsRepo.findById(id);
	}
	
	
}
