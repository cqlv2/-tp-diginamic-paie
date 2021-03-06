package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cotisation")
public class Cotisation {

//	table cotisation(id, code, imposable, libelle, taux_patronal, taux_salarial)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "code", length = 50, nullable = false)
	private String code;
	@Column(name = "libelle", length = 255, nullable = false)
	private String libelle;
	@Column(name = "taux_salarial", nullable = false, precision = 8, scale = 6)
	private BigDecimal tauxSalarial;
	@Column(name = "taux_patronal", nullable = false,precision = 8, scale = 6)
	private BigDecimal tauxPatronal;
	@Column(name = "imposable", nullable = false)
	private Boolean imposable = false;

	// Getteur/setteur
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}

	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}

	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getImposable() {
		return imposable;
	}

	public void setImposable(Boolean imposable) {
		this.imposable = imposable;
	}
}
