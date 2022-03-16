package ma.fstm.recrutement.model.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ma.fstm.recrutement.model.bo.Offre;

public class DaoOffreImpl implements IDaoOffre {

	@Override
	public boolean add(Offre o) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		boolean bol=false;
		try {
			tx=session.beginTransaction();
			session.save(o);
			session.flush();
			tx.commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			return false;
			
		}
		
	}

	@Override
	public boolean delete(Offre o) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		boolean bol=false;
		try {
			tx=session.beginTransaction();
			session.delete(o);
			session.flush();
			tx.commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			return false;
			
		}
	}

	@Override
	public boolean update(Offre o) {
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session;
		if(sessionFactory.isOpen())
			session=sessionFactory.getCurrentSession();
		else {
			session=sessionFactory.openSession();
		}
		Transaction tx=null;
		boolean bol=false;
		try {
			tx=session.beginTransaction();
			session.update(o);
			session.flush();
			tx.commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			return false;
		}
	}

	@Override
	public Collection<Offre> getAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		return session.createQuery("from Offre").list();
	}

	@Override
	public Offre findById(Long id) {
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		return session.load(Offre.class,id);
			//session.flush();
			//return o;
			
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		boolean bol=false;
		try {
			tx=session.beginTransaction();
			Offre o=session.load(Offre.class,id);
			session.delete(o);
			session.flush();
			tx.commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			return false;
			
		}
	}

}
