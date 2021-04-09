package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helper.HibernateConfig;
import interfaces.IUser;
import model.User;

public class DaoUser implements IUser{
	
	private Session session;
	private Transaction transaction = null;
	public DaoUser() {
		this.session = HibernateConfig.getSessionFactory().openSession();
	}

	@Override
	public void addUser(User u) {
		try {
			transaction = this.session.beginTransaction();
			
			this.session.save(u);
			
			transaction.commit();
			
			this.session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getOneUser(String email, String password) {
		User u = null;
		try{
			transaction = this.session.beginTransaction();
			
			
			Query q = this.session.createQuery("from user u where u.email=:email and u.password=:password",User.class);
			
					q.setParameter("email", email);
					q.setParameter("password", password);
					
			//we use the stream API to get the first 
			u = (User)	q.getResultList().stream().findFirst().orElse(null);
			
			transaction.commit();
		}catch (Exception e) {
			u = null;
		}
		
		return u;
	}

}
