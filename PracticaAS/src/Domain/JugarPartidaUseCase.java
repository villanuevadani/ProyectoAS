package Domain;

import java.util.Set;

public class JugarPartidaUseCase {
	private CtrlDataFactory ctrlDataFactory;
	private LoginUseCase login;
	private ConsultarRankingUseCase ranking;
	private Joc2048 joc2048;
	private Jugador jugador;
	
	public JugarPartidaUseCase(CtrlDataFactory cdf){
		ctrlDataFactory = cdf.getInstance();
		joc2048 = new Joc2048();
	}
	
	public void ferAutenticacio(String userN, String passwd) throws Exception{
		
		login = new LoginUseCase(ctrlDataFactory);
		
		login.Login(userN, passwd);
		
		UsuariRegistrat ur = ctrlDataFactory.getCtrlUsuariRegistrat().getUsuariRegistrat(userN);
		
		boolean b = ur.esJugador();
		
		if (!b) throw new Exception ("L'usuari registrat no �s jugador");
		
		jugador = (Jugador)	ur;
		
	}
	
	
	public ResultJugarPartida crearPartida(){
		
		int id = joc2048.getIdPartida();
		joc2048.setIdPartida(id+1);
		
		Partida p = new Partida(id, jugador);
		
		Set<CasAmbNum> casNum = p.casellesAmbNum();
		
		p.assignarEstrategia("BestScore");
		jugador.assignarPartida(p);
	
		int mp = jugador.getMillorPuntuacio();
		int score = p.getPuntuacio();
		
		ResultJugarPartida result = new ResultJugarPartida();
		
		result.setCasAmbNum(casNum);
		result.setMillorPuntuacio(mp);
		result.setPuntInicial(0);
		
		return result;
		
	}
}
