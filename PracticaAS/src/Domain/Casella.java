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
		primaryKey.setNumero(-1);
	}
	
	Casella(){}

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
	
	public boolean getCasellaBuida(Casella cas){
		boolean buida = false;
		if (primaryKey.getNumero() % 2 != 0) {
			cas = this;
			buida = true;
		}
		
		return buida;
	}
	
	public boolean getInfo(int i, int j, int num){
		i = primaryKey.getNumeroFila();
		j = primaryKey.getNumeroColumna();
		num = primaryKey.getNumero();
		return (num != -1); //devuelve cierto si tiene numero
	}
	
	public int getNumero(){
		return primaryKey.getNumero();
	}

	public void setPrimaryKey(CasellaKey primaryK) {
		this.primaryKey = primaryK;
	}
	
	
}
