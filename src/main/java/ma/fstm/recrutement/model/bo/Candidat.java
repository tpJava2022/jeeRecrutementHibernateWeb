package ma.fstm.recrutement.model.bo;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;
@Entity
@Table(name = "candidat")
public class Candidat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25)
	private String prenom;
	@Column(length = 25)
	private String nom;
	@Column(length = 25)
	private String CIN;
	@Column(length = 100)
	private String mail;
	private byte[] cv;
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "candidats")
	private Set<Offre> offres=new TreeSet<Offre>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Offre> getOffres() {
		return offres;
	}
	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public byte[] getCv() {
		return cv;
	}
	public void setCv(byte[] cv) {
		this.cv = cv;
	}
	
}
