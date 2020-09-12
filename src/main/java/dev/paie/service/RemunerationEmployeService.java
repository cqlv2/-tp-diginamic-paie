package dev.paie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.exception.remunerationEmployerException;
import dev.paie.repository.remunerationEmployerRepository;

@Service
public class RemunerationEmployeService {

	private remunerationEmployerRepository remEmpRepo;
	private EntrepriseService entrepriseServ;
	private ProfilRemunerationService profilRemServ;
	private GradeService gradeServ;

	public RemunerationEmployeService(remunerationEmployerRepository remEmpRepo, EntrepriseService entrepriseServ,
			ProfilRemunerationService profilRemServ, GradeService gradeServ) {
		super();
		this.remEmpRepo = remEmpRepo;
		this.entrepriseServ = entrepriseServ;
		this.profilRemServ = profilRemServ;
		this.gradeServ = gradeServ;
	}


	
	@Transactional
	public RemunerationEmploye add(String matricule,int entrepriseId,int profilRemId,int gradeId) {
		List<String> messagesErreurs = new ArrayList<>();
		Optional<Entreprise> entrepriseOpt = entrepriseServ.readById(entrepriseId);

		if (!entrepriseOpt.isPresent()) {
			messagesErreurs.add("L'id " + entrepriseId + " ne correspond à aucune entreprise");
		}
		
		Optional<ProfilRemuneration> profilRemOpt = profilRemServ.readById(profilRemId);

		if (!profilRemOpt.isPresent()) {
			messagesErreurs.add("L'id " + profilRemId + " ne correspond à aucun profil de remuneration");
		}
		
		Optional<Grade> gradeOpt = gradeServ.readById(gradeId);

		if (!gradeOpt.isPresent()) {
			messagesErreurs.add("L'id " + gradeId + " ne correspond à aucun grade");
		}
	

for (int i = 0; i < messagesErreurs.size(); i++) {
	System.err.println(messagesErreurs.get(i));
}







		if (!messagesErreurs.isEmpty()) {
			throw new remunerationEmployerException(messagesErreurs);
		}
		RemunerationEmploye remEmp = new RemunerationEmploye();
		remEmp.setMatricule(matricule);
		remEmp.setEntreprise(entrepriseOpt.get());
		remEmp.setGrade(gradeOpt.get());
		remEmp.setProfilRemuneration(profilRemOpt.get());
		return remEmpRepo.save(remEmp);
	}



}





