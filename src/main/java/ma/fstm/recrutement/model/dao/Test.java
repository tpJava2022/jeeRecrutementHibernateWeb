package ma.fstm.recrutement.model.dao;

import java.io.*;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.io.IOUtils;

import com.mysql.cj.xdevapi.Type;

import ma.fstm.recrutement.model.bo.Candidat;
import ma.fstm.recrutement.model.bo.Offre;
import ma.fstm.recrutement.model.bo.Recruteur;
import ma.fstm.recrutement.model.bo.TypeContrat;

public class Test {

	public static void main(String[] args) {
		//ConnectionHibernate.getSession();
		 //DaoOffreImpl daoOffreImpl=new DaoOffreImpl(); Collection<Offre>
		 //offres=daoOffreImpl.getAll(); for(Offre offre:offres) {
		 //System.out.println(offre.getTitle()); }
		 
		//Recruteur r=new DaoRecruteurImpl().retreive("BE902914");
		//System.out.println(r.getNom());
		Candidat candidat=new DaoCandidatImpl().retrieve("BE90291");
		if(candidat!=null)
		System.out.println(candidat.getPrenom());
		else
			System.out.println("null");
		
	}
}
