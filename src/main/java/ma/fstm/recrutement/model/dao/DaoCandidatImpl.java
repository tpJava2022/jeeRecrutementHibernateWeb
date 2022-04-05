package ma.fstm.recrutement.model.dao;

import java.util.List;

import org.hibernate.*;

import ma.fstm.recrutement.model.bo.Candidat;
import ma.fstm.recrutement.model.bo.Recruteur;

public class DaoCandidatImpl implements IDaoCandidat {

	@Override
	public Candidat add(Candidat candidat) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session;
		if(sessionFactory.isOpen()) {
			session=sessionFactory.getCurrentSession();
		}else {
			session=sessionFactory.openSession();
		}
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(candidat);
			tx.commit();
			session.close();
			return candidat;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
			session.close();
			return null;
		}		
	}

	@Override
	public Candidat update(Candidat candidat) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session;
		if(sessionFactory.isOpen()) {
			session=sessionFactory.getCurrentSession();
		}else {
			session=sessionFactory.openSession();
		}
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.update(candidat);
			tx.commit();
			session.close();
			return candidat;
		} catch (HibernateException e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			return null;
		}	
	}

	@Override
	public Candidat retrieve(String CIN) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session;
		if(sessionFactory.isOpen())
			session=sessionFactory.getCurrentSession();
		else
			session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		try {
			List<Candidat> candidat=session.createQuery("from Candidat candidat where candidat.CIN=:c").setParameter("c", CIN).list();
			tx.commit();
			if(candidat.isEmpty())
				return null;
			return candidat.get(0);			
		}catch(HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			return null;
		}
		
		
	}

	@Override
	public Candidat retrieve(Long id) {
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session;
		if(sessionFactory.isOpen())
			session=sessionFactory.getCurrentSession();
		else
			session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		try {
			List<Candidat> candidat=session.createQuery("from Candidat candidat where candidat.id=:id").setParameter("id", id).list();
			tx.commit();
			if(candidat.isEmpty())
				return null;
			return candidat.get(0);			
		}catch(HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			return null;
		}
	}

}
