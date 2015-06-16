package Domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreacionDB {
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
		

		/*UsuariRegistrat us = new UsuariRegistrat("villanuevadani");
		us.setNom("Daniel");
		us.setCognom("Villanueva");
		us.setPwd("davi");
		
		session.save(us);
				
		UsuariRegistrat us2 = new UsuariRegistrat("gutierrezgerman");
		us2.setNom("German");
		us2.setCognom("Gutierrez");
		us2.setPwd("gegu");
		
		session.save(us2);
		
		UsuariRegistrat us3 = new UsuariRegistrat("semirajazzey");
		us3.setNom("Jazzey");
		us3.setCognom("Semira");
		us3.setPwd("jase");
		
		session.save(us3);*/
		
		UsuariRegistrat us4 = new UsuariRegistrat("1234");
		us4.setNom("1234");
		us4.setCognom("1234");
		us4.setPwd("1234");
		
		session.save(us4);
		
		/*Jugador j = new Jugador("gutierrezgerman");
		j.setPwd("German");
		session.save(j);*/
		
		Jugador j2 = new Jugador("4321");
		session.save(j2);
		
		Joc2048 ju = new Joc2048();
		ju.setIdPartida(2048);

		
		Partida p = new Partida();
		p.setEstaAcabada(true);
		p.setEstaGuanyada(true);
		p.setIdPartida(2048);
		

		
		session.save(ju);

		session.save(p);
		
		session.getTransaction().commit();
		
		factory = config.buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();
		UsuariRegistrat ur = (UsuariRegistrat) session.get(UsuariRegistrat.class, "villa");
		//System.out.println(ur.getPwd());
	}

}
