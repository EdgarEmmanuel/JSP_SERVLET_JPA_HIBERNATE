package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helper.HibernateConfig;
import interfaces.IDemandeur;
import model.Demandeur;

public class DaoDemandeur implements IDemandeur {
	
	private Session session;
	private Transaction transaction = null;
	public DaoDemandeur() {
		this.session = HibernateConfig.getSessionFactory().openSession();
	}

	@Override
	public Demandeur GetOneDemandeur(int id) {
		Demandeur d = null;
		
		try {
			transaction = this.session.beginTransaction();
			Query q = this.session.createQuery("from demandeur_emploi d where d.user.id = :id",Demandeur.class);
			q.setParameter("id", id);
			
			d = (Demandeur) q.getResultList().stream().findFirst().orElse(null);
			transaction.commit();
			
		} catch (Exception e) {
			//e.printStackTrace();
			d = null;
		}
		
		return d;
	}
	
}
