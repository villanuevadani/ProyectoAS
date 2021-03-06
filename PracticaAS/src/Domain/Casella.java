package Domain;


public class Casella {
	
	private CasellaKey primaryKey;
	
	private Partida partida;
	
	Casella(int cont){
		primaryKey = new CasellaKey();
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
		return (num != -1); 
	}
	
	public int getI(){
		return primaryKey.getNumeroFila();
	}
	
	public int getJ(){
		return primaryKey.getNumeroColumna();
	}
	
	public int getN(){
		return primaryKey.getNumero();
	}
	
	public int getNumero(){
		return primaryKey.getNumero();
	}

	public void setPrimaryKey(CasellaKey primaryK) {
		this.primaryKey = primaryK;
	}
}
