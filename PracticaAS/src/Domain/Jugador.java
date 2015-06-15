package Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
public class Jugador extends UsuariRegistrat implements Serializable {
	
	private String email;
	
	@Column
	private int millorPuntuacio; 
	
	@Column
	private String estrategia;
	
	@OneToOne
	private Partida partidaActual;
	
	@ManyToOne
	private ArrayList<Partida> partidasJugadas;
	
	Jugador(){
		super();
		partidasJugadas = new ArrayList<Partida>();
		millorPuntuacio = -1;
	}
	
	Jugador(String uname) {
		super(uname);
		partidasJugadas = new ArrayList<Partida>();
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

	@Id
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

	public ArrayList<Partida> getPartidasJugadas() {
		return partidasJugadas;
	}

	public void setPartidasJugadas(ArrayList<Partida> partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}
	
	public void addPartida(Partida c){
		partidasJugadas.add(c);
	}
	
	public Partida getPartida(int i){
		return partidasJugadas.get(i);
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
	
	public Tupla obteTuplaMillor(){
		String s = getUsername();
		double p = getMillorPuntuacio();
		return new Tupla(s,p);
	}
	
	public Tupla obteTuplaMitjana(){
		String s = getUsername();
		double p = getMitjaPuntuacio();
		return new Tupla(s,p);
	}
	
	public void partidaAcabada(int punt, Partida p){
		partidaActual = null;
		partidasJugadas.add(p);
		if (punt > millorPuntuacio) millorPuntuacio = punt;	
	}
}
