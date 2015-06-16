package Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
public class Partida {
	private int idPartida;
	
	@Column
	private boolean estaAcabada;
	@Column
	private boolean estaGuanyada;
	@Column
	private int puntuacio;
	
	@Column
	@OneToOne(fetch=FetchType.EAGER, mappedBy="partidaActual", targetEntity = Jugador.class)
	private Jugador jugadorPartidaActual;
	
//	@ManyToOne(fetch=FetchType.EAGER, mappedBy="partidasJugadas", targetEntity = Jugador.class)
	@Column
	@ManyToOne
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
	
	public boolean isEstaGuanyada(){
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
	}
	
	public Casella getCasella(int i, int j){
		return caselles[i][j];
		}

	public int getNumCasella(int i, int j){
		return caselles[i][j].getN();
	}
	
	public void setNumCasella(int i, int j, int num){
		Casella c = caselles[i][j];
		CasellaKey k = c.getPrimaryKey();
		k.setNumero(num);
		caselles[i][j] = c;
	}
	
	public void prepararMoviment(){
		ArrayList <Casella> casellesBuides = getCasellesBuides();
		afegirNumero(casellesBuides);
	}
	
	@Transient
	public ArrayList<Casella> getCasellesBuides(){
		ArrayList<Casella> casellesbuides = new ArrayList<Casella>();
		
		for (int i = 0; i < 16; ++ i){
			Casella cas = caselles[i/4][i%4];
			boolean buida = caselles[i/4][i%4].getCasellaBuida(cas);
			if (buida) casellesbuides.add(cas);	
		}
		
		return casellesbuides;
	}
	
	
	
	public void afegirNumero(ArrayList<Casella> casellesBuides){
		
		Random rand = new Random();
		int ncasella = rand.nextInt(casellesBuides.size());
		Casella cas = casellesBuides.get(ncasella);
		int i = cas.getI();
		int j = cas.getJ();
		int num = cas.getN();
		
		int x  = rand.nextInt()%2;
		if (x == 0) num = 2; 
		else num = 4;
		
		setNumCasella(i,j,num);
	}
	
	

	public void ferMoviment(String tipusMov){
		Casella tauler[][] = getCaselles();
		if(tipusMov.equals("esquerra")){
			for(int i = 0; i < 4; ++i){
				for(int j = 0; j < 4; ++j){
					if(tauler[i][j].getNumero()!=-1){
						desplaça(i,j,tipusMov,tauler[i][j].getNumero());
					}
				}
			}
		}
		if(tipusMov.equals("dreta")){
			for(int i = 0; i < 4; ++i){
				for(int j = 3; j >=0; --j){
					if(tauler[i][j].getNumero()!=-1){
						desplaça(i,j,tipusMov,tauler[i][j].getNumero());
					}
				}
			}
		}
		if(tipusMov.equals("amunt")){
			for(int j = 0; j < 4; ++j){
				for(int i = 0; i < 4; ++i){
					if(tauler[i][j].getNumero()!=-1){
						System.out.println("desplaça");
						desplaça(i,j,tipusMov,tauler[i][j].getNumero());
					}
				}
			}
		}
		if(tipusMov.equals("avall")){
			for(int j = 0; j < 4; ++j){
				for(int i = 3; i >=0; --i){
					if(tauler[i][j].getNumero()!=-1){
						desplaça(i,j,tipusMov,tauler[i][j].getNumero());
					}
				}
			}
		}

		
	}
	
