package Domain;

import java.util.ArrayList;
import java.util.List;

public class ConsultarRankingUseCase {
	
	public ConsultarRankingUseCase(){
		
	}
	
	public ArrayList<Tupla> consultarRanking() throws Exception{
		List<Jugador> list = CtrlDataFactory.getCtrlJugador().getAll();
		ArrayList<Jugador> jugadors = new ArrayList<Jugador>(list);
		ArrayList<Tupla> ranking = CtrlDataFactory.getJoc2048().getRanking(jugadors);
		
		return ranking;
	}

}
