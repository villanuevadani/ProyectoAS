package Domain;

import java.util.ArrayList;

public class ConsultarRankingUseCase {
	private Joc2048 joc;
	
	public ConsultarRankingUseCase(Joc2048 j){
		joc = j;
	}
	
	public ArrayList<Tupla> consultarRanking(){
		CtrlDataFactory.getCtrlJugador().getAll();
		
		ArrayList<Tupla> ranking = joc.getRanking(/*jugadors*/);
		
		return ranking;
	}

}
