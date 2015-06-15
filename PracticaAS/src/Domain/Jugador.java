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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
public class Jugador extends UsuariRegistrat implements Serializable {
	
	@Id
	private String email;
	
	
	private int millorPuntuacio; 
	
	private Partida partidaActual;
	
	private ArrayList<Partida> partidasJugadas = new ArrayList<Partida>();
	
	Jugador(){
		super();
		partidasJugadas = new ArrayList<Partida>();
		millorPuntuacio = -1;
	}
	
	Jugador(String uname) {
		super(uname);
		partidasJugadas = new ArrayList<Partida>();
	}
	
	@OneToOne
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
	
	public int getMitjaPuntuacio(){
		int p = -1;
		for(Partida pa : partidasJugadas){
			int a = pa.getPuntuacio();
			if(p == -1) p = a;
			else p+=a;
		}
		if(p!=-1) p/= partidasJugadas.size();
		return p;
	}

	public void setMillorPuntuacio(int millorPuntuacio) {
		this.millorPuntuacio = millorPuntuacio;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(name = "PARTIDASJUG")
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
	
	public Tupla obteTuplaMillor(){
		String s = getUsername();
		int p = getMillorPuntuacio();
		return new Tupla(s,p);
	}
	
	public Tupla obteTuplaMitjana(){
		String s = getUsername();
		int p = getMitjaPuntuacio();
		return new Tupla(s,p);
	}
	
	public void partidaAcabada(int punt, Partida p){
		partidaActual = null;
		partidasJugadas.add(p);
		if (punt > millorPuntuacio) millorPuntuacio = punt;	
	}
}
