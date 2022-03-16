package ma.fstm.recrutement.model.dao;

import java.util.Collection;

import ma.fstm.recrutement.model.bo.*;

public interface IDaoOffre {

	boolean add(Offre o);
	boolean delete(Offre o);
	boolean delete(Long id);
	boolean update(Offre o);
	Collection<Offre> getAll();
	Offre findById(Long id);
}
