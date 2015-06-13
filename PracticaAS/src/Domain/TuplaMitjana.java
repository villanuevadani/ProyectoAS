package Domain;

public class TuplaMitjana extends Tupla{
	double puntuacio;
	
	public TuplaMitjana(String s, double p){
		super(s);
		puntuacio = p;
	}
	
	double getPuntuacio(){
		return puntuacio;
	}
}
