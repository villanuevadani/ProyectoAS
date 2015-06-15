package Domain;

import java.util.ArrayList;
import java.util.List;

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
	
	public List <Jugador> getAll() throws Exception{
		Session s = null;
		try{
			s = HibernateUtil.getSessionFactory().getCurrentSession();
			List<Jugador> totsJugadors;
			s.beginTransaction();
			totsJugadors = s.createSQLQuery("SELECT * FROM Jugadors").list();
			if(totsJugadors.size() > 0) return totsJugadors;
			return null;
			
		}
		
		catch(Exception e){
			throw e;
		}
	}

}
