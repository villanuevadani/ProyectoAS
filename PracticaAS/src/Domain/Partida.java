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
	
	public void assignarEstrategia(Jugador j){
		estrategiaOrdenacio = j.estrategia;
	}
	
	public Casella getCasella(int i, int j){
		return caselles[i][j];
		}

	public int getNumCasella(int i, int j){
		return caselles[i][j].getNumero();
	}
	
	public void prepararMoviment(){
		//TODO
	}
	
	public void ferMoviment(String tipusMov){
		//TODO
	}
	
	public boolean estaGuanyada() {
	
		boolean surt2048 = false;
		for (int i = 0; i < 4 && !surt2048; ++i){
			for (int j = 0; j < 4 && !surt2048; ++j){
				int num = getNumCasella(i, j);
				surt2048 = (num == 2048);
			}
		}
	
		estaAcabada = estaGuanyada = surt2048;
		
		//Falta enviar mensaje si estaGuanyada
		
		return estaGuanyada;
	}
	
	public boolean estaPerduda(){
		
		//como se supone que se comprueba
		//lo del 2048 en el estaGuanyada
		//no hace falta volver a comprobarlo aqui
		
		boolean perduda = true;
		
		for (int i = 0; i < 4 && perduda; ++i){
			for (int j = 0; j < 4 && perduda; ++j){
				int num = getNumCasella(i,j);
				if (num%2 != 0) perduda = false; //no me deja comprobar si NULL
			}
		}
		
		estaAcabada = perduda;
		return perduda;
	}
	
	public void partidaJugada(){
		//TODO
	}
	
	public Set<CasAmbNum> casellesAmbNum(){
		//TODO
	}
}