package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helper.HibernateConfig;
import interfaces.ICv;
import model.Cv;
import model.NiveauEtudes;
import model.Specialite;

public class CvImpl implements ICv {
	private Session session;
	private Transaction transaction = null;
	private DaoSpecialite daoSpecialite;
	public CvImpl() {
		this.daoSpecialite = new DaoSpecialite();
		this.session = HibernateConfig.getSessionFactory().openSession();
	}

	@Override
	public Cv getOneCvById(int id) {
		Cv cv = null;
		try {
			transaction = this.session.beginTransaction();
			
			Query q = this.session.createQuery("from cv c where c.id = :id",Cv.class);
			q.setParameter("id", id);
			
			cv = (Cv) q.getResultList().stream().findFirst().orElse(null);
			
			transaction.commit();
		} catch (Exception e) {
			cv = null;
		}
		return cv;
	}

}
