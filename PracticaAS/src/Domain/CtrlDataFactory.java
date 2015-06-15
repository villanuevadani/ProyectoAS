package Domain;

public class CtrlDataFactory {
	private static CtrlDataFactory instance;
	private static ICtrlJugador ctrlJugador;
	private static ICtrlPartida ctrlPartida;
	private static ICtrlUsuariRegistrat ctrlUsReg;
	private static ICtrlJoc ctrlJoc;
	
	//faltaria el ADAPTER MISSATGE, lo dejamos apra
	//+ adelante
	
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
	
	public static ICtrlJoc getCtrlJoc(){
		if(ctrlJoc == null) ctrlJoc = new CtrlJoc();
		return ctrlJoc;
	}
	
	
}
