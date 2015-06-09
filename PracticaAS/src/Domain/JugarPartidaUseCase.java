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
		
		if (!b) throw new Exception ("L'usuari registrat no és jugador");
		
		jugador = (Jugador)	ur;
		
	}
	
	
	public void crearPartida(){
		
		int id = joc2048.getIdPartida();
		joc2048.setIdPartida(id+1);
		
		Partida p = new Partida(id, jugador);
		
		Set<CasAmbNum> casNum = p.casellesAmbNum();
		
		
	}
}
