package Domain;

public class LoginUseCase {
	
	//private CtrlDataFactory ctrlDataFactory;
	
	public LoginUseCase(){
		//ctrlDataFactory = CtrlDataFactory.getInstance();
	}

	public void Login(String userN, String passwd) throws Exception {
		
		UsuariRegistrat ur = CtrlDataFactory.getCtrlUsuariRegistrat().get(userN); 

		boolean b = ur.passIncorrecte(passwd);
		
		if (!b)  throw new Exception ("Password incorrecte");
	}

}
