package Domain;

import java.util.Set;

public class ResultJugarPartida {
	int puntInicial;
	int millorPuntuacio;
	Set<CasAmbNum> casAmbNum;
	
	int getPuntInicial(){
		return puntInicial;
	}
	
	void setPuntInicial(int pi){
		puntInicial = pi;
	}
	
	int getMillorPuntuacio(){
		return millorPuntuacio;
	}
	
	void setMillorPuntuacio(int mp){
		millorPuntuacio = mp;
	}
	
	Set<CasAmbNum> getCasAmbNum(){
		return casAmbNum;
	}
	
	void setCasAmbNum(Set<CasAmbNum> casNum){
		casAmbNum = casNum;
	}
}
