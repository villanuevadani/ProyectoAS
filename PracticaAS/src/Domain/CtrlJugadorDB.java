package Domain;

import org.hibernate.Session;


public class CtrlJugadorDB implements ICtrlJugador {
	
	@Override
	public Jugador get (String nom) throws Exception{
		Session s = null;
		Jugador j = null;
		
		try{
			s = HibernateUtil.getSessionFactory().getCurrentSession();
			s.beginTransaction();
			j = (Jugador) s.get(Jugador.class, nom);
		}
		
		catch (RuntimeException exc){
			s.getTransaction().rollback();
			throw new Exception("Jugador no existeix");
		}
		return j;
	}

}
