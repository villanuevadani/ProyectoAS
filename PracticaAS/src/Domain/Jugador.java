package Domain;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
public class Jugador extends UsuariRegistrat implements Serializable {
	
	private String email;
	private int millorPuntuacio; //??? aixo no es calcula?
	
	private String estrategia;
	
	@OneToOne
	private Partida partidaActual;
	
	@ManyToOne
	private Vector<Partida> partidasJugadas;
	
	Jugador(){
		super();
		partidasJugadas = new Vector<Partida>();
	}
	
	Jugador(String uname) {
		super(uname);
		partidasJugadas = new Vector<Partida>();
	}
	
	public Partida getPartidaActual() {
		return partidaActual;
	}
	
	public void assignarPartida(Partida p){
		partidaActual = p;
	}

	public void setPartidaActual(Partida partidaActual) {
		this.partidaActual = partidaActual;
	}


	public String getEmail() {
		return email;
	}
	 
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getMillorPuntuacio() {
		return millorPuntuacio;
		/*  int n=-1;
		    for(Partida pa : partidasJugadas){
				int a = pa.getPuntuacio();
				if(n < a) n = a;
			}
			return p;
		 */
	}
	
	public double getMitjaPuntuacio(){
		double p = -1;
		for(Partida pa : partidasJugadas){
			int a = pa.getPuntuacio();
			if(p == -1) p = a;
			else p+=a;
		}
		if(p!=-1) p/=partidasJugadas.size();
		return p;
	}

	public void setMillorPuntuacio(int millorPuntuacio) {
		this.millorPuntuacio = millorPuntuacio;
	}

	public Vector<Partida> getPartidasJugadas() {
		return partidasJugadas;
	}

	public void setPartidasJugadas(Vector<Partida> partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}
	
	public void addPartida(Partida c){
		partidasJugadas.addElement(c);
	}
	
	public Partida getPartida(int i){
		return partidasJugadas.elementAt(i);
	}
	
	public int getSizePartidasJugadas(){
		return partidasJugadas.size();
	}
	
	public boolean esJugador(){
		return true;
	}
	
	public String getEstrategia(){
		return estrategia;
	}
	
	public void canviarEstrategiaOrdenacio(){
		if(estrategia.equals("BestScore")) estrategia = "BestMean";
		else estrategia = "BestScore";
	}
	
	public TuplaMillor obteTuplaMillor(){
		String s = getUsername();
		int p = getMillorPuntuacio();
		return new TuplaMillor(s,p);
	}
	
	public TuplaMitjana obteTuplaMitjana(){
		String s = getUsername();
		double p = getMitjaPuntuacio();
		return new TuplaMitjana(s,p);
	}
}
