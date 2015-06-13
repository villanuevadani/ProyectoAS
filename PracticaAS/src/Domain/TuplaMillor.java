package Domain;

public class TuplaMillor extends Tupla {
	int puntuacio;
	
	public TuplaMillor(String s, int p){
		super(s);
		puntuacio = p;
	}
	
	int getPuntuacio(){
		return puntuacio;
	}
}
