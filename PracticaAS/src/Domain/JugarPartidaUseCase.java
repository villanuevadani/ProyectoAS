package Domain;

import java.util.ArrayList;
import java.util.Set;

public class JugarPartidaUseCase {
	//private CtrlDataFactory ctrlDataFactory;
	private LoginUseCase login;
	private ConsultarRankingUseCase ranking;
	private Joc2048 joc2048;
	private Jugador jugador;
	
	public JugarPartidaUseCase(CtrlDataFactory cdf){
		//ctrlDataFactory = cdf.getInstance();
		joc2048 = new Joc2048();
	}
	
	public void ferAutenticacio(String userN, String passwd) throws Exception{
		
		//login = new LoginUseCase(CtrlDataFactory.getInstance());
		login = new LoginUseCase();
		
		login.Login(userN, passwd);
		
		UsuariRegistrat ur = CtrlDataFactory.getCtrlUsuariRegistrat().get(userN);
		
		boolean b = ur.esJugador();
		
		if (!b) throw new Exception ("L'usuari registrat no es jugador");
		
		jugador = (Jugador)	ur;
		
	}
	
	
	public ResultJugarPartida crearPartida(){
		
		int id = joc2048.getIdPartida();
		joc2048.setIdPartida(id+1);
		
		Partida p = new Partida(id, jugador);
		
		Set<CasAmbNum> casNum = p.casellesAmbNum();
		
		joc2048.setEstrategia("BestScore");

		jugador.assignarPartida(p);
	
		int mp = jugador.getMillorPuntuacio();
		int score = p.getPuntuacio();
		
		ResultJugarPartida result = new ResultJugarPartida();
		
		result.setCasAmbNum(casNum);
		result.setMillorPuntuacio(mp);
		result.setPuntInicial(0);
		
		return result;
		
	}
	
	public void FerMoviment(Partida p, String tipusMov){
		
		ResultFerMovimentPartida result = new ResultFerMovimentPartida();
		
		p.ferMoviment(tipusMov);
		boolean guanyada = p.estaGuanyada();
		boolean perduda = false;
		if (!guanyada) perduda = p.estaPerduda();
		
		result.setEstaAcabada(guanyada || perduda);
		
		result.setEstaPerduda(perduda);

		if (!result.isEstaAcabada()) p.prepararMoviment();
		
		result.setCasellesAmbNumero(p.casellesAmbNum());
		
		result.setPuntuacio(p.getPuntuacio());
				
		if (result.isEstaAcabada()) p.partidaJugada();
			
	}
	
	public ArrayList<Tupla> obtenirRanking() throws Exception{
		ranking = new ConsultarRankingUseCase(joc2048);
		return ranking.consultarRanking();
	}
}
