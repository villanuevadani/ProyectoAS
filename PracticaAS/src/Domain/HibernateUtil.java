package Domain;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sf;
	
	static {
		try {
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		}
		catch (Throwable exc) {
			System.err.println("Error al crear la session factory" + exc);
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}