package ma.fstm.recrutement.model.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.fstm.recrutement.model.bo.TypeContrat;

public class DaoTypeContratImpl implements IDaoTypeContrat {

	@Override
	public Collection<TypeContrat> getAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		
		return session.createQuery("from TypeContrat").list();
	}

}
