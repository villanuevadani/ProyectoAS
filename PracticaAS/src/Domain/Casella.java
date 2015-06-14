package Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Casella {
	
	private CasellaKey primaryKey;
	@OneToMany 
	private Partida partida;
	
	Casella(int cont){
		primaryKey.setNumeroFila(cont/4);
		primaryKey.setNumeroColumna(cont%4);
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}


	@Id
	public CasellaKey getPrimaryKey() {
		return primaryKey;
	}
	
	public boolean getCasellaBuida(int cas){
		return false;//TODO
	}
	
	public boolean getInfo(int i, int j, int num){
		return false; //TODO
	}
	
	public int getNumero(){
		return primaryKey.getNumero();
	}

	public void setPrimaryKey(CasellaKey primaryK) {
		this.primaryKey = primaryK;
	}
	
	
}
