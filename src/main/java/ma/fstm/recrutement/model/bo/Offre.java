package ma.fstm.recrutement.model.bo;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

@Entity
@Table(name = "offre")

public class Offre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Date date;
	private String Profil;
	@ManyToOne()
	@JoinColumn(name = "typeContrat", nullable = false)
	private TypeContrat typeContrat;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recruteur",nullable = false)
	private Recruteur recruteur;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "postulation",joinColumns = {
			@JoinColumn(name="offre")
	},inverseJoinColumns = {
			@JoinColumn(name="candidat")
	})
	private Set<Candidat> candidats=new TreeSet<Candidat>();
	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offre(String title, String description, Date date, String profil, TypeContrat typeContrat) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		Profil = profil;
		this.typeContrat = typeContrat;
	}
	public Offre(Long id, String title, String description, Date date, String profil, TypeContrat typeContrat) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		Profil = profil;
		this.typeContrat = typeContrat;
	}
	
	
	public Recruteur getRecruteur() {
		return recruteur;
	}
	public void setRecruteur(Recruteur recruteur) {
		this.recruteur = recruteur;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getProfil() {
		return Profil;
	}
	public void setProfil(String profil) {
		Profil = profil;
	}
	public TypeContrat getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}
	public Set<Candidat> getCandidats() {
		return candidats;
	}
	public void setCandidats(Set<Candidat> candidats) {
		this.candidats = candidats;
	}

	
}
