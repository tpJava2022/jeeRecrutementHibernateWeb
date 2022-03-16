package ma.fstm.recrutement.model.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeContrat", nullable = false)
	private TypeContrat typeContrat;
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


}
