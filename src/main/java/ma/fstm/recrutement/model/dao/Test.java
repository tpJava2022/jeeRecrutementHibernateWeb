package ma.fstm.recrutement.model.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;

import com.mysql.cj.xdevapi.Type;

import ma.fstm.recrutement.model.bo.Candidat;
import ma.fstm.recrutement.model.bo.Offre;
import ma.fstm.recrutement.model.bo.Recruteur;
import ma.fstm.recrutement.model.bo.TypeContrat;

public class Test {

	Collection<Offre> substract(Collection<Offre>offres1,Collection<Offre>offres2) {
		Collection<Offre> offres=new ArrayList<Offre>();
		boolean temoin;
		for(Offre offre1 :offres1) {
			temoin=false;
			for(Offre offre2:offres2) {
				if(offre1.getId()==offre2.getId())
					temoin=true;
					
			}
			if(!temoin) {
				offres.add(offre1);
			}
			
		}
		return offres;
	}
	public static void main(String[] args) {
		//ConnectionHibernate.getSession();
		 //DaoOffreImpl daoOffreImpl=new DaoOffreImpl(); Collection<Offre>
		 //offres=daoOffreImpl.getAll(); for(Offre offre:offres) {
		 //System.out.println(offre.getTitle()); }
		 
		//Recruteur r=new DaoRecruteurImpl().retreive("BE902914");
		//System.out.println(r.getNom());
		/*Candidat candidat=new DaoCandidatImpl().retrieve("BE90291");
		if(candidat!=null)
		System.out.println(candidat.getPrenom());
		else
			System.out.println("null");*/
		
		/*DaoCandidatImpl dao=new DaoCandidatImpl();
		DaoOffreImpl daoOffre=new DaoOffreImpl();
		Collection<Offre> offres2=daoOffre.getAll();
		Candidat candidat=dao.retrieve("BE902914");
		ArrayList<Offre> offres=new ArrayList<Offre>(candidat.getOffres());
		for(Offre o:offres) {
			System.out.println(o.getTitle());
		}
		
		for(Offre o:offres2) {
			System.out.println(o.getTitle());
		}
		
		Collection<Offre> offres3=new Test().substract(offres2, offres);
		System.out.println("-----------------");
		for(Offre o:offres3) {
			System.out.println(o.getTitle());
		}*/
		
		Candidat c=new DaoCandidatImpl().retrieve(Long.valueOf(1));
		System.out.println(c.getCIN());
		//Candidat c=daoCandidat.retrieve(id);
		OutputStream out;
		try {
			out = new FileOutputStream(c.getCIN()+".pdf");
			out.write(c.getCv());
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
