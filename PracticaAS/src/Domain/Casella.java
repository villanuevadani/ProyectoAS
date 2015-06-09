package Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Casella {

	private CasellaKey primaryKEy;
	@OneToMany 
	private Partida partida;
	
	Casella(){}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}


	@Id
	public CasellaKey getPrimaryKEy() {
		return primaryKEy;
	}
	
	public boolean getCasellaBuida(int cas){
		return false;//TODO
	}
	
	public boolean getInfo(int i, int j, int num){
		return false; //TODO
	}
	
	

	public void setPrimaryKEy(CasellaKey primaryKEy) {
		this.primaryKEy = primaryKEy;
	}
	
	
}
