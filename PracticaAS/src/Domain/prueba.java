package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class prueba{
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		
		config.addAnnotatedClass(Hospital.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		
		/*SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();*/
		
		Hospital hosp = new Hospital("SantPau");
		hosp.setAdreca("Madrid");
		hosp.setNom("UB Hospital");
		hosp.setDescripcio("hospital universitari");
		
		hosp.afegirHabitacio(new Habitacio(1));
		hosp.afegirHabitacio(new Habitacio(345));

		System.out.println("L'hospital es diu " + hosp.getNom());
		System.out.println("L'adreça es " + hosp.getAdreca() + " i la descripcio es " + hosp.getDescripcio());
		System.out.println("L'hospital te ara mateix " + hosp.getHabitacions().size() + " habitacions");
		int hab1;
		System.out.print("Els numeros de les habitacions son ");
		for (int i = 0; i < hosp.getHabitacions().size(); ++i) {
			hab1 = hosp.getHabitacions().get(i).getNumero();
			System.out.print(hab1 + " ");
		}
		hosp.getHabitacions().get(0).setNumero(234);
		System.out.println("Ara l'habitacio 1 passa a ser la " + hosp.getHabitacions().get(0).getNumero());
		hosp.esborrarHabitacio(345);
		
		System.out.println("L'hospital te ara mateix " + hosp.getHabitacions().size() + " habitacions");
		System.out.print("Els numeros de les habitacions son ");
		for (int i = 0; i < hosp.getHabitacions().size(); ++i) {
			hab1 = hosp.getHabitacions().get(i).getNumero();
			System.out.print(hab1 + " ");
		}
		//session.save(hosp);
		//session.getTransaction().commit();
		
		
	}
}
