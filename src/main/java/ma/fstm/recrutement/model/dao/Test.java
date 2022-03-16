package ma.fstm.recrutement.model.dao;

import java.util.Collection;
import java.util.Date;

import com.mysql.cj.xdevapi.Type;

import ma.fstm.recrutement.model.bo.Offre;
import ma.fstm.recrutement.model.bo.TypeContrat;

public class Test {

	public static void main(String[] args) {
		/*
		 * DaoOffreImpl daoOffreImpl=new DaoOffreImpl(); Collection<Offre>
		 * offres=daoOffreImpl.getAll(); for(Offre offre:offres) {
		 * System.out.println(offre.getTitle()); }
		 */
		DaoOffreImpl daoOffreImpl=new DaoOffreImpl();
		Offre offre=new Offre();
		offre.setId(Long.valueOf(2));
		offre.setDescription("");
		offre.setDate(new Date());
		offre.setProfil("ing");
		offre.setTitle("dev full");
		TypeContrat type=new TypeContrat();
		type.setIdType(Long.valueOf(2));
		offre.setTypeContrat(type);
		daoOffreImpl.update(offre);
		
	}
}
