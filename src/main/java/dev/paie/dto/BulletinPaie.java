package dev.paie.dto;

import java.math.BigDecimal;
import java.util.List;

import dev.paie.entite.Periode;

public class BulletinPaie {

	
	Periode periode;
	String nomEntreprise;
	String siretEntreprise;
	String matricule;
	BigDecimal baseHoraire;
	BigDecimal tauxSalarial;
	BigDecimal salaireBase;
	BigDecimal primeExceptionnelle;
	BigDecimal salaireBrut;
	List<CotisationDto> cotisations;
	BigDecimal totalCotisationSalarial;
	BigDecimal totalCotisationPatronal;
	BigDecimal netImposable;
	List<CotisationDto> cotisationsImposable;
	BigDecimal netAPayer;
	
	
	
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getSiretEntreprise() {
		return siretEntreprise;
	}
	public void setSiretEntreprise(String siretEntreprise) {
		this.siretEntreprise = siretEntreprise;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public BigDecimal getBaseHoraire() {
		return baseHoraire;
	}
	public void setBaseHoraire(BigDecimal baseHoraire) {
		this.baseHoraire = baseHoraire;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getSalaireBase() {
		return salaireBase;
	}
	public void setSalaireBase(BigDecimal salaireBase) {
		this.salaireBase = salaireBase;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public BigDecimal getSalaireBrut() {
		return salaireBrut;
	}
	public void setSalaireBrut(BigDecimal salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	public List<CotisationDto> getCotisations() {
		return cotisations;
	}
	public void setCotisations(List<CotisationDto> cotisations) {
		this.cotisations = cotisations;
	}
	public BigDecimal getTotalCotisationSalarial() {
		return totalCotisationSalarial;
	}
	public void setTotalCotisationSalarial(BigDecimal totalCotisationSalarial) {
		this.totalCotisationSalarial = totalCotisationSalarial;
	}
	public BigDecimal getTotalCotisationPatronal() {
		return totalCotisationPatronal;
	}
	public void setTotalCotisationPatronal(BigDecimal totalCotisationPatronal) {
		this.totalCotisationPatronal = totalCotisationPatronal;
	}
	public BigDecimal getNetImposable() {
		return netImposable;
	}
	public void setNetImposable(BigDecimal netImposable) {
		this.netImposable = netImposable;
	}
	public List<CotisationDto> getCotisationsImposable() {
		return cotisationsImposable;
	}
	public void setCotisationsImposable(List<CotisationDto> cotisationsImposable) {
		this.cotisationsImposable = cotisationsImposable;
	}
	public BigDecimal getNetAPayer() {
		return netAPayer;
	}
	public void setNetAPayer(BigDecimal netAPayer) {
		this.netAPayer = netAPayer;
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
}
