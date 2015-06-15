package Domain;

public class Tupla{
	String userN;
	int puntuacio;
	
	public Tupla(String s, int p){
		userN = s;
		puntuacio = p;
	}
	
	public String getUserN(){
		return userN;
	}
	
	public int getPuntuacio(){
		return puntuacio;
	}
}
