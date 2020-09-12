package dev.paie.dto;

import java.math.BigDecimal;
import java.util.Date;

import dev.paie.entite.Periode;

public class BulletinPaieSamble {

	Date dateCreation = new Date();
	Periode periode;
	String matricule;
	BigDecimal salaireBrut;
	BigDecimal netImposable;
	BigDecimal NetAPayer;

	public BulletinPaieSamble(Periode periode, String matricule, BigDecimal salaireBrut, BigDecimal netImposable,
			BigDecimal netAPayer) {
		super();
		this.periode = periode;
		this.matricule = matricule;
		this.salaireBrut = salaireBrut;
		this.netImposable = netImposable;
		NetAPayer = netAPayer;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public BigDecimal getSalaireBrut() {
		return salaireBrut;
	}

	public void setSalaireBrut(BigDecimal salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	public BigDecimal getNetImposable() {
		return netImposable;
	}

	public void setNetImposable(BigDecimal netImposable) {
		this.netImposable = netImposable;
	}

	public BigDecimal getNetAPayer() {
		return NetAPayer;
	}

	public void setNetAPayer(BigDecimal netAPayer) {
		NetAPayer = netAPayer;
	}




}
