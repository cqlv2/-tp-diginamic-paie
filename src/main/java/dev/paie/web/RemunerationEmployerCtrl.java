package dev.paie.web;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.RemunerationEmployerDto;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.service.RemunerationEmployeService;

@RestController
@CrossOrigin
@RequestMapping("remuneration_employer")
public class RemunerationEmployerCtrl {

	private RemunerationEmployeService remEmpServ;

	public RemunerationEmployerCtrl(RemunerationEmployeService remEmpServ) {
		super();
		this.remEmpServ = remEmpServ;
	}

	@PostMapping
	public ResponseEntity<?> remuneration_employer(@RequestBody RemunerationEmployerDto remEmpDto) {

		RemunerationEmploye remEmp = remEmpServ.add(remEmpDto.getMatricule(), remEmpDto.getEntrepriseId(),
				remEmpDto.getProfilRemunerationId(), remEmpDto.getGradeId());

		remEmpDto.setId(remEmp.getId());
		return ResponseEntity.ok(remEmp);

	}

}
