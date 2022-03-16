package ma.fstm.recrutement.model.bo;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="typeContrat")
public class TypeContrat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idType;
	private String libelle;
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "typeContrat")
	private Set<Offre> offres;
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Set<Offre> getOffres() {
		return offres;
	}
	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}
	public TypeContrat() {
		super();
		// TODO Auto-generated constructor stub
		offres=new TreeSet<Offre>();
	}
	
	
	
	

}
