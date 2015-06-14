package Domain;
import java.util.ArrayList;
public class MillorPunt  implements IEstrategiaOrdenacio{
	@Override
	public ArrayList<Tupla> getRanking(ArrayList<Jugador> jugadors) {
		ArrayList<Tupla> result = new ArrayList<Tupla>();
		for(Jugador j : jugadors){
			Tupla t = j.obteTuplaMillor();
			if(t.getPuntuacio()!=-1) result.add(t);
		}
		result.sort(new TuplaComparator());
		return result;
	}

}
