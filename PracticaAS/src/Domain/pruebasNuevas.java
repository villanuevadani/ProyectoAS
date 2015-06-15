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
		config.addAnnotatedClass(Jugador.class);
		//config.addAnnotatedClass(Casella.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		UsuariRegistrat us = new UsuariRegistrat("villanuevadani");
		us.setNom("Daniel");
		us.setCognom("Villanueva");
		us.setPwd("davi");
				
		UsuariRegistrat us2 = new UsuariRegistrat("gutierrezgerman");
		us.setNom("German");
		us.setCognom("Gutierrez");
		us.setPwd("gegu");
		
		UsuariRegistrat us3 = new UsuariRegistrat("semirajazzey");
		us.setNom("Jazzey");
		us.setCognom("Semira");
		us.setPwd("jase");
		
		Joc2048 j2 = new Joc2048();
		j2.setIdPartida(2048);
		
		Partida p = new Partida();
		p.setEstaAcabada(true);
		p.setEstaGuanyada(true);
		p.setIdPartida(2048);
		
		
		session.save(us2);
		session.save(us3);
		session.save(us);
		session.save(j2);
		session.save(p);
		session.getTransaction().commit();
		
	}

}
