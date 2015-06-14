package Domain;

import java.util.ArrayList;

public interface ICtrlJugador {
	
	public Jugador get (String nom) throws Exception;
	public ArrayList <Jugador> getAll();
}
