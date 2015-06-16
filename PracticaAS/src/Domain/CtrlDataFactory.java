package Domain;

public class CtrlDataFactory {
	private static CtrlDataFactory instance = null;
	private static ICtrlJugador ctrlJugador = null;
	private static ICtrlPartida ctrlPartida = null;
	private static ICtrlUsuariRegistrat ctrlUsReg = null;
	
	public CtrlDataFactory(){
	}
	
	public static CtrlDataFactory getInstance(){
		
		if (instance == null) instance = new CtrlDataFactory();
		return instance;
	}
	
	public static ICtrlJugador getCtrlJugador(){
		if (ctrlJugador == null) ctrlJugador = new CtrlJugadorDB();
		return ctrlJugador;
	}
	
	public static ICtrlPartida getCtrlPartida(){
		if (ctrlPartida == null) ctrlPartida = new CtrlPartidaDB();
		return ctrlPartida;
	}

	public static ICtrlUsuariRegistrat getCtrlUsuariRegistrat() {
		if (ctrlUsReg == null) ctrlUsReg = new CtrlUsuariRegistratDB();
		return ctrlUsReg;
	}
	
	public static Joc2048 getJoc2048(){
		return Joc2048.getInstance();
	}
	
}
