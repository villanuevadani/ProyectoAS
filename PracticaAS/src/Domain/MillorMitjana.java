package Domain;
import java.util.ArrayList;
public class MillorMitjana implements IEstrategiaOrdenacio{

	@Override
	public ArrayList<Tupla> getRanking(ArrayList<Jugador> jugadors) {
		ArrayList<Tupla> result = new ArrayList<Tupla>();
		for(Jugador j : jugadors){
			TuplaMitjana t = j.obteTuplaMitjana();
			if(t.getPuntuacio()!=-1) result.add(t);
		}
		return result;
	}

}
