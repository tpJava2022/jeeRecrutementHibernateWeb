package ma.fstm.recrutement.model.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ma.fstm.recrutement.model.bo.Offre;
import ma.fstm.recrutement.model.bo.Recruteur;

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
			session.close();
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
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//Offre offre= session.load(Offre.class,id);
			List<Offre> offres=session.createQuery("from Offre o where o.id=:id").setParameter("id", id).list();
			session.flush();
			tx.commit();
			session.close();
			if(offres.isEmpty())
				return null;
			return offres.get(0);
		}catch(HibernateException ex) {
			ex.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
			return null;
		}
		
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
