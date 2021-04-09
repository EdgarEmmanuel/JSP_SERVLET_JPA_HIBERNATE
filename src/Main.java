import org.hibernate.Session;

import helper.HibernateConfig;

public class Main {
	public static void main(String[] args) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		
	}
}
