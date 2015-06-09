package Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Partida  {
	private int idPartida;
	private boolean estaAcabada;
	private boolean estaGuanyada;
	private int puntuacio;
	private Jugador jugadorPartidaActual;
	private Jugador jugadorPartidaJugada;
	
	@ManyToOne
	private Vector<Casella> caselles;
	
	
	Partida(){
		caselles = new Vector<Casella>();
	}

	@Id
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public boolean isEstaAcabada() {
		return estaAcabada;
	}

	public void setEstaAcabada(boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}

	public boolean isEstaGuanyada() {
		return estaGuanyada;
	}

	public void setEstaGuanyada(boolean estaGuanyada) {
		this.estaGuanyada = estaGuanyada;
	}

	public int getPuntuacio() {
		return puntuacio;
	}

	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}

	public Jugador getJugadorPartidaActual() {
		return jugadorPartidaActual;
	}

	public void setJugadorPartidaActual(Jugador jugadorPartidaActual) {
		this.jugadorPartidaActual = jugadorPartidaActual;
	}

	public Jugador getJugadorPartidaJugada() {
		return jugadorPartidaJugada;
	}

	public void setJugadorPartidaJugada(Jugador jugadorPartidaJugada) {
		this.jugadorPartidaJugada = jugadorPartidaJugada;
	}
	public Vector<Casella> getCaselles() {
		return caselles;
	}

	public void setCaselles(Vector<Casella> caselles) {
		this.caselles = caselles;
	}

	public void addCasella(Casella c){
		caselles.addElement(c);
	}
	
	public Casella getCasella(int i){
		return caselles.elementAt(i);
	}
	
	public int getSizeCaselles(){
		return caselles.size();
	}

	
}