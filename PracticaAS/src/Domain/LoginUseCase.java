package Domain;

public class LoginUseCase {
	
	private CtrlDataFactory ctrlDataFactory;
	
	public LoginUseCase(CtrlDataFactory cdf){
		ctrlDataFactory = cdf.getInstance();
	}

	public void Login(String userN, String passwd) throws Exception {
		CtrlUsuariRegistrat CtrlUsReg = ctrlDataFactory.getCtrlUsuariRegistrat();
		
		UsuariRegistrat ur = CtrlUsReg.getUsuariRegistrat(userN); //a get usuari
													//ha d'existir la excepcio per si no existeix
		
		boolean b = ur.passIncorrecte(passwd);
		
		if (!b)  throw new Exception ("Password incorrecte");
	}

}
