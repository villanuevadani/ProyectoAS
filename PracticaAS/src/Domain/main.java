package Domain;

public class main {
	private static VistaPrincipal vp = new VistaPrincipal();
	private static CreacionDB pn;
	public static void main(String[] args) {
		pn = new CreacionDB();
		vp.start();
	}
}
