package dev.paie.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.BulletinPaie;
import dev.paie.dto.BulletinPaieSamble;
import dev.paie.dto.CotisationDto;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.service.BulletinSalaireService;

@RestController
@CrossOrigin
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
	


	// lire par id
	@GetMapping("affichage/{id}")
	public ResponseEntity<?> readById(@PathVariable Integer id) {
		Optional<BulletinSalaire> reqBulletin = bsService.readById(id);
		if (reqBulletin.isPresent()) {

			BulletinPaie bp = new BulletinPaie();
			bp.setPeriode(reqBulletin.get().getPeriode());
			bp.setNomEntreprise(reqBulletin.get().getRemunerationEmploye().getEntreprise().getDenomination());
			bp.setSiretEntreprise(reqBulletin.get().getRemunerationEmploye().getEntreprise().getSiret());
			bp.setMatricule(reqBulletin.get().getRemunerationEmploye().getMatricule());
			bp.setTauxSalarial(reqBulletin.get().getRemunerationEmploye().getGrade().getTauxBase());
			bp.setBaseHoraire(reqBulletin.get().getRemunerationEmploye().getGrade().getNbHeuresBase());
			bp.setSalaireBase(bp.getTauxSalarial().multiply(bp.getBaseHoraire()));
			bp.setPrimeExceptionnelle(reqBulletin.get().getPrimeExceptionnelle());
			bp.setSalaireBrut(bp.getSalaireBase().add(bp.getPrimeExceptionnelle()));
			// cotisations
			List<Cotisation> cotisations = reqBulletin.get().getRemunerationEmploye().getProfilRemuneration()
					.getCotisations();
			List<CotisationDto> cotisationsDto = new ArrayList<CotisationDto>();
			for (Cotisation cotisation : cotisations) {
				if (cotisation.getImposable() == false) {
					CotisationDto cDto = new CotisationDto();
					cDto.setLibelle(cotisation.getLibelle());
					cDto.setBase(bp.getSalaireBrut());
					cDto.setTauxPatronal(cotisation.getTauxPatronal());
					cDto.setTauxSalarial(cotisation.getTauxSalarial());
					cDto.setCotisationPatronal(cDto.getBase().multiply(cDto.getTauxPatronal()));
					cDto.setMontantSalarial(cDto.getBase().multiply(cDto.getTauxSalarial()));
					cotisationsDto.add(cDto);
				}
			}
			bp.setCotisations(cotisationsDto);
			// total cotisation
			bp.setTotalCotisationPatronal(new BigDecimal("0.00"));
			bp.setTotalCotisationSalarial(new BigDecimal("0.00"));
			for (CotisationDto cotisationDto : cotisationsDto) {
				bp.setTotalCotisationPatronal(
						bp.getTotalCotisationPatronal().add(cotisationDto.getCotisationPatronal()));
				bp.setTotalCotisationSalarial(bp.getTotalCotisationSalarial().add(cotisationDto.getMontantSalarial()));
			}

			bp.setNetImposable(bp.getSalaireBrut().subtract(bp.getTotalCotisationSalarial()));

			// imposable
			List<CotisationDto> cotisationsDtoImposable = new ArrayList<CotisationDto>();
			for (Cotisation cotisation : cotisations) {
				if (cotisation.getImposable()) {
					CotisationDto cDto = new CotisationDto();
					cDto.setLibelle(cotisation.getLibelle());
					cDto.setBase(bp.getSalaireBrut());
					cDto.setTauxPatronal(cotisation.getTauxPatronal());
					cDto.setTauxSalarial(cotisation.getTauxSalarial());
					cDto.setCotisationPatronal(cDto.getBase().multiply(cDto.getTauxPatronal()));
					cDto.setMontantSalarial(cDto.getBase().multiply(cDto.getTauxSalarial()));
					cotisationsDtoImposable.add(cDto);
				}
			}

			bp.setCotisationsImposable(cotisationsDtoImposable);
//				calcul du net a payer
			BigDecimal cotisationImposable = new BigDecimal("0.00");
			for (CotisationDto cotisationDto : cotisationsDtoImposable) {
				cotisationImposable = (cotisationImposable.add(cotisationDto.getMontantSalarial()));
			}

			bp.setNetAPayer(bp.getNetImposable().subtract(cotisationImposable));

			return ResponseEntity.status(HttpStatus.OK).body(bp);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id non valide");
		}
	}

	// listeBulletin
	@GetMapping("/liste")
	public ResponseEntity<?> listBulletin(@RequestParam int page,@RequestParam int size) {

		List<BulletinPaieSamble> samples = new ArrayList<BulletinPaieSamble>();
		List<BulletinSalaire> bulletins = bsService.readAllPagination(page,size);
		for (BulletinSalaire bulletin : bulletins) {

			// SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
			BigDecimal salaireBase = bulletin.getRemunerationEmploye().getGrade().getTauxBase()
					.multiply(bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase());

			// SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
			BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());

			// TOTAL_RETENUE_SALARIALE =
			// SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
			BigDecimal totalRetenuSalaire = new BigDecimal("0.00");
			List<Cotisation> cotisations = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisations();
			for (Cotisation cotisation : cotisations) {
				if (cotisation.getImposable() == false) {
					totalRetenuSalaire = totalRetenuSalaire.add(cotisation.getTauxSalarial().multiply(salaireBrut));
				}
			}

			// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE
			BigDecimal netImposable = salaireBrut.subtract(totalRetenuSalaire);

			// NET_A_PAYER = NET_IMPOSABLE -
			// SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
			BigDecimal charges = new BigDecimal("0.00");
			for (Cotisation cotisation : cotisations) {
				if (cotisation.getImposable()) {
					charges = charges.add(cotisation.getTauxSalarial().multiply(salaireBrut));
				}
			}
			BigDecimal netAPayer = netImposable.subtract(charges);
			samples.add(new BulletinPaieSamble(bulletin.getId(), bulletin.getPeriode(), bulletin.getRemunerationEmploye().getMatricule(),
					salaireBrut, netImposable, netAPayer));
		}
		return ResponseEntity.ok(samples);
	}
}
