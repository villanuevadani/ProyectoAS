package Domain;

import org.hibernate.Session;

public class CtrlUsuariRegistratDB implements ICtrlUsuariRegistrat {

	@Override
	public UsuariRegistrat get (String nom) throws Exception{
		System.out.println("benzema");
		Session s = null;
		UsuariRegistrat ur = null;
		
		try{
			System.out.println("try");
			s = HibernateUtil.getSessionFactory().getCurrentSession();
			s.beginTransaction();
			//System.out.println(nom);
			ur = (UsuariRegistrat)s.createQuery("from UsuariRegistrat where USERNAME = '" + nom + "'").uniqueResult();
			if (ur == null) throw new Exception("no coge el elemento");
			System.out.println("asd" + ur.getNom());
			System.out.println("asd" + ur.getPwd());
		}
		
		catch (Exception exc){
			//System.out.println("catch");
			//s.getTransaction().rollback();
			//throw new Exception("Usuari no existeix");
			System.out.println(exc.getMessage());
		}
		return ur;
	}
}
