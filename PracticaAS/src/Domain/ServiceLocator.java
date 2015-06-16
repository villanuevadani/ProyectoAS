package Domain;



public class ServiceLocator {
	private static ServiceLocator instance;
	private ServeiEmail semail;
	
	
	public static ServiceLocator getInstance() {
        if (instance == null) instance = new ServiceLocator();
        return instance;
    }

	public ServeiEmail find(String id) {
		return this.semail;
	}
}
