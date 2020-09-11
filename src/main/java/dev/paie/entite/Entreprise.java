package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entreprise")
public class Entreprise {

	// table entreprise (id, adresse, code_naf, denomination, siret, urssaf)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "siret", length = 50, nullable = false)
	private String siret;
	@Column(name = "denomination", length = 255, nullable = false)
	private String denomination;
	@Column(name = "adresse", nullable = false)
	private String adresse;
	@Column(name = "urssaf", length = 50, nullable = false)
	private String urssaf;
	@Column(name = "code_naf", length = 50, nullable = false)
	private String codeNaf;

	
	// getteur setteur

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getUrssaf() {
		return urssaf;
	}

	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}

	public String getCodeNaf() {
		return codeNaf;
	}

	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
