package Domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CasellaKey implements Serializable {
	
	private int numero;
	private int numeroFila;
	private int numeroColumna;
	
	public CasellaKey(int num, int nf, int nc){
		this.numero=num;
		this.numeroFila=nf;
		this.numeroColumna=nc;
	}
	
	public CasellaKey(){}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumeroFila() {
		return numeroFila;
	}
	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}
	public int getNumeroColumna() {
		return numeroColumna;
	}
	public void setNumeroColumna(int numeroColumna) {
		this.numeroColumna = numeroColumna;
	}

}
