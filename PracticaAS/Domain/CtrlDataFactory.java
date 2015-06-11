package Domain;

public class CtrlDataFactory {
	private static final CtrlDataFactory INSTANCE = new CtrlDataFactory();
	private static CtrlJugador ctrlJugador;
	private static CtrlPartida ctrlPartida;
	private static CtrlUsuariRegistrat ctrlUsReg;
	
	public CtrlDataFactory(){
		ctrlJugador = new CtrlJugador();
		ctrlPartida = new CtrlPartida();
		ctrlUsReg = new CtrlUsuariRegistrat();
	}
	
	public static CtrlDataFactory getInstance(){
		return INSTANCE;
	}
	
	public static CtrlJugador getCtrlJugador(){
		return ctrlJugador;
	}


	
	public static CtrlPartida getCtrlPartida(){
		return ctrlPartida;
	}

	public static CtrlUsuariRegistrat getCtrlUsuariRegistrat() {
		return ctrlUsReg;
	}
	
	
}
