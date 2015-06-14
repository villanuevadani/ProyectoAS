package Domain;

import java.util.ArrayList;

public class ConsultarRankingUseCase {

	public ArrayList<Tupla> consultarRanking(){
		CtrlDataFactory.getCtrlJugador().getAll();
		//getRanking(jugadors) a EstrategiaOrdenacio
		
		//retornar el ranking
	}

}
