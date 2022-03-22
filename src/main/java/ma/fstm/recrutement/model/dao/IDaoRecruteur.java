package ma.fstm.recrutement.model.dao;

import ma.fstm.recrutement.model.bo.Recruteur;

public interface IDaoRecruteur {
	Recruteur retreive(String cin);
	Recruteur retreive(Long id);
}
