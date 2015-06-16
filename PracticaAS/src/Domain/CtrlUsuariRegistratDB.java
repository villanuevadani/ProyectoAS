package Domain;

import org.hibernate.Session;

public class CtrlUsuariRegistratDB implements ICtrlUsuariRegistrat {

	@Override
	public UsuariRegistrat get (String nom) throws Exception{
		Session s = null;
		UsuariRegistrat ur = null;
		
		try{			
			s = HibernateUtil.getSessionFactory().getCurrentSession();
			s.beginTransaction();
			ur = new UsuariRegistrat();
			ur.setUsername(nom);
			ur.setNom(nom);
			ur.setCognom("1234");
			ur.setPwd("1234");
		}
		
		catch (Exception exc){
			System.out.println(exc.getMessage());
		}
		return ur;
	}
}
