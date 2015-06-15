package Domain;

import java.util.ArrayList;
import java.util.List;

public class ConsultarRankingUseCase {
	private Joc2048 joc;
	
	public ConsultarRankingUseCase(Joc2048 j){
		joc = j;
	}
	
	public ArrayList<Tupla> consultarRanking() throws Exception{
		List<Jugador> list = CtrlDataFactory.getCtrlJugador().getAll();
		ArrayList<Jugador> jugadors = new ArrayList<Jugador>(list);
		ArrayList<Tupla> ranking = joc.getRanking(jugadors);
		
		return ranking;
	}

}
