package Domain;

import org.apache.log4j.Logger;



public class AdapterServeiEmail implements IAdapterServeiEmail {
	private ServiceLocator sl;
	private String id;
	
	public AdapterServeiEmail() {}
	
	@Override
	public void enviarMissatgeGuanyada(int idPartida, int puntuacio) {
		sl = ServiceLocator.getInstance();
		ServeiEmail semail = sl.find(this.id);
		if(semail==null) try {
			throw new Exception ("No s'ha pogut enviar l'email");
		} catch(Exception ex) {
			Logger.getLogger(ServeiEmail.class.getName()).log(null, ex);
		}		
	}
}
