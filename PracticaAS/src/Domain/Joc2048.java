package Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.type.Type;

@Entity
public class Joc2048 {

	private static final Joc2048 INSTANCE = new Joc2048();

	@Id
	private final int id = 2048;
	
	private int idPartida;
	
	private IEstrategiaOrdenacio estrategia;
	
	Joc2048(){
		idPartida=0;
	}
	

	public int getIdPartida() {
		Session s = null;		
		List<Joc2048> id;
		
		try{
			s = HibernateUtil.getSessionFactory().getCurrentSession();
			s.beginTransaction();
			id = s.createSQLQuery("SELECT idPartida FROM Joc2048 where id = 2048").list();
			return id.get(0).getIdPartida();
		}
		
		catch (RuntimeException exc){
			return -1;
		}
	}
	
	
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
		
		Session s = null;		
		List<Joc2048> id;
		
		try{
			s = HibernateUtil.getSessionFactory().getCurrentSession();
			s.beginTransaction();
			s.createSQLQuery("UPDATE Joc2048 SET idPartida WHERE id = 2048");
		}
		
		catch (RuntimeException exc){
		}
	}
	
	public static Joc2048 getInstance(){
		return INSTANCE;
	}
	
	public void setEstrategia(String s){
		if(s.equals("BestScore")) estrategia = new MillorPunt();
	}
	
	public ArrayList<Tupla> getRanking(ArrayList<Jugador> jugadors){
		return estrategia.getRanking(jugadors);
	}
	
}
