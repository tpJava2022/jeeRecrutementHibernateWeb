package ma.fstm.recrutement.model.dao;

import java.util.Collection;
import java.util.Date;

import com.mysql.cj.xdevapi.Type;

import ma.fstm.recrutement.model.bo.Offre;
import ma.fstm.recrutement.model.bo.Recruteur;
import ma.fstm.recrutement.model.bo.TypeContrat;

public class Test {

	public static void main(String[] args) {
		 //DaoOffreImpl daoOffreImpl=new DaoOffreImpl(); Collection<Offre>
		 //offres=daoOffreImpl.getAll(); for(Offre offre:offres) {
		 //System.out.println(offre.getTitle()); }
		 
		Recruteur r=new DaoRecruteurImpl().retreive("yuhhihuiuh");
		System.out.println(r.getNom());
		
	}
}
