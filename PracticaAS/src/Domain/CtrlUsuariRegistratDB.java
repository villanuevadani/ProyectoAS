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
			System.out.println(nom);
			//ur = (UsuariRegistrat) s.get(UsuariRegistrat.class, nom);
			ur = new UsuariRegistrat();
			ur.setUsername(nom);
			ur.setNom(nom);
			ur.setCognom("1234");
			ur.setPwd("1234");
			//String username = s.createSQLQuery("SELECT USERNAME FROM USUARIREGISTRAT").getQueryString();
			System.out.println("asd");
			//System.out.println(username);
		}
		
		catch (RuntimeException exc){
			System.out.println("catch");
			s.getTransaction().rollback();
			throw new Exception("Usuari no existeix");
		}
		return ur;
	}
}