	public void desplaça(int i, int j, String tipusMov, int n){
		int ii = i;
		int jj = j;
		Casella tauler[][] = getCaselles();
		if(tipusMov.equals("amunt")){
			ii--;
			boolean stop = false;
			while(ii>=0 && !stop){
				if(tauler[ii][jj].getN()!=-1){
					stop = true;
					if(tauler[ii][jj].getN()==n){
						setNumCasella(i,j,-1);
						setNumCasella(ii,jj,2*n);
						puntuacio += 2*n;
					}
					else{
						setNumCasella(i,j,-1);
						setNumCasella(ii+1,jj,n);
					}
				}
				--ii;
			}
			if(!stop){
				setNumCasella(i,j,-1);
				setNumCasella(0,jj,n);
			}
		}
		if(tipusMov.equals("avall")){
			boolean stop = false;
			ii++;
			while(ii<4 && !stop){
				if(tauler[ii][jj].getN()!=-1){
					stop = true;
					if(tauler[ii][jj].getN()==n){
						setNumCasella(i,j,-1);
						setNumCasella(ii,jj,2*n);
						puntuacio += 2*n;
					}
					else{
						setNumCasella(i,j,-1);
						setNumCasella(ii-1,jj,n);
					}
				}
				++ii;
			}
			if(!stop){
				setNumCasella(i,j,-1);
				setNumCasella(3,jj,n);
			}
		}
		if(tipusMov.equals("esquerra")){
			jj--;
			boolean stop = false;
			while(jj>=0 && !stop){
				if(tauler[ii][jj].getN()!=-1){
					stop = true;
					if(tauler[ii][jj].getN()==n){
						setNumCasella(i,j,-1);
						setNumCasella(ii,jj,2*n);
						puntuacio += 2*n;
					}
					else{
						setNumCasella(i,j,-1);
						setNumCasella(ii,jj+1,n);
					}
				}
				--jj;
			}
			if(!stop){
				setNumCasella(i,j,-1);
				setNumCasella(ii,0,n);
			}
		}
		if(tipusMov.equals("dreta")){
			boolean stop = false;
			jj++;
			while(jj<4 && !stop){
				if(tauler[ii][jj].getN()!=-1){
					stop = true;
					if(tauler[ii][jj].getN()==n){
						setNumCasella(i,j,-1);
						setNumCasella(ii,jj,2*n);
						puntuacio += 2*n;
					}
					else{
						setNumCasella(i,j,-1);
						setNumCasella(ii,jj-1,n);
					}
				}
				++jj;
			}
			if(!stop){
				setNumCasella(i,j,-1);
				setNumCasella(ii,3,n);
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
			ii = i;
			jj = j -1;
		}
		else if(tipusMov.equals("dreta"))
		{
			ii = i;
			jj = j+1;
		}
		else if(tipusMov.equals("amunt"))
		{
			ii = i-1;
			jj = j;
		}
		else if(tipusMov.equals("avall"))
		{
			ii = i+1;
			jj = j;
		}
		if(ii < 0 || ii > 4 || jj < 0 || jj > 4) movimentcorrecte = false;
		if(movimentcorrecte)
		{
			int num2 = getNumCasella(ii,jj);
			if(num1 == num2)
			{
				setNumCasella(ii,jj,2*num2);
				setNumCasella(i,j,-1);
				puntuacio += 2*num2;
			}
			else if(num2 == -1)
			{
				setNumCasella(ii,jj,num1);
				setNumCasella(i,j,-1);
			}
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
		return estaGuanyada;
	}
	
	public boolean estaPerduda(){		
		boolean perduda = true;
		
		for (int i = 0; i < 4 && perduda; ++i){
			for (int j = 0; j < 4 && perduda; ++j){
				int num = getNumCasella(i,j);
				if (num == -1) perduda = false; 
			}
		}
		
		estaAcabada = perduda;
		return perduda;
	}
	
	public Set<CasAmbNum> casellesAmbNum(){
		Set<CasAmbNum> result = new HashSet<CasAmbNum>();
		
		for(int i = 0; i < 4; ++i){
			for(int j = 0; j < 4; ++j){
				int num = 0;
				int n = caselles[i][j].getN();
				boolean teNumero = (n !=-1);
				if (teNumero){
					CasAmbNum casnum = new CasAmbNum();
					casnum.setI(i);
					casnum.setJ(j);
					casnum.setNumero(n);;
					result.add(casnum);
				}
			}
		}
		
		return result;
	}
}