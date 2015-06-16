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
	}
	
	public void iniciarSessioPressed(String userN, String passwd) throws Exception{
		jugarPartidaUc.ferAutenticacio(userN, passwd);
	}
	
	
	public void consultarRankingPressed(){
	}
	
	public ResultJugarPartida crearPartidaPressed(){
		return jugarPartidaUc.crearPartida();
	}
	
	public ResultFerMovimentPartida direccioPressed(String direccio){
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
	}
	
	
}
