package Domain;

import java.util.ArrayList;
import java.util.Iterator;

public class TestDomain {

	public static void main(String[] args) {
		//ClaseJugador
		Jugador alex = new Jugador();
		alex.setUsername("uname");
		alex.setCognom("Ramos");
		alex.setEmail("alex.ramos@email.com");
		alex.setNom("Alex");
		alex.setPwd("pass");
		alex.setMillorPuntuacio(100);
		System.out.println(":::Información del Jugador Alex:::");
		System.out.println("Username: "+alex.getUsername());
		System.out.println("Nom: "+alex.getNom());
		System.out.println("Cognom: "+alex.getCognom());
		System.out.println("Email: "+alex.getEmail());
		System.out.println("Password: "+alex.getPwd());
		System.out.println("Millor Puntuacio: "+alex.getMillorPuntuacio());
		System.out.println("");
		System.out.println("");
		
		Jugador jose = new Jugador();
		jose.setUsername("jose05");
		jose.setCognom("Llul");
		jose.setEmail("jose.llul@email.com");
		jose.setNom("Jose");
		jose.setPwd("1234");
		jose.setMillorPuntuacio(2048);
		System.out.println(":::Información del Jugador Jose:::");
		System.out.println("Username: "+jose.getUsername());
		System.out.println("Nom: "+jose.getNom());
		System.out.println("Cognom: "+jose.getCognom());
		System.out.println("Email: "+jose.getEmail());
		System.out.println("Password: "+jose.getPwd());
		System.out.println("Mejor Puntuación: "+jose.getMillorPuntuacio());
		System.out.println("");
		System.out.println("");
		
		//ClasePartida
		Partida pa = new Partida();
		pa.setIdPartida(1);
		pa.setEstaAcabada(true);
		pa.setEstaGuanyada(true);
		pa.setPuntuacio(999);
		pa.setJugadorPartidaActual(alex);		
		pa.setJugadorPartidaJugada(jose);
		System.out.println(":::Información de la partida "+pa.getIdPartida()+ " :::");
		if(pa.isEstaAcabada())System.out.println("Partida acabada!");
		if(! pa.isEstaAcabada())System.out.println("Partida no acabada!");
		if(pa.estaGuanyada())System.out.println("Partida ganada!");
		if(! pa.estaGuanyada())System.out.println("Partida no ganada!");
		System.out.println("Puntuacio: "+pa.getPuntuacio());
		System.out.println("Jugador de la partida actual: "+pa.getJugadorPartidaActual().getNom());
		System.out.println("Jugador de la partida acabada: "+pa.getJugadorPartidaJugada().getNom());
		System.out.println("");
		System.out.println("");
		
		
		//ClaseCasella
		Casella ca= new Casella();	
		CasellaKey ck= new CasellaKey(3,3,7);
		ca.setPrimaryKey(ck);
		ca.setPartida(pa);
		System.out.println(":::Información de la  Casella "+ca.getPrimaryKey().getNumero()+ " :::");
		System.out.println("Numero de la columna "+ca.getPrimaryKey().getNumeroColumna());
		System.out.println("Numero de la fila: "+ca.getPrimaryKey().getNumeroFila());
		System.out.println("Identificador de la partida: "+ca.getPartida().getIdPartida());
		System.out.println("");
		System.out.println("");
		
		Casella ca2= new Casella();	
		CasellaKey ck2= new CasellaKey(1,2,7);
		ca2.setPrimaryKey(ck2);
		ca2.setPartida(pa);
		System.out.println("Información de les caselles: ");
		System.out.println(":::Informació de la  Casella "+ca2.getPrimaryKey().getNumero()+ " :::");
		System.out.println("Numero de la columna "+ca2.getPrimaryKey().getNumeroColumna());
		System.out.println("Numero de la fila: "+ca2.getPrimaryKey().getNumeroFila());
		System.out.println("Identificador de la partida: "+ca2.getPartida().getIdPartida());
		System.out.println("");
		System.out.println("");
		
		Casella ca3= new Casella();	
		CasellaKey ck3= new CasellaKey(2,0,7);
		ca3.setPrimaryKey(ck3);
		ca3.setPartida(pa);
		System.out.println(":::Información de la  Casella "+ca3.getPrimaryKey().getNumero()+ " :::");
		System.out.println("Numero de la columna "+ca3.getPrimaryKey().getNumeroColumna());
		System.out.println("Numero de la fila: "+ca3.getPrimaryKey().getNumeroFila());
		System.out.println("Identificador de la partida: "+ca3.getPartida().getIdPartida());
		System.out.println("");
		System.out.println("");
		
		System.out.println("Información de Partida con las casellas");
	
		
		System.out.println(":::Información de la partida "+pa.getIdPartida()+ " :::");
		if(pa.isEstaAcabada())System.out.println("Partida acabada!");
		if(! pa.isEstaAcabada())System.out.println("Partida no acabada!");
		if(pa.estaGuanyada())System.out.println("Partida ganada!");
		if(! pa.estaGuanyada())System.out.println("Partida no ganada!");
		System.out.println("Puntuacio: "+pa.getPuntuacio());
		System.out.println("Jugador de la partida actual: "+pa.getJugadorPartidaActual().getNom());
		System.out.println("Jugador de la partida acabada: "+pa.getJugadorPartidaJugada().getNom());
		System.out.println("Informacion de las casellas: ");
		
	
		pa.addCasella(ca);
		pa.addCasella(ca2);
		pa.addCasella(ca3);
		//for(int i=0; i<pa.getSizeCaselles(); ++i){
		//	System.out.println("    numero: "+pa.getCasella(i).getPrimaryKey().getNumero()+" Columna: "+pa.getCasella(i).getPrimaryKey().getNumeroColumna()+" Fila: "+pa.getCasella(i).getPrimaryKey().getNumeroFila());
		//}
			
		System.out.println("");
		System.out.println("");
		
		System.out.println("Partidas jugadas del Jose");
		jose.addPartida(pa);
		for(int i=0; i< jose.getSizePartidasJugadas(); ++i){
			System.out.println("    Partida: "+jose.getPartida(i).getIdPartida()+"-> Puntuación: "+jose.getPartida(i).getPuntuacio());
		}
		
		
						
		
	}

}
