package Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
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
	
	@OneToOne
	private Jugador jugadorPartidaJugada;
	
	private Casella[][] caselles;
	
	
	Partida(){
		caselles = new Casella[4][4];
	}
	
	//aqui el creaPartida defin. en el diagrama de clases
	Partida (int id, Jugador jugador){ 
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
		estrategiaOrdenacio = j.getEstrategia();
	}
	
	public Casella getCasella(int i, int j){
		return caselles[i][j];
		}

	public int getNumCasella(int i, int j){
		return caselles[i][j].getNumero();
	}
	
	public void setNumCasella(int i, int j, int num){
		caselles[i][j].getPrimaryKey().setNumero(num);
	}
	
	public void prepararMoviment(){
		ArrayList <Casella> casellesBuides = getCasellesBuides();
		afegirNumero(casellesBuides);
	}
	
	public ArrayList<Casella> getCasellesBuides(){
		ArrayList<Casella> casellesbuides = new ArrayList<Casella>();
		
		for (int i = 0; i < 4; ++ i){
			for (int j = 0; j < 4; ++j){
				Casella cas = new Casella();
				boolean buida = caselles[i][j].getCasellaBuida(cas);
				if (buida) casellesbuides.add(cas);					
			}
		}
		
		return casellesbuides;
	}
	
	public void afegirNumero(ArrayList <Casella> casellesBuides){
		
		Random rand = new Random();
		int ncasella = rand.nextInt() % casellesBuides.size();
		Casella cas = casellesBuides.get(ncasella);
		int i = 0, j = 0, num = 0;
		cas.getInfo(i,j,num);
		
		num  = rand.nextInt()%2;
		if (num == 0) num = 2; 
		else num = 4;
		
		setNumCasella(i,j,num);
	}
	

	public void ferMoviment(String tipusMov){
		if(tipusMov.equals("esquerra")) 
		{
			for(int i = 3; i > 0; --i)
			{
				for(int j = 0; j < 4; ++j)
				{
					int num = getNumCasella(i,j);
					if(num > 0) moure(i,j,tipusMov,num);
				}
			}
		}
		else if(tipusMov.equals("dreta")) 
		{
			for(int i = 0; i < 4; ++i)
			{
				for(int j = 0; j < 4; ++j)
				{
					int num = getNumCasella(i,j);
					if(num > 0) moure(i,j,tipusMov,num);
				}
			}
		}
		else if(tipusMov.equals("amunt"))
		{
			for(int i = 0; i < 4; ++i)
			{
				for(int j = 3; j > 0; --j)
				{
					int num = getNumCasella(i,j);
					if(num > 0) moure(i,j,tipusMov,num);
				}
			}
		}
		else if(tipusMov.equals("avall"))
		{
			for(int i = 0; i < 4; ++i)
			{
				for(int j = 0; j < 4; ++j)
				{
					int num = getNumCasella(i,j);
					if(num > 0) moure(i,j,tipusMov,num);
				}
			}
		}
	}
	
	public void moure(int i, int j, String tipusMov, int num1)
	{
		int ii = 0;
		int jj = 0;
		Boolean movimentcorrecte = true;
		if(tipusMov.equals("esquerra"))
		{
			ii = i -1;
			jj = j;
		}
		else if(tipusMov.equals("dreta"))
		{
			ii = i +1;
			jj = j;
		}
		else if(tipusMov.equals("amunt"))
		{
			ii = i;
			jj = j -1;
		}
		else if(tipusMov.equals("avall"))
		{
			ii = i;
			jj = j +1;
		}
		if(i < 0 || i > 4 || j < 0 || j > 4) movimentcorrecte = false;
		if(movimentcorrecte)
		{
			int num2 = getNumCasella(ii,jj);
			if(num1 == num2)
			{
				setNumCasella(ii,jj,2*num2);
				setNumCasella(i,j,-1);
				puntuacio += 2*num2;
			}
			else if(num2 == 0)
			{
				setNumCasella(ii,jj,num1);
				setNumCasella(i,j,-1);
			}
			else moure(ii,jj,tipusMov,num1);
		}
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

		//lo del 2048 se comprueba en estaGuanyada
		
		boolean perduda = true;
		
		for (int i = 0; i < 4 && perduda; ++i){
			for (int j = 0; j < 4 && perduda; ++j){
				int num = getNumCasella(i,j);
				if (num == -1) perduda = false; //no me deja comprobar si NULL
			}
		}
		
		estaAcabada = perduda;
		return perduda;
	}
	
	public void partidaJugada(){
		jugadorPartidaActual.partidaAcabada(puntuacio, this);
	}
	
	public Set<CasAmbNum> casellesAmbNum(){
		Set<CasAmbNum> result = new HashSet<CasAmbNum>();
		
		for(int i = 0; i < 4; ++i){
			for(int j = 0; j < 4; ++j){
				int num = 0;
				boolean teNumero = caselles[i][j].getInfo(i,j,num);
				if (teNumero){
					CasAmbNum casnum = new CasAmbNum();
					casnum.setI(i);
					casnum.setJ(j);
					casnum.setNumero(num);
					result.add(casnum);
				}
			}
		}
		
		return result;
	}
}