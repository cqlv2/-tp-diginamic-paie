package dev.paie.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.BulletinPaieSamble;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.service.BulletinSalaireService;

@RestController
@RequestMapping("bulletin_salaire")
public class BulletinSalaireCtrl {

	private BulletinSalaireService bsService;

	public BulletinSalaireCtrl(BulletinSalaireService bsService) {
		this.bsService = bsService;
	}

	// lire tout
	@GetMapping
	public List<BulletinSalaire> readAll() {
		return bsService.readAll();
	}

	// listeBulletin
	@GetMapping("/liste")
	public ResponseEntity<?> listBulletin() {

		List<BulletinPaieSamble> samples=new ArrayList<BulletinPaieSamble>();
		List<BulletinSalaire> bulletins = bsService.readAll();
		for (BulletinSalaire bulletin : bulletins) {

		// SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
		BigDecimal salaireBase = bulletin.getRemunerationEmploye().getGrade().getTauxBase().multiply(bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase());
		
		// SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
		BigDecimal salaireBrut =  salaireBase.add(bulletin.getPrimeExceptionnelle());
		
		// TOTAL_RETENUE_SALARIALE = SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		BigDecimal totalRetenuSalaire=new BigDecimal("0.00");
		List<Cotisation> cotisations=bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisations();
		for (Cotisation cotisation : cotisations) {
			if(cotisation.getImposable()==false) {
				totalRetenuSalaire=totalRetenuSalaire.add(cotisation.getTauxSalarial().multiply(salaireBrut));	
			}
		}
			
		// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE
		BigDecimal netImposable=salaireBrut.subtract(totalRetenuSalaire);
		
		// NET_A_PAYER = NET_IMPOSABLE - SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		BigDecimal charges=new BigDecimal("0.00");
		for (Cotisation cotisation : cotisations) {
			if(cotisation.getImposable()) {
				charges=charges.add(cotisation.getTauxSalarial().multiply(salaireBrut));
			}
		}
		BigDecimal netAPayer=netImposable.subtract(charges);		
		samples.add(new BulletinPaieSamble(bulletin.getPeriode(), bulletin.getRemunerationEmploye().getMatricule(), salaireBrut, netImposable, netAPayer));
		}
		return ResponseEntity.ok(samples);
	}
}
