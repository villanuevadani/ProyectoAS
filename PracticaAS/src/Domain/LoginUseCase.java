package Domain;

public class LoginUseCase {
	
	//private CtrlDataFactory ctrlDataFactory;
	
	public LoginUseCase(){
		//ctrlDataFactory = CtrlDataFactory.getInstance();
	}

	public void Login(String userN, String passwd) throws Exception {
		
		System.out.println("cr7");
		UsuariRegistrat ur = CtrlDataFactory.getInstance().getCtrlUsuariRegistrat().get(userN); 
		System.out.println("morata");
		boolean b = ur.passIncorrecte(passwd);
		System.out.println("topo");
		if (!b)  throw new Exception ("Password incorrecte");
	}

}
