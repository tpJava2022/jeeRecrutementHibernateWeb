package ma.fstm.recrutement.model.dao;

import java.util.List;

import org.hibernate.*;

import ma.fstm.recrutement.model.bo.Recruteur;

public class DaoRecruteurImpl implements IDaoRecruteur {

	@Override
	public Recruteur retreive(String cin) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session;
		if(sessionFactory.isOpen())
			session=sessionFactory.getCurrentSession();
		else
			session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		try {
			List<Recruteur> r=session.createQuery("from Recruteur r where r.CIN=:c").setParameter("c", cin).list();
			tx.commit();
			if(r.isEmpty())
				return null;
			return r.get(0);			
		}catch(HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			return null;
		}
		
	}

	@Override
	public Recruteur retreive(Long id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session;
		session=sessionFactory.openSession();
		return session.load(Recruteur.class, id);
	}

}
