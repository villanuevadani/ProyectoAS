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
		
		Jugador j = new Jugador("villa");		
		j.setPwd("1234");
		j.setEmail("danielvillanueva");
		session.save(j);
		
		Joc2048 j2 = new Joc2048();
		j2.setIdPartida(2048);
		session.save(j2);
		
		Partida p = new Partida();
		p.setEstaAcabada(true);
		p.setEstaGuanyada(true);
		p.setIdPartida(2048);
		

		session.save(p);
		
		session.getTransaction().commit();
		
		factory = config.buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();
		UsuariRegistrat ur = (UsuariRegistrat) session.get(UsuariRegistrat.class, "villa");
		System.out.println(ur.getPwd());
	}

}
