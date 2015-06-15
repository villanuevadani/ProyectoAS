package Domain;

import javax.persistence.Id;
import java.util.ArrayList;

public class Joc2048 {

	private static final Joc2048 INSTANCE = new Joc2048();

	private int idPartida;
	
	private IEstrategiaOrdenacio estrategia;
	
	Joc2048(){
		idPartida=0;
	}
	@Id
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
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
