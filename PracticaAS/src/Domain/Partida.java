package Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Partida  {
	private int idPartida;
	private boolean estaAcabada;
	private boolean estaGuanyada;
	private int puntuacio;
	
	private String estrategiaOrdenacio;
	
	@OneToOne
	private Jugador jugadorPartidaActual;
	
	@ManyToOne
	private Jugador jugadorPartidaJugada;
	
	private Casella[][] caselles;
	
	
	Partida(){
		caselles = new Casella[4][4];
	}
	
	//aqui el creaPartida defin. en el diagrama de clases
	Partida (int id, Jugador jugador){ 
		//TODO
		idPartida = id+1;
		puntuacio = 0;
		estaGuanyada = false;
		estaAcabada = false;
		int cont;
		
		caselles = new Casella[4][4];
		
		for (cont = 0; cont < 16; ++cont){
			caselles[cont/4][cont%4] = new Casella(cont);		
		}
		
		prepararMoviment();
		prepararMoviment();
		
		jugadorPartidaActual = jugador;
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

	public boolean estaGuanyada() {
		return estaGuanyada = true;
	}
	
	public boolean estaPerduda(){
		return (estaAcabada && !estaGuanyada);
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
	public Casella[][] getCaselles() {
		return caselles;
	}

	public void setCaselles(Casella[][] caselles) {
		this.caselles = caselles;
	}

	public void addCasella(Casella c){
		c.getPrimaryKey();
	}
	
	public void assignarEstrategia(String s){
		estrategiaOrdenacio = s;
	}
	
	public Casella getCasella(int i, int j){
		return caselles[i][j];
	}
	
	public void prepararMoviment(){
		//TODO
	}
	
	public void partidaJugada(){
		//TODO
	}
	
	public Set<CasAmbNum> casellesAmbNum(){
		//TODO
	}
}