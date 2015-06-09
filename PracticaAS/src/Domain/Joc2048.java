package Domain;

import javax.persistence.Id;

public class Joc2048 {

	private int idPartida;
	
	Joc2048(int idP){
		idPartida=idP;
	}
	@Id
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
}
