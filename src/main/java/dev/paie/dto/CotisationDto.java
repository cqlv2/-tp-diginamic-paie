package dev.paie.dto;

import java.math.BigDecimal;

public class CotisationDto {

	String libelle;
	BigDecimal base;
	BigDecimal tauxSalarial;
	BigDecimal montantSalarial;
	BigDecimal tauxPatronal;
	BigDecimal cotisationPatronal;
	
	
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getBase() {
		return base;
	}
	public void setBase(BigDecimal base) {
		this.base = base;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getMontantSalarial() {
		return montantSalarial;
	}
	public void setMontantSalarial(BigDecimal montantSalarial) {
		this.montantSalarial = montantSalarial;
	}
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	public BigDecimal getCotisationPatronal() {
		return cotisationPatronal;
	}
	public void setCotisationPatronal(BigDecimal cotisationPatronal) {
		this.cotisationPatronal = cotisationPatronal;
	}
	
	
	
}
