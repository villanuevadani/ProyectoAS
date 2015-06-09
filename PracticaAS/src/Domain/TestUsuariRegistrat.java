package Domain;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestUsuariRegistrat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration config = new AnnotationConfiguration();
		
		//crear tabla de UsuariRegistrat
		/*config.addAnnotatedClass(UsuariRegistrat.class);
		config.addAnnotatedClass(Jugador.class);
		config.addAnnotatedClass(Partida.class);*/
		
		config.addAnnotatedClass(Casella.class);
		config.addAnnotatedClass(Partida.class);
		//config.addAnnotatedClass(CasellaKey.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
	
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		
		//Jugador alex = new Jugador("uname");
		/*Jugador alex = new Jugador();
		alex.setUsername("uname");
		alex.setCognom("Ramos");
		alex.setEmail("alex.ramos@email.com");
		alex.setNom("alex");
		alex.setPwd("pass");
	
		int myid = 6;
		alex.setMillorPuntuacio(7);
		session.save(alex);
		Partida pa = new Partida(12);
		Partida pa = new Partida();
		pa.setIdPartida(myid);
		pa.setJugadorPartidaActual(alex);
		
		
		session.save(pa);*/
		Partida pa = new Partida();
		pa.setIdPartida(5);
		CasellaKey ck = new CasellaKey(4,5,6);
		CasellaKey ck2 = new CasellaKey(8,9,10);
		ArrayList<Casella> n = new ArrayList<Casella>();
		
		Casella ca = new Casella();
		Casella ca2 = new Casella();
		ca.setPrimaryKEy(ck);
		ca2.setPrimaryKEy(ck2);
		n.add(ca);
		n.add(ca2);
		pa.setTabler(n);
		
	//	ca.setNumeroFila(4);
		//session.save(ck);
		session.save(pa);
		session.save(ca);
		session.save(ca2);
		session.getTransaction().commit();
		
		
		
	}

}
