package helper;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Cv;
import model.Demandeur;
import model.DescriptionCv;
import model.Entreprise;
import model.ExperienceProf;
import model.NiveauEtudes;
import model.Offre;
import model.Realisation;
import model.Role;
import model.Specialite;
import model.User;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	
	
	public static void openFactory() {
		if(sessionFactory==null) {
			sessionFactory.openSession();
		}
	}

	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/search_job_platform?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	    settings.put(Environment.USER, "root");
	    settings.put(Environment.PASS, "");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

	    settings.put(Environment.SHOW_SQL, "true");
	    settings.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS,"true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	    settings.put(Environment.HBM2DDL_AUTO, "update");

	    configuration.setProperties(settings);
	    //set the name of all class
	    configuration.addAnnotatedClass(User.class);
	    configuration.addAnnotatedClass(Role.class);
	    configuration.addAnnotatedClass(Cv.class);
	    configuration.addAnnotatedClass(Demandeur.class);
	    configuration.addAnnotatedClass(DescriptionCv.class);
	    configuration.addAnnotatedClass(Entreprise.class);
	    configuration.addAnnotatedClass(ExperienceProf.class);
	    configuration.addAnnotatedClass(NiveauEtudes.class);
	    configuration.addAnnotatedClass(Offre.class);
	    configuration.addAnnotatedClass(Realisation.class);
	    configuration.addAnnotatedClass(Specialite.class);
	    

	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
	
	
	public static void closeSession() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
		
	}

}
