package dev.paie.dto;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;

public class RemunerationEmployerDto {

	private Integer id = null;
	private String matricule;
	private int entrepriseId;
	private int profilRemunerationId;
	private int gradeId;
	
	public RemunerationEmployerDto(String matricule, int entrepriseId, int profilRemunerationId, int gradeId) {
		this.matricule = matricule;
		this.entrepriseId = entrepriseId;
		this.profilRemunerationId = profilRemunerationId;
		this.gradeId = gradeId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public int getEntrepriseId() {
		return entrepriseId;
	}
	public void setEntrepriseId(int entrepriseId) {
		this.entrepriseId = entrepriseId;
	}
	public int getProfilRemunerationId() {
		return profilRemunerationId;
	}
	public void setProfilRemunerationId(int profilRemunerationId) {
		this.profilRemunerationId = profilRemunerationId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
}
