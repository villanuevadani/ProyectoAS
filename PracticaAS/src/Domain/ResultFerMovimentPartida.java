package Domain;

import java.util.Set;

public class ResultFerMovimentPartida {
	private boolean estaAcabada;
	private boolean estaPerduda;
	private int puntuacio;
	private Set<CasAmbNum> casellesAmbNumero;
	
	public boolean isEstaAcabada() {
		return estaAcabada;
	}
	public void setEstaAcabada(boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}
	public boolean isEstaPerduda() {
		return estaPerduda;
	}
	public void setEstaPerduda(boolean estaPerduda) {
		this.estaPerduda = estaPerduda;
	}
	public int getPuntuacio() {
		return puntuacio;
	}
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	public Set<CasAmbNum> getCasellesAmbNumero() {
		return casellesAmbNumero;
	}
	public void setCasellesAmbNumero(Set<CasAmbNum> casellesAmbNumero) {
		this.casellesAmbNumero = casellesAmbNumero;
	}
}
