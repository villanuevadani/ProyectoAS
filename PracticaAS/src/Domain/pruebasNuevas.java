package Domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class pruebasNuevas {
	public static void main(String[] args){
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(UsuariRegistrat.class);
		config.addAnnotatedClass(Joc2048.class);
		config.addAnnotatedClass(Partida.class);
		//config.addAnnotatedClass(Jugador.class);
		//config.addAnnotatedClass(Casella.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		UsuariRegistrat us = new UsuariRegistrat("villa4");
		us.setNom("Daniel");
		us.setCognom("Villanueva");
		
		
		
		session.save(us);
		session.getTransaction().commit();
		
	}

}
