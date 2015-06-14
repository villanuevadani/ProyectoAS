package Domain;

public class Tupla{
	String userN;
	double puntuacio;
	
	public Tupla(String s, double p){
		userN = s;
		puntuacio = p;
	}
	
	public String getUserN(){
		return userN;
	}
	
	public double getPuntuacio(){
		return puntuacio;
	}
}
