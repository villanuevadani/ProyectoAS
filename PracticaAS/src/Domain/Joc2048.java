package Domain;

import javax.persistence.Id;

public class Joc2048 {

	private static final Joc2048 INSTANCE = new Joc2048();

	private int idPartida;
	
	Joc2048(){
		idPartida=0;
	}
	@Id
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	
	public static Joc2048 getInstance(){
		return INSTANCE;
	}
}
