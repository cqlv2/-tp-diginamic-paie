package dev.paie.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profil_remuneration")
public class ProfilRemuneration {

//	table profil_remuneration (id, code)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "code", length = 50, nullable = false)
	private String code;
	
	@ManyToMany
	@JoinTable(name = "profil_remuneration_cotisations", joinColumns = @JoinColumn(name = "profil_remuneration_id"), inverseJoinColumns = @JoinColumn(name = "cotisations_id"))
	private List<Cotisation> cotisations;
	
	@ManyToMany
	@JoinTable(name = "profil_remuneration_avantage", joinColumns = @JoinColumn(name = "profil_remuneration_id"), inverseJoinColumns = @JoinColumn(name = "avantage_id"))
	private List<Avantage> avantages;

//	getteur/Setteur

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
