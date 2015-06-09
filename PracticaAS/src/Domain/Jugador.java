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
	private int millorPuntuacio;
	
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
	
}
