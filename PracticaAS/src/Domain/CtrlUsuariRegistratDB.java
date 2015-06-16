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
			ur = (UsuariRegistrat) s.get(UsuariRegistrat.class, nom);
			System.out.println("asd" + ur.getNom());
		}
		
		catch (RuntimeException exc){
			System.out.println("catch");
			s.getTransaction().rollback();
			throw new Exception("Usuari no existeix");
		}
		return ur;
	}
}
