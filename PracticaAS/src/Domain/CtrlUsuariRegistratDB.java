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
			ur = (Jugador) s.get(UsuariRegistrat.class, nom);
		}
		
		catch (RuntimeException exc){
			s.getTransaction().rollback();
			throw new Exception("Usuari no existeix");
		}
		return ur;
	}
}
