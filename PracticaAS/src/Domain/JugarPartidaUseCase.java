package Domain;

import java.util.ArrayList;
import java.util.Set;

public class JugarPartidaUseCase {

	private LoginUseCase login;
	private ConsultarRankingUseCase ranking;
	private Jugador jugador;
	private Partida p;
	
	public JugarPartidaUseCase(){
		System.out.println("HOLA");
	}
	
	public void ferAutenticacio(String userN, String passwd) throws Exception{
		//login = new LoginUseCase(CtrlDataFactory.getInstance());
		login = new LoginUseCase();
		
		System.out.println("bbbbb");
		
		login.Login(userN, passwd);
		
		System.out.println("ccccc");
		
		UsuariRegistrat ur = CtrlDataFactory.getCtrlUsuariRegistrat().get(userN);
		
		System.out.println("aaaa");
		
		System.out.println("aaaa" + ur.getNom());
		
		boolean b = ur.esJugador();
		System.out.println(b);
		
		if (!b) throw new Exception ("L'usuari registrat no es jugador");
		
		jugador = (Jugador)	ur;
		
		System.out.println(jugador.getPwd());

		
	}
	
	
	public ResultJugarPartida crearPartida(){
		

		int id = CtrlDataFactory.getJoc2048().getIdPartida();
		
		CtrlDataFactory.getJoc2048().setIdPartida(id+1);
		
		jugador = new Jugador();
		jugador.setEmail("german@gmail");
		jugador.setMillorPuntuacio(4);
		
		p = new Partida(id, jugador);
		
		Set<CasAmbNum> casNum = p.casellesAmbNum();
		
		System.out.println("casNum " + casNum.size());
		
		CtrlDataFactory.getJoc2048().setEstrategia("BestScore");

		jugador.assignarPartida(p);
	
		int mp = jugador.getMillorPuntuacio();
		//int score = p.getPuntuacio();
		
		ResultJugarPartida result = new ResultJugarPartida();
		
		result.setCasAmbNum(casNum);
		result.setMillorPuntuacio(mp);
		result.setPuntInicial(0);
		
		return result;
		
	}
	
	public ResultFerMovimentPartida FerMoviment(String tipusMov){
		
		ResultFerMovimentPartida result = new ResultFerMovimentPartida();
		
		p.ferMoviment(tipusMov);
		boolean guanyada = p.estaGuanyada();
		boolean perduda = false;
		if (!guanyada) perduda = p.estaPerduda();
		
		result.setEstaAcabada(guanyada || perduda);
		
		result.setEstaPerduda(perduda);

		if (!result.isEstaAcabada()) p.prepararMoviment();
		System.out.println("Ara hi ha " + p.casellesAmbNum().size() + " amb n");
		result.setCasellesAmbNumero(p.casellesAmbNum());
		
		result.setPuntuacio(p.getPuntuacio());
				
		//if (result.isEstaAcabada()) p.partidaJugada();

		//if (result.isEstaAcabada()) p.partidaJugada(); HAY QUE DESCOMENTARLO!!

		
		return result;
			
	}
	
	public ArrayList<Tupla> obtenirRanking() throws Exception{
		ranking = new ConsultarRankingUseCase();
		return ranking.consultarRanking();
	}
}
