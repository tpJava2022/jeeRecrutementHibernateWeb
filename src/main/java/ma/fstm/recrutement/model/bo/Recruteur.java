package ma.fstm.recrutement.model.bo;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "recruteur")
public class Recruteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String prenom;
	private String nom;
	private String CIN;
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "recruteur")
	private Set<Offre> offres;
	public Recruteur(Long id, String prenom, String nom, String cIN, Set<Offre> offres) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		CIN = cIN;
		this.offres = offres;
	}
	public Recruteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public Set<Offre> getOffres() {
		return offres;
	}
	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}
	
	
}
