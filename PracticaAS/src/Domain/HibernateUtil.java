package Domain;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static  SessionFactory sf;
	
	private static void createSessionFactory(){
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		}
	
	public static SessionFactory getSessionFactory() {
		if (sf == null) createSessionFactory();
		return sf;
	}
}