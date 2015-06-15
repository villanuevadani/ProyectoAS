package Domain;

import java.util.ArrayList;
import java.util.List;

public interface ICtrlJugador {
	
	public Jugador get (String nom) throws Exception;
	public List<Jugador> getAll() throws Exception;
}
