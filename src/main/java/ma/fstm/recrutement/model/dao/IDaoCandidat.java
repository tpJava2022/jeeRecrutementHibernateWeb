package ma.fstm.recrutement.model.dao;

import ma.fstm.recrutement.model.bo.Candidat;

public interface IDaoCandidat {
	Candidat add(Candidat candidat);
	Candidat update(Candidat candidat);
	Candidat retrieve(String CIN);
	
}
