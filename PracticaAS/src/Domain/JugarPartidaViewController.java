package Domain;

public class JugarPartidaViewController {
	
	private JugarPartidaUseCase jugarPartidaUc;
	
	public void jugarPartidaPressed(){
		jugarPartidaUc = new JugarPartidaUseCase();
	}
	
	public void sortirPressed(){
		//TODO
		//pot ser que no calgui? s'ha de tancar alguna cosa 
		//a part de les finestres?
	}
	
	public void iniciarSessioPressed(String userN, String passwd) throws Exception{
		jugarPartidaUc.ferAutenticacio(userN, passwd);
		//MANEGAR L'EXCEPCIO A LA VISTA I MOSTRAR SI FALLA EL LOGIN
	}
	
	
	public void consultarRankingPressed(){
		//TODO
	}
	
	public void crearPartidaPressed(){
		jugarPartidaUc.crearPartida();
	}
	
	public ResultFerMovimentPartida direccioPressed(String direccio){
		
		ResultFerMovimentPartida result;
		result = jugarPartidaUc.FerMoviment(direccio);
		return result;
		
	}
	
	public void okPressed(){
		//TODO
	}
	
	
}
