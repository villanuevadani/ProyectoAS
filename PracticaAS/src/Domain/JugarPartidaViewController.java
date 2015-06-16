package Domain;

public class JugarPartidaViewController {
	
	private JugarPartidaViewController instance;
	
	private JugarPartidaUseCase jugarPartidaUc;
	
	
	public JugarPartidaViewController(){
		jugarPartidaUc = new JugarPartidaUseCase();
	}
	
	public void jugarPartidaPressed(){
		jugarPartidaUc = new JugarPartidaUseCase();
	}
	
	public void sortirPressed(){
		//TODO
		//pot ser que no calgui? s'ha de tancar alguna cosa 
		//a part de les finestres?
	}
	
	public int getPuntuacio(){
		return jugarPartidaUc.getPuntuacio();
	}
	
	public void iniciarSessioPressed(String userN, String passwd) throws Exception{
		jugarPartidaUc.ferAutenticacio(userN, passwd);
		//MANEGAR L'EXCEPCIO A LA VISTA I MOSTRAR SI FALLA EL LOGIN
	}
	
	
	public void consultarRankingPressed(){
		//TODO
	}
	
	public ResultJugarPartida crearPartidaPressed(){
		return jugarPartidaUc.crearPartida();
	}
	
	public ResultFerMovimentPartida direccioPressed(String direccio){
		System.out.println("entrafermov");
		ResultFerMovimentPartida result;
		result = jugarPartidaUc.FerMoviment(direccio);
		return result;
		
	}
	
	public boolean estaAcabada(){
		return jugarPartidaUc.estaAcabada();
	}
	
	public boolean estaGuanyada(){
		return jugarPartidaUc.estaGuanyada();
	}
	
	public void okPressed(){
		//TODO
	}
	
	
}
