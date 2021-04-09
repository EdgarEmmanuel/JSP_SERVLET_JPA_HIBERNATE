package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helper.HibernateConfig;
import interfaces.ISpecialite;
import model.Specialite;
import model.User;

public class DaoSpecialite implements ISpecialite {
	private Session session;
	private Transaction transaction = null;
	
	public DaoSpecialite() {
		this.session = HibernateConfig.getSessionFactory().openSession();
	}

	@Override
	public int insertOneSpecialite(Specialite specialite) {
		int val = 0;
		try {
			transaction = this.session.beginTransaction();
			
			this.session.save(specialite);
			
			transaction.commit();
			val = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return val;
	}

	@Override
	public Specialite getOneSpeById(int id) {
		Specialite spe = null;
		
		try {
			
			transaction = this.session.beginTransaction();
			
			Query q = this.session.createQuery("from specialite s where s.id=:id",Specialite.class);
			q.setParameter("id", id);
			
			spe = (Specialite) q.getResultList().parallelStream().findFirst().orElse(null);
			
			transaction.commit();
			
		} catch (Exception e) {
			spe = null;
		}
		
		return spe;
	}

}
